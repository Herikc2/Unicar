package com.example.unicar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unicar.R;

public class CancelSelectedRideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_selected_ride_4);
    }

    public void back(View v){
        Intent i = new Intent(CancelSelectedRideActivity.this, CancelReservationActivity.class);
        startActivity(i);
    }
}
