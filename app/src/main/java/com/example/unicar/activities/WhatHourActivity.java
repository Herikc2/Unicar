package com.example.unicar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unicar.R;

public class WhatHourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_hour);
    }

    public void next(View v){
        Intent i = new Intent(WhatHourActivity.this, Location.class);
        startActivity(i);
    }

    public void back(View v){
        Intent i = new Intent(WhatHourActivity.this, SelectDateActivity.class);
        startActivity(i);
    }

}
