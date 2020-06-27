package com.example.unicar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout LoginSenhaText;
    TextInputEditText LoginSenhaEdit;
    TextInputLayout LoginCodigoText;
    TextInputEditText LoginCodigoEdit;

    TextView textCode;
    TextView textPass;

    Button cadastroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findId();

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        LoginSenhaEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) LoginSenhaText.setHintEnabled(false); }
        });
        LoginCodigoEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) LoginCodigoText.setHintEnabled(false); }
        });
        cadastroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);

                Pair[] pairs = new Pair[4];
                pairs[0] = new Pair<View, String>(LoginSenhaText, "PassTransition");
                pairs[1] = new Pair<View, String>(LoginCodigoText, "CodeTransition");
                pairs[2] = new Pair<View, String>(textCode, "textCodeTransition");
                pairs[3] = new Pair<View, String>(textPass, "textPassTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);

                startActivity(i, options.toBundle());
            }
        });
    }

    public void findId(){
        LoginSenhaText = findViewById(R.id.login_senha);
        LoginSenhaEdit = findViewById(R.id.login_senha_edit);
        LoginCodigoText = findViewById(R.id.login_codigo);
        LoginCodigoEdit = findViewById(R.id.login_codigo_edit);
        cadastroButton = findViewById(R.id.login_cadastro_button);
        textCode = findViewById(R.id.text_code);
        textPass = findViewById(R.id.text_pass);
    }

    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
}
