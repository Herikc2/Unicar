package com.example.unicar.ride;

import android.os.AsyncTask;
import android.widget.Toast;

import com.example.unicar.MainActivity;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PostHttpService extends AsyncTask<Void, Void, String> {

    private String json;

    public PostHttpService(String json) {
        this.json = json;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String jsonDeResposta = "false";
        String sURL = "http://" + MainActivity.ip + ":8080/UnicarWS/webresources/UnicarRoot/Carona/inserir";

        try {
            URL url = new URL(sURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            PrintStream printStream = new PrintStream(connection.getOutputStream());
            printStream.println(json);

            connection.setConnectTimeout(5000);
            connection.connect();

            // Capture the error in HTTP
            /*
            // Get the response code
            int statusCode = connection.getResponseCode();

            InputStream is = null;

            if (statusCode >= 200 && statusCode < 400) {
                // Create an InputStream in order to extract the response object
                is = connection.getInputStream();
            }
            else {
                is = connection.getErrorStream();
            }*/

            //jsonDeResposta = new Scanner(connection.getInputStream()).next();
            jsonDeResposta = "true";
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch(UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonDeResposta;
    }
}
