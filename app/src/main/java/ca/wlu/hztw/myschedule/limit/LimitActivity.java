package ca.wlu.hztw.myschedule.limit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import ca.wlu.hztw.myschedule.R;
import ca.wlu.hztw.myschedule.data.EventRepository;
import ca.wlu.hztw.myschedule.data.LimitRepository;
import ca.wlu.hztw.myschedule.event.EventPresenter;
import ca.wlu.hztw.myschedule.util.ColorManager;
import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.githang.statusbar.StatusBarCompat;
import com.borax12.materialdaterangepicker.time.RadialPickerLayout;
import com.borax12.materialdaterangepicker.time.TimePickerDialog;

import java.util.Calendar;

public class LimitActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener {

    public final static String POS = "pos";

    private int pos;
    private LimitPresenter presenter;
    private EditText limitDate;
    private EditText limitTime;
    private Button limitConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limit);

        // presenter-----------------------------------------------------------
        presenter = new LimitPresenter(LimitRepository.getInstance());

        // toolbar-------------------------------------------------------------
        ColorManager colorManager = ColorManager.getInstance(getResources());
        Toolbar toolbar = (Toolbar) findViewById(R.id.limit_toolbar);
        toolbar.setTitle("Select Available Time");
        toolbar.setBackgroundColor(colorManager.getVibrant());
        StatusBarCompat.setStatusBarColor(this, colorManager.getVibrant());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // find view-----------------------------------------------------------
        limitDate = (EditText) findViewById(R.id.limit_date);
        limitTime = (EditText) findViewById(R.id.limit_time);
        limitConfirm = (Button) findViewById(R.id.limit_confirm);
        limitConfirm.setBackgroundColor(colorManager.getVibrant());

        // set value-----------------------------------------------------------
        pos = getIntent().getIntExtra(POS, -1);
        if(pos>0){
            limitDate.setText(presenter.getDate(pos));
            limitDate.setText(presenter.getTime(pos));
        }

        // setOnClickListener--------------------------------------------------
        limitDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = com.borax12.materialdaterangepicker.date.DatePickerDialog.newInstance(
                        LimitActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setAutoHighlight(true);
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

        // setOnClickListener--------------------------------------------------
        limitTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        LimitActivity.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        false
                );
                tpd.show(getFragmentManager(), "Timepickerdialog");
            }
        });

        // setOnClickListener--------------------------------------------------
        limitConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = limitDate.getText().toString();
                String time = limitTime.getText().toString();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent data = new Intent();
        this.setResult(RESULT_CANCELED, data);
    }

    @Override
    public void onDateSet(com.borax12.materialdaterangepicker.date.DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
        String monthString = monthOfYear < 10 ? "0" + monthOfYear : "" + monthOfYear;
        String dayString = dayOfMonth < 10 ? "0" + dayOfMonth : "" + dayOfMonth;
        String date = year + "-" + monthString + "-" + dayString;
        limitDate.setText(date);
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int hourOfDayEnd, int minuteEnd) {
        String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
        String minuteString = minute < 10 ? "0" + minute : "" + minute;
        String hourStringEnd = hourOfDayEnd < 10 ? "0" + hourOfDayEnd : "" + hourOfDayEnd;
        String minuteStringEnd = minuteEnd < 10 ? "0" + minuteEnd : "" + minuteEnd;
        String time = hourString + ":" + minuteString + "-" + hourStringEnd + ":" + minuteStringEnd;
        limitTime.setText(time);
    }
}
