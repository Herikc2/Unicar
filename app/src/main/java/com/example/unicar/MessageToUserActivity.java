package com.example.unicar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.unicar.activities.LeavingWhere;
import com.example.unicar.activities.MainMenu;
import com.example.unicar.model.Address;
import com.example.unicar.model.Ride;
import com.example.unicar.ride.PostHttpService;
import com.google.gson.Gson;

import java.util.Date;
import java.util.concurrent.ExecutionException;

public class MessageToUserActivity extends AppCompatActivity {

    private Button btnSendRide;
    EditText messageToUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_to_user);

        btnSendRide = findViewById(R.id.send_ride);
        messageToUser = findViewById(R.id.message_to_user_edit);

        btnSendRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpRide();
            }
        });
    }

    private void signUpRide(){
        /*String paraOndeVai = extras.getString("to");
        String deOndeSai = extras.getString("from");
        String
        String hora = extras.getString("time");
        String numberUsers = extras.getString("numberUsers");
        String value = extras.getString("value");
        String paid = extras.getString("paid");
        String msg = messageToUser.getText().toString();

        boolean paidB = false;
        if(paid.equals("yes"))
            paidB = true;
        else
            paidB = false;

        int cost = 0;
        if(!paidB)
            cost = 0;*/

        String msg = messageToUser.getText().toString();
        LeavingWhere.ride.setMessage(msg);

        // Teste
        LoginActivity.cod_user = "316";
        Address s = LeavingWhere.ride.getStart();
        Address d = LeavingWhere.ride.getDestination();
        Ride r = new Ride(LoginActivity.cod_user, s, d, LeavingWhere.ride.getDate(), LeavingWhere.ride.getSeatAmt(), LeavingWhere.ride.isPaid(), LeavingWhere.ride.getCost(), msg);
        Gson g = new Gson();

        try {
            if (new PostHttpService(g.toJson(r)).execute().get().equals("true")) {
                Toast.makeText(getApplicationContext(), "Carona Cadastrada com Sucesso", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MessageToUserActivity.this, MainMenu.class);
                startActivity(i);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
