package com.example.unicar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unicar.HowManyUsersActivity;
import com.example.unicar.MainActivity;
import com.example.unicar.R;
import com.example.unicar.UserChooseHourActivity;

public class Location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    public void chooseDate(View view) {
        Intent i = new Intent(Location.this, UserChooseHourActivity.class);
        startActivity(i);
    }

    public void choosePassengers(View view) {
        Intent i = new Intent(Location.this, HowManyUsersActivity.class);
        startActivity(i);
    }
}