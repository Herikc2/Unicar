package com.example.unicar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AcceptValueActivity extends AppCompatActivity {

    ImageView subButton;
    ImageView addButton;

    TextView valueTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_value);

        subButton = findViewById(R.id.sub_button);
        addButton = findViewById(R.id.add_button);
        valueTrip = findViewById(R.id.value_trip);

        subButton.setOnTouchListener(new RepeatListener(400, 100, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueTrip.setText("R$ " + String.format("%.2f", operation("1")));
            }
        }));

        addButton.setOnTouchListener(new RepeatListener(400, 100, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueTrip.setText("R$ " + String.format("%.2f", operation("0")));
            }
        }));

        valueTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AcceptValueActivity.this, MessageToUserActivity.class);
                startActivity(i);
            }
        });
    }

    public void subMoney(View v){
        valueTrip.setText("R$ " + String.format("%.2f", operation("1")));
    }

    public void addMoney(View v){
        valueTrip.setText("R$ " + String.format("%.2f", operation("0")));
    }

    private float operation(String op){
        String value = valueTrip.getText().toString().substring(3); //R - 0 / $ - 1 (Espaço) - 2 / Primeiro Digito - 3
        value = value.replace(',', '.');
        float valueTemp = Float.parseFloat(value);

        if(op.equals("0"))
            valueTemp += 0.10;
        else {
            valueTemp -= 0.10;
            if (valueTemp < 0.0)
                valueTemp = 0;
        }

        return valueTemp;
    }

}
