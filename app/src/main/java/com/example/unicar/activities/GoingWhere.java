package com.example.unicar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unicar.MainActivity;
import com.example.unicar.R;

public class GoingWhere extends AppCompatActivity {

    private TextView etTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_going_where);
        etTo = findViewById(R.id.etTo);
    }

    public void chooseDate(View view) {
        Intent i = new Intent(GoingWhere.this, SelectDateActivity.class);
        i.putExtra("to", etTo.getText().toString());
        startActivity(i);
    }
}