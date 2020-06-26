package com.example.unicar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout LoginSenhaText;
    TextInputEditText LoginSenhaEdit;
    TextInputLayout LoginCodigoText;
    TextInputEditText LoginCodigoEdit;

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
                startActivity(i);
            }
        });
    }

    public void findId(){
        LoginSenhaText = findViewById(R.id.login_senha);
        LoginSenhaEdit = findViewById(R.id.login_senha_edit);
        LoginCodigoText = findViewById(R.id.login_codigo);
        LoginCodigoEdit = findViewById(R.id.login_codigo_edit);
        cadastroButton = findViewById(R.id.login_cadastro_button);
    }
}
