package com.example.unicar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unicar.MainActivity;
import com.example.unicar.R;

public class ReserveSelectedRideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_selected_ride_21);
    }

    public void next(View v){
        Intent i = new Intent(ReserveSelectedRideActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void reserve(View v){
        Intent i = new Intent(ReserveSelectedRideActivity.this, PopUp2.class);
        startActivity(i);
    }

    public void back(View v){
        Intent i = new Intent(ReserveSelectedRideActivity.this, MainActivity.class);
        startActivity(i);
    }

}
