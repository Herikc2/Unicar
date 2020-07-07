package com.example.unicar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unicar.HowManyUsersActivity;
import com.example.unicar.MainActivity;
import com.example.unicar.R;
import com.example.unicar.UserChooseHourActivity;

public class LocationSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaving_where);
    }

    public void chooseLocate(View view) {
        Intent i = new Intent(LocationSelect.this, UserChooseHourActivity.class);
        startActivity(i);
    }

    public void back(View v){
        Intent i = new Intent(LocationSelect.this, MainActivity.class);
        startActivity(i);
    }
}