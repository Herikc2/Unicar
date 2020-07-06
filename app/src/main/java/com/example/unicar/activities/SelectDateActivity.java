package com.example.unicar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import com.example.unicar.MainActivity;
import com.example.unicar.R;

public class SelectDateActivity extends AppCompatActivity {

    private CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_select_date_20);

        calendar = findViewById(R.id.calendarView);
    }

    public void next(View v){
        Intent i = new Intent(SelectDateActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void back(View v){
        Intent i = new Intent(SelectDateActivity.this, MainActivity.class);
        startActivity(i);
    }

}