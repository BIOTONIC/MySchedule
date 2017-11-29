package ca.wlu.hztw.myschedule.edit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import ca.wlu.hztw.myschedule.R;
import ca.wlu.hztw.myschedule.data.Event;
import ca.wlu.hztw.myschedule.data.EventRepository;
import ca.wlu.hztw.myschedule.main.MainActivity;
import ca.wlu.hztw.myschedule.util.ColorManager;
import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.borax12.materialdaterangepicker.time.RadialPickerLayout;
import com.borax12.materialdaterangepicker.time.TimePickerDialog;
import com.githang.statusbar.StatusBarCompat;

import java.util.Calendar;

public class EditActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private int pos;
    private EditPresenter presenter;
    private EditText editTitle;
    private EditText editTname;
    private EditText editDate;
    private EditText editTime;
    private EditText editNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // presenter-----------------------------------------------------------
        presenter = new EditPresenter(EventRepository.getInstance());

        // toolbar-------------------------------------------------------------
        ColorManager colorManager = ColorManager.getInstance(getResources());
        Toolbar toolbar = (Toolbar) findViewById(R.id.edit_toolbar);
        toolbar.setBackgroundColor(colorManager.getMuted());
        StatusBarCompat.setStatusBarColor(this, colorManager.getMuted());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // find view-----------------------------------------------------------
        editTitle = (EditText) findViewById(R.id.edit_title);
        editTname = (EditText) findViewById(R.id.edit_tname);
        editDate = (EditText) findViewById(R.id.edit_date);
        editTime = (EditText) findViewById(R.id.edit_time);
        editNote = (EditText) findViewById(R.id.edit_note);
        Button editConfirm = (Button) findViewById(R.id.edit_confirm);
        editConfirm.setBackgroundColor(colorManager.getMuted());

        // set value-----------------------------------------------------------
        pos = getIntent().getIntExtra(MainActivity.EDIT_PARAM, -1);
        if (pos >= 0) {
            Event event = presenter.getEvent(pos);
            editTitle.setText(event.getTitle());
            editTname.setText(event.getTname());
            editDate.setText(event.getDate());
            editTime.setText(event.getTimeDuration());
            editNote.setText(event.getNote());
        }

        // setOnClickListener--------------------------------------------------
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

        // setOnClickListener--------------------------------------------------
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

        // setOnClickListener--------------------------------------------------
        editConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTitle.getText().toString();
                String tname = editTname.getText().toString();
                String date = editDate.getText().toString();
                String time = editTime.getText().toString();
                String note = editNote.getText().toString();
                if (pos >= 0) {
                    presenter.updateEvent(pos, title, date, time, note);
                } else {
                    presenter.addEvent(title, tname, date, time, note);
                }
                Intent intent = new Intent();
                intent.putExtra(MainActivity.EDIT_PARAM,pos);
                setResult(RESULT_OK, intent);
                finish();
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
        String time = hourString + ":" + minuteString + "-" + hourStringEnd + ":" + minuteStringEnd;

        editTime.setText(time);
    }
}
