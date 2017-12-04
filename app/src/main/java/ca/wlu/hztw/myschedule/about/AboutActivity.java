package ca.wlu.hztw.myschedule.about;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import ca.wlu.hztw.myschedule.R;
import ca.wlu.hztw.myschedule.util.ColorManager;
import com.githang.statusbar.StatusBarCompat;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // toolbar-------------------------------------------------------------
        ColorManager colorManager = ColorManager.getInstance(getResources());
        Toolbar toolbar = (Toolbar) findViewById(R.id.about_toolbar);
        toolbar.setBackgroundColor(colorManager.getMuted());
        StatusBarCompat.setStatusBarColor(this, colorManager.getMuted());
        setSupportActionBar(toolbar);

        // background color----------------------------------------------------
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.about_layout);
        linearLayout.setBackgroundColor(colorManager.getMuted());
    }
}
