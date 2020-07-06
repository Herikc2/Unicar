package com.example.unicar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.unicar.usuario.GetHttpService;
import com.example.unicar.usuario.PostHttpService;
import com.example.unicar.usuario.PutHttpService;
import com.example.unicar.usuario.Usuario;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

public class ResetPasswordActivity extends AppCompatActivity {

    TextInputLayout ResetPasswordText;
    TextInputEditText ResetPasswordEdit;
    TextInputLayout ResetNewPasswordText;
    TextInputEditText ResetNewPasswordEdit;
    TextInputLayout ResetConfirmarSenhaText;
    TextInputEditText ResetConfirmarSenhaEdit;

    Button ResetPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        findId();
        disableWarning();

        ResetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryReset();
            }
        });
    }

    private void findId(){
        ResetPasswordText = findViewById(R.id.reset_senha_atual);
        ResetPasswordEdit = findViewById(R.id.reset_senha_atual_edit);
        ResetNewPasswordText = findViewById(R.id.reset_nova_senha);
        ResetNewPasswordEdit = findViewById(R.id.reset_nova_senha_edit);
        ResetConfirmarSenhaText = findViewById(R.id.reset_confirmar_nova_senha);
        ResetConfirmarSenhaEdit = findViewById(R.id.reset_confirmar_nova_senha_edit);
        ResetPasswordButton = findViewById(R.id.reset_password_button);
    }

    private void disableWarning(){
        ResetPasswordEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { ResetPasswordText.setErrorEnabled(false); ResetPasswordText.setError(null);}
        });
        ResetNewPasswordEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { ResetNewPasswordText.setErrorEnabled(false); ResetNewPasswordText.setError(null);}
        });
        ResetConfirmarSenhaEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { ResetConfirmarSenhaText.setErrorEnabled(false); ResetConfirmarSenhaText.setError(null);}
        });
    }

    private void tryReset(){
        if(!validationsEmpty()) {
            Toast.makeText(getApplicationContext(), "É necessário preencher todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!ResetNewPasswordEdit.getText().toString().equals(ResetConfirmarSenhaEdit.getText().toString())) {
            Toast.makeText(getApplicationContext(), "As senhas informadas são diferentes", Toast.LENGTH_LONG).show();
            ResetNewPasswordText.setErrorEnabled(true);
            ResetNewPasswordText.setError("Senha invalida");
            ResetConfirmarSenhaText.setErrorEnabled(true);
            ResetConfirmarSenhaText.setError("Senha invalida");
            return;
        }

        try {
            Usuario user_verify = new GetHttpService(LoginActivity.cod_user).execute().get();

            if(user_verify != null){
                Gson g = new Gson();

                if(!user_verify.getSenha().equals(ResetPasswordEdit.getText().toString())){
                    Toast.makeText(getApplicationContext(), "A senha atual esta incorreta", Toast.LENGTH_LONG).show();
                    ResetPasswordText.setErrorEnabled(true);
                    ResetPasswordText.setError("Senha invalida");
                    return;
                }

                Usuario user = user_verify;
                user.setSenha(ResetConfirmarSenhaEdit.getText().toString());

                if (new PutHttpService(g.toJson(user)).execute().get().equals("true")) {
                    Intent i =  new Intent(ResetPasswordActivity.this, HistoryActivity.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Senha alterada com Sucesso", Toast.LENGTH_LONG).show();
                    ResetPasswordActivity.this.finish();
                }
            }else{
                Toast.makeText(getApplicationContext(), "Erro de Sistema", Toast.LENGTH_LONG).show();
                return;
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean validationsEmpty(){
        boolean ver = true;
        if(ResetPasswordEdit.getText() == null) {
            ver = false;
            ResetPasswordText.setErrorEnabled(true);
            ResetPasswordText.setError("Necessário preencher o campo");
        }
        if(ResetNewPasswordEdit.getText() == null) {
            ver = false;
            ResetNewPasswordText.setErrorEnabled(true);
            ResetNewPasswordText.setError("Necessário preencher o campo");
        }
        if(ResetConfirmarSenhaEdit.getText() == null) {
            ver = false;
            ResetConfirmarSenhaText.setErrorEnabled(true);
            ResetConfirmarSenhaText.setError("Necessário preencher o campo");
        }

        if(ResetPasswordEdit.getText().toString().trim().equals("")) {
            ver = false;
            ResetPasswordText.setErrorEnabled(true);
            ResetPasswordText.setError("Necessário preencher o campo");
        }
        if(ResetNewPasswordEdit.getText().toString().trim().equals("")) {
            ver = false;
            ResetNewPasswordText.setErrorEnabled(true);
            ResetNewPasswordText.setError("Necessário preencher o campo");
        }
        if(ResetConfirmarSenhaEdit.getText().toString().trim().equals("")) {
            ver = false;
            ResetConfirmarSenhaText.setErrorEnabled(true);
            ResetConfirmarSenhaText.setError("Necessário preencher o campo");
        }

        return ver;
    }
}
