package com.example.unicar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.unicar.activities.MainMenu;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mListLayout;

    private ImageView logoSplash;

    private static final int SPLASH_TIMEOUT = 1000;
    public static final String ip = "192.168.0.103";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        logoSplash = findViewById(R.id.logo_splash);
        mListLayout = findViewById(R.id.splash);

        // Comentar animação abaixo para testes
        //animationSplash();

        // Descomentar para Teste de Layout
        Intent i = new Intent(MainActivity.this, UserChooseHourActivity.class);
        startActivity(i);
    }

    public void animationSplash(){
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

    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
}
