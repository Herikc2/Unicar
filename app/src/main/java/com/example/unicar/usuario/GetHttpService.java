package com.example.unicar.usuario;

import android.os.AsyncTask;

import com.example.unicar.MainActivity;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GetHttpService extends AsyncTask<Void, Void, Usuario> {

    private String codigo_aluno;

    public GetHttpService(String ca){
        codigo_aluno = ca;
    }

    @Override
    protected Usuario doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
        String sURL = "http://" + MainActivity.ip + ":8080/UnicarWS/webresources/UnicarRoot/Usuario/get/" + this.codigo_aluno;

        try {
            URL url = new URL(sURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while(scanner.hasNext()){
                resposta.append(scanner.next());
            }

            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch(UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson g = new Gson();
        Usuario u = g.fromJson(resposta.toString(), Usuario.class);

        return u;
    }
}
