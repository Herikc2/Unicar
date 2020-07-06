package com.example.unicar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unicar.MainActivity;
import com.example.unicar.R;

public class SeeProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_profile_22);
    }

    public void next(View v){
        Intent i = new Intent(SeeProfileActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void back(View v){
        Intent i = new Intent(SeeProfileActivity.this, ShowTravelsSelectedWayActivity.class);
        startActivity(i);
    }

}
