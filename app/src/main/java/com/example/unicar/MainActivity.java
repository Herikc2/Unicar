package com.example.unicar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.unicar.activities.CancelReservationActivity;
import com.example.unicar.activities.CancelSelectedRideActivity;
import com.example.unicar.activities.GoingWhere;
import com.example.unicar.activities.HowManyPassengers;
import com.example.unicar.activities.MainMenu;
import com.example.unicar.activities.ProfileActivity;
import com.example.unicar.activities.SelectDateActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mListLayout;

    private ImageView logoSplash;

    private static final int SPLASH_TIMEOUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        logoSplash = findViewById(R.id.logo_splash);
        mListLayout = findViewById(R.id.splash);

        if(!isConnected(this)){
            Toast.makeText(this, "Você não possui conexão com a internet", Toast.LENGTH_LONG);
        }

        // Comentar animação abaixo para testes
        //animationSplash();

        // Descomentar para Teste de Layout
        Intent i = new Intent(MainActivity.this, MainMenu.class);
        startActivity(i);
    }

    private void animationSplash(){
        Animation animationSplash = AnimationUtils.loadAnimation(this, R.anim.splash_animation);

        logoSplash.startAnimation(animationSplash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent i = new Intent(MainActivity.this,LoginActivity.class);

                Pair pair = new Pair<View, String>(logoSplash, "imageLogoSplashTransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pair);

                startActivity(i, options.toBundle());
                MainActivity.this.finish();
                finish();
            }
        },SPLASH_TIMEOUT);
    }

    private static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
}
