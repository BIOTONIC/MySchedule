package ca.wlu.hztw.myschedule.edit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import ca.wlu.hztw.myschedule.R;
import ca.wlu.hztw.myschedule.util.ColorManager;
import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.borax12.materialdaterangepicker.time.RadialPickerLayout;
import com.borax12.materialdaterangepicker.time.TimePickerDialog;
import com.githang.statusbar.StatusBarCompat;

import java.util.Calendar;

public class EditActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private EditText editDate;
    private EditText editTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        ColorManager colorManager = ColorManager.getInstance(getResources());
        Toolbar toolbar = (Toolbar) findViewById(R.id.edit_toolbar);
        toolbar.setBackgroundColor(colorManager.getMuted());
        StatusBarCompat.setStatusBarColor(this, colorManager.getMuted());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editDate = (EditText) findViewById(R.id.edit_date);
        editTime = (EditText) findViewById(R.id.edit_time);

        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = com.borax12.materialdaterangepicker.date.DatePickerDialog.newInstance(
                        EditActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setAutoHighlight(true);
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

        editTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        EditActivity.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        false
                );
                tpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                    }
                });
                tpd.show(getFragmentManager(), "Timepickerdialog");
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
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
        ++monthOfYear;
        String monthString = monthOfYear < 10 ? "0" + monthOfYear : "" + monthOfYear;
        String dayString = dayOfMonth < 10 ? "0" + dayOfMonth : "" + dayOfMonth;
        String date = year + "-" + monthString + "-" + dayString;
        editDate.setText(date);
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int hourOfDayEnd, int minuteEnd) {
        String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
        String minuteString = minute < 10 ? "0" + minute : "" + minute;
        String hourStringEnd = hourOfDayEnd < 10 ? "0" + hourOfDayEnd : "" + hourOfDayEnd;
        String minuteStringEnd = minuteEnd < 10 ? "0" + minuteEnd : "" + minuteEnd;
        String time = hourString + ":" + minuteString + " - " + hourStringEnd + ":" + minuteStringEnd;

        editTime.setText(time);
    }
}
