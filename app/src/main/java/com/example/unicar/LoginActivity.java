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

import com.example.unicar.usuario.GetHttpService;
import com.example.unicar.usuario.Usuario;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout LoginSenhaText;
    TextInputEditText LoginSenhaEdit;
    TextInputLayout LoginCodigoText;
    TextInputEditText LoginCodigoEdit;

    TextView textCode;
    TextView textPass;

    Button cadastroButton;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findId();

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        LoginSenhaEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    LoginSenhaText.setHintEnabled(false);
                    LoginSenhaText.setErrorEnabled(false);
                    LoginSenhaText.setError(null);
                }
            }
        });
        LoginCodigoEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    LoginCodigoText.setHintEnabled(false);
                    LoginCodigoText.setErrorEnabled(false);
                    LoginCodigoText.setError(null);
                }
            }
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

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryLogin();
            }
        });
    }

    private void tryLogin(){
        if(!validations()) {
            Toast.makeText(getApplicationContext(), "É necessário preencher todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            Usuario user = new GetHttpService(LoginCodigoEdit.getText().toString()).execute().get();

            if(user == null)
                Toast.makeText(getApplicationContext(), "Usuario ou senha incorretos", Toast.LENGTH_SHORT).show();
            else
                if(user.getSenha().equals(LoginSenhaEdit.getText().toString())){
                    Intent i = new Intent(LoginActivity.this, HistoryActivity.class);
                    startActivity(i);
                }


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean validations(){
        boolean ver = true;
        if(LoginCodigoEdit.getText() == null) {
            ver = false;
            LoginCodigoText.setHintEnabled(false);
            LoginCodigoText.setErrorEnabled(true);
            LoginCodigoText.setError("Necessário preencher o campo");
        }
        if(LoginSenhaEdit.getText() == null) {
            ver = false;
            LoginSenhaText.setHintEnabled(false);
            LoginSenhaText.setErrorEnabled(true);
            LoginSenhaText.setError("Necessário preencher o campo");
        }
        if(LoginCodigoEdit.getText().toString().trim().equals("")) {
            ver = false;
            LoginCodigoText.setHintEnabled(false);
            LoginCodigoText.setErrorEnabled(true);
            LoginCodigoText.setError("Necessário preencher o campo");
        }
        if(LoginSenhaEdit.getText().toString().trim().equals("")) {
            ver = false;
            LoginSenhaText.setHintEnabled(false);
            LoginSenhaText.setErrorEnabled(true);
            LoginSenhaText.setError("Necessário preencher o campo");
        }

        return ver;
    }

    private void findId(){
        LoginSenhaText = findViewById(R.id.login_senha);
        LoginSenhaEdit = findViewById(R.id.login_senha_edit);
        LoginCodigoText = findViewById(R.id.login_codigo);
        LoginCodigoEdit = findViewById(R.id.login_codigo_edit);
        cadastroButton = findViewById(R.id.login_cadastro_button);
        loginButton = findViewById(R.id.login_button);
        textCode = findViewById(R.id.text_code);
        textPass = findViewById(R.id.text_pass);
    }

    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
}
