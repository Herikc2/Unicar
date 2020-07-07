package com.example.unicar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.unicar.MainActivity;
import com.example.unicar.R;

public class CancelReservationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_reservation);
    }

    public void backToMenu(View v){
        Intent i = new Intent(CancelReservationActivity.this, MainMenu.class);
        startActivity(i);
    }
}
