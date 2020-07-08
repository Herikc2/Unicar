package com.example.unicar.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import com.example.unicar.R;
import com.example.unicar.UserChooseHourActivity;
import com.example.unicar.model.Address;
import com.example.unicar.model.Ride;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SelectDateActivity extends AppCompatActivity {

    private CalendarView calendar;

    String dateS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date_20);

        calendar = findViewById(R.id.calendarViewWhen);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                dateS = year + "-" + month + "-" + dayOfMonth;
            }
        });
    }

    public void nextUserChooseHour(View v){
        Intent i = new Intent(SelectDateActivity.this, UserChooseHourActivity.class);
        //i.putExtra("date", calendar.getDate());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date dateF = formatter.parse(dateS);
            LeavingWhere.ride = new Ride();
            LeavingWhere.ride.setDate(dateF);
            startActivity(i);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void backGoingWhere(View v){
        Intent i = new Intent(SelectDateActivity.this, GoingWhere.class);
        startActivity(i);
    }

}
