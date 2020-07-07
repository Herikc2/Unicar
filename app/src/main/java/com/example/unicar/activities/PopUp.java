package com.example.unicar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unicar.HistoryActivity;
import com.example.unicar.MainActivity;
import com.example.unicar.R;

public class PopUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_1);
    }

    public void closePopUp(View view) {
        Intent i = new Intent(PopUp.this, MainActivity.class);
        startActivity(i);
    }
}