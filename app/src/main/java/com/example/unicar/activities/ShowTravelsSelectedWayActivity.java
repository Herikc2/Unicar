package com.example.unicar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unicar.MainActivity;
import com.example.unicar.R;

public class ShowTravelsSelectedWayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_travels_selected_way_17);
    }

    public void next(View v){
        Intent i = new Intent(ShowTravelsSelectedWayActivity.this, Location.class);
        startActivity(i);
    }

    public void back(View v){
        Intent i = new Intent(ShowTravelsSelectedWayActivity.this, ReserveSelectedRideActivity.class);
        startActivity(i);
    }

}
