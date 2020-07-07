package com.example.unicar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unicar.MainActivity;
import com.example.unicar.R;

public class GoingWhere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_going_where);
    }

    public void chooseDate(View view) {
        Intent i = new Intent(GoingWhere.this, SelectDateActivity.class);
        startActivity(i);
    }
}