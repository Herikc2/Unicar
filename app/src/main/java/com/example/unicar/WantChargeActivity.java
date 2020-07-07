package com.example.unicar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WantChargeActivity extends AppCompatActivity {

    Button yesButton;
    Button noButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_charge);

        yesButton = findViewById(R.id.want_charge_btn_yes);
        noButton = findViewById(R.id.want_charge_btn_no);

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WantChargeActivity.this, AcceptValueActivity.class);
                startActivity(i);
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WantChargeActivity.this, MessageToUserActivity.class);
                startActivity(i);
            }
        });
    }
}
