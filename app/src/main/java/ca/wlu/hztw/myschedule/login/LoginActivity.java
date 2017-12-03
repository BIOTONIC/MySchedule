package ca.wlu.hztw.myschedule.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.*;

import ca.wlu.hztw.myschedule.R;
import ca.wlu.hztw.myschedule.main.MainActivity;
import ca.wlu.hztw.myschedule.util.ColorManager;
import com.githang.statusbar.StatusBarCompat;

import static ca.wlu.hztw.myschedule.main.MainActivity.PREFS_NAME;

public class LoginActivity extends AppCompatActivity {

    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "qwer:qwer", "1234:1234"
    };

    private UserLoginTask authTask = null;

    private AutoCompleteTextView nameView;
    private EditText passwordView;
    private ProgressBar progressBar;
    private View loginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // toolbar-------------------------------------------------------------
        ColorManager colorManager = ColorManager.getInstance(getResources());
        Toolbar toolbar = (Toolbar) findViewById(R.id.login_toolbar);
        toolbar.setBackgroundColor(colorManager.getMuted());
        StatusBarCompat.setStatusBarColor(this, colorManager.getMuted());
        setSupportActionBar(toolbar);

        // background color----------------------------------------------------
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.login_linear_layout);
        linearLayout.setBackgroundColor(colorManager.getMuted());

        // find view & set listener--------------------------------------------
        nameView = (AutoCompleteTextView) findViewById(R.id.login_name);
        passwordView = (EditText) findViewById(R.id.login_password);
        passwordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        loginFormView = findViewById(R.id.login_form);
        progressBar = (ProgressBar) findViewById(R.id.login_progress);
        progressBar.setProgressTintList(ColorStateList.valueOf(colorManager.getVibrant()));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }

    // check text format before login
    private void attemptLogin() {
        if (authTask != null) {
            return;
        }

        // reset errors.
        nameView.setError(null);
        passwordView.setError(null);

        // store values at the time of the login attempt.
        String email = nameView.getText().toString();
        String password = passwordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordView.setError("Invalid Password");
            focusView = passwordView;
            cancel = true;
        }

        // check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            nameView.setError("Empty Name");
            focusView = nameView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            nameView.setError("Invalid Name");
            focusView = nameView;
            cancel = true;
        }

        if (cancel) {
            // there was an error
            focusView.requestFocus();
        } else {
            // show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            authTask = new UserLoginTask(email, password);
            authTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        return email.length() > 2;
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 2;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            loginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
            progressBar.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
            loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String email;
        private final String password;

        UserLoginTask(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(email)) {
                    if (!pieces[1].equals(password)) {
                        return false;
                    }
                    SharedPreferences userInfo = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = userInfo.edit();
                    editor.putBoolean("isLoggedIn", true);
                    if (email.equals("qwer")) {
                        editor.putString("name", "qwer");
                        editor.putInt("id", 1);
                        editor.putString("email", "qwer@mylaurier.ca");
                        editor.putInt("type", 0);// student 0

                    } else {
                        editor.putString("name", "1234");
                        editor.putInt("id", 2);
                        editor.putString("email", "1234@mylaurier.ca");
                        editor.putInt("type", 1);// teacher 1
                    }
                    editor.commit();
                    return true;
                }
            }
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            authTask = null;
            showProgress(false);

            if (success) {
                finish();
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            } else {
                passwordView.setError("Invalid Password");
                passwordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            authTask = null;
            showProgress(false);
        }
    }
}

