package com.example.unicar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.unicar.model.Address;
import com.example.unicar.model.Ride;
import com.example.unicar.ride.PostHttpService;
import com.google.gson.Gson;

import java.util.Date;
import java.util.concurrent.ExecutionException;

public class MessageToUserActivity extends AppCompatActivity {

    private Button btnSendRide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_to_user);

        btnSendRide = findViewById(R.id.send_ride);

        btnSendRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpRide();
            }
        });
    }

    private void signUpRide(){
        // Teste
        Ride r = new Ride(new Address("3000", "514"), new Address("300", "200"), new Date(), 5, false, 0, "Ola");
        Gson g = new Gson();

        try {
            if (new PostHttpService(g.toJson(r)).execute().get().equals("true")) {
                Toast.makeText(getApplicationContext(), "Carona Cadastrada com Sucesso", Toast.LENGTH_LONG).show();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
