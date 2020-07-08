package com.example.unicar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unicar.R;
import com.example.unicar.model.Address;
import com.example.unicar.model.Ride;

public class LeavingWhere extends AppCompatActivity {

    public static Ride ride;
    private TextView tvFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaving_where);
        tvFrom = findViewById(R.id.etFrom);

        ride = new Ride();
    }

    public void history(View view) {
        Intent i = new Intent(LeavingWhere.this, GoingWhere.class);
        //i.putExtra("from", tvFrom.getText().toString());
        Address ad = new Address(tvFrom.getText().toString());
        ride.setStart(ad);
        startActivity(i);
    }
}
