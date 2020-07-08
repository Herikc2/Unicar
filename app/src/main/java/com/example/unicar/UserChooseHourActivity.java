package com.example.unicar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.example.unicar.activities.LeavingWhere;

import java.util.Calendar;

public class UserChooseHourActivity extends AppCompatActivity {

    Button button_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choose_hour);

        button_time = findViewById(R.id.button_time);
    }

    public void showTimePickerDialog(View v) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute){
                String timeString;
                if(hour >=0 && hour < 10)
                    if(minute >=0 && minute < 10)
                        timeString = "0" + hour + ":" + "0" + minute;
                    else
                        timeString = "0" + hour + ":" + minute;
                else
                if(minute >=0 && minute < 10)
                    timeString = hour + ":" + "0" + minute;
                else
                    timeString = hour + ":" + minute;

                button_time.setText(timeString);
                Intent i = new Intent(UserChooseHourActivity.this, HowManyUsersActivity.class);
                //i.putExtra("time", timeString);
                startActivity(i);
            }
        }, hour, minute, true);
        timePickerDialog.show();

        //DialogFragment newFragment = new TimePickerFragment();
        //newFragment.show(getSupportFragmentManager(), "timePicker");
    }

}
