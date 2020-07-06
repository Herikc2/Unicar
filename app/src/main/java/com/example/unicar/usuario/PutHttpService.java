package com.example.unicar.usuario;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class PutHttpService extends AsyncTask<Void, Void, String> {

    private String json;

    public PutHttpService(String json) {
        this.json = json;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String jsonDeResposta = "false";
        try {
            String sURL = "http://192.168.0.103:8080/UnicarWS/webresources/UnicarRoot/Usuario/alterar";
            URL url = new URL(sURL);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            PrintStream printStream = new PrintStream(connection.getOutputStream());
            printStream.println(json);

            connection.setConnectTimeout(5000);
            connection.connect();

            //jsonDeResposta = new Scanner(connection.getInputStream()).next();
            connection.disconnect();
            return "true";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonDeResposta;
    }
}
