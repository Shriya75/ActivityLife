package com.example.activitylifecycle;
import android.app.DatePickerDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MyDateValidation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_date_validation);

        // Get instance of calendar
        // mCalendar will be set to current/today's date
        final Calendar mCalendar = Calendar.getInstance();
        final DatePickerDialog mDialog
                = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(
                            android.widget.DatePicker view,
                            int mYear, int mMonth, int mDay)
                    {
                        mCalendar.set(Calendar.YEAR, mYear);
                        mCalendar.set(Calendar.MONTH,
                                mMonth);
                        mCalendar.set(Calendar.DAY_OF_MONTH,
                                mDay);
                    }
                },
                mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH));
        final int minDay = 15;
        final int minMonth = 8;
        final int minYear = 2021;
        mCalendar.set(minYear, minMonth - 1, minDay);
        mDialog.getDatePicker().setMinDate(
                mCalendar.getTimeInMillis());

        // Changing mCalendar date from current to
        // some random MAX day 20/08/2021 20 Aug 2021
        final int maxDay = 20;
        final int maxMonth = 8;
        final int maxYear = 2021;
        mCalendar.set(maxYear, maxMonth - 1, maxDay);
        mDialog.getDatePicker().setMaxDate(
                mCalendar.getTimeInMillis());

        // Display the calendar dialog
        mDialog.show();
    }
}