package com.example.unicar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.unicar.usuario.GetHttpService;
import com.example.unicar.usuario.PostHttpService;
import com.example.unicar.usuario.Usuario;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

public class SignUpActivity extends AppCompatActivity {

    TextInputLayout SignCodigoText;
    TextInputEditText SignCodigoEdit;
    TextInputLayout SignNomeText;
    TextInputEditText SignNomeEdit;
    TextInputLayout SignEmailText;
    TextInputEditText SignEmailEdit;
    TextInputLayout SignNumeroText;
    TextInputEditText SignNumeroEdit;
    TextInputLayout SignSenhaText;
    TextInputEditText SignSenhaEdit;
    TextInputLayout SignConfirmarSenhaText;
    TextInputEditText SignConfirmarSenhaEdit;

    Button signUpCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        findId();
        disableHint();

        signUpCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trySignUp();
            }
        });
    }

    private void trySignUp() {

        if(!validationsEmpty()) {
            Toast.makeText(getApplicationContext(), "É necessário preencher todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!SignSenhaEdit.getText().toString().equals(SignConfirmarSenhaEdit.getText().toString())) {
            Toast.makeText(getApplicationContext(), "As senhas informadas são diferentes", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            Gson g = new Gson();

            Usuario user = new Usuario();
            user.setCodigo_aluno(SignCodigoEdit.getText().toString());
            user.setEmail(SignEmailEdit.getText().toString());
            user.setNome(SignNomeEdit.getText().toString());
            user.setNumero(SignNumeroEdit.getText().toString());
            user.setSenha(SignSenhaEdit.getText().toString());

            if(new PostHttpService(g.toJson(user)).execute().get().equals("true")){
                Intent i = new Intent(SignUpActivity.this, HistoryActivity.class);
                startActivity(i);
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean validationsEmpty(){
        boolean ver = true;
        if(SignCodigoEdit.getText() == null) {
            ver = false;
            SignCodigoText.setHintEnabled(false);
            SignCodigoText.setErrorEnabled(true);
            SignCodigoText.setError("Necessário preencher o campo");
        }
        if(SignEmailEdit.getText() == null) {
            ver = false;
            SignEmailText.setHintEnabled(false);
            SignEmailText.setErrorEnabled(true);
            SignEmailText.setError("Necessário preencher o campo");
        }
        if(SignNomeEdit.getText() == null) {
            ver = false;
            SignNomeText.setHintEnabled(false);
            SignNomeText.setErrorEnabled(true);
            SignNomeText.setError("Necessário preencher o campo");
        }
        if(SignNumeroEdit.getText() == null) {
            ver = false;
            SignNumeroText.setHintEnabled(false);
            SignNumeroText.setErrorEnabled(true);
            SignNumeroText.setError("Necessário preencher o campo");
        }
        if(SignSenhaEdit.getText() == null) {
            ver = false;
            SignSenhaText.setErrorEnabled(true);
            SignSenhaText.setError("Necessário preencher o campo");
        }
        if(SignConfirmarSenhaEdit.getText() == null) {
            ver = false;
            SignConfirmarSenhaText.setHintEnabled(false);
            SignConfirmarSenhaText.setErrorEnabled(true);
            SignConfirmarSenhaText.setError("Necessário preencher o campo");
        }

        if(SignCodigoEdit.getText().toString().trim().equals("")) {
            ver = false;
            SignCodigoText.setHintEnabled(false);
            SignCodigoText.setErrorEnabled(true);
            SignCodigoText.setError("Necessário preencher o campo");
        }
        if(SignEmailEdit.getText().toString().trim().equals("")) {
            ver = false;
            SignEmailText.setHintEnabled(false);
            SignEmailText.setErrorEnabled(true);
            SignEmailText.setError("Necessário preencher o campo");
        }
        if(SignNomeEdit.getText().toString().trim().equals("")) {
            ver = false;
            SignNomeText.setHintEnabled(false);
            SignNomeText.setErrorEnabled(true);
            SignNomeText.setError("Necessário preencher o campo");
        }
        if(SignNumeroEdit.getText().toString().trim().equals("")) {
            ver = false;
            SignNumeroText.setHintEnabled(false);
            SignNumeroText.setErrorEnabled(true);
            SignNumeroText.setError("Necessário preencher o campo");
        }
        if(SignSenhaEdit.getText().toString().trim().equals("")) {
            ver = false;
            SignSenhaText.setHintEnabled(false);
            SignSenhaText.setErrorEnabled(true);
            SignSenhaText.setError("Necessário preencher o campo");
        }
        if(SignConfirmarSenhaEdit.getText().toString().trim().equals("")) {
            ver = false;
            SignConfirmarSenhaText.setHintEnabled(false);
            SignConfirmarSenhaText.setErrorEnabled(true);
            SignConfirmarSenhaText.setError("Necessário preencher o campo");
        }

        return ver;
    }

    private void disableHint(){
        // Desativa hint ao clique
        SignCodigoEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) SignCodigoText.setHintEnabled(false); SignCodigoText.setErrorEnabled(false); SignCodigoText.setError(null);}
        });
        SignNomeEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) SignNomeText.setHintEnabled(false); SignNomeText.setErrorEnabled(false); SignNomeText.setError(null);}
        });
        SignEmailEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) SignEmailText.setHintEnabled(false); SignEmailText.setErrorEnabled(false); SignEmailText.setError(null);}
        });
        SignNumeroEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) SignNumeroText.setHintEnabled(false); SignNumeroText.setErrorEnabled(false); SignNumeroText.setError(null);}
        });
        SignSenhaEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) SignSenhaText.setHintEnabled(false); SignSenhaText.setErrorEnabled(false); SignSenhaText.setError(null);}
        });
        SignConfirmarSenhaEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) SignConfirmarSenhaText.setHintEnabled(false); SignConfirmarSenhaText.setErrorEnabled(false); SignConfirmarSenhaText.setError(null);}
        });
    }

    private void findId(){
        SignCodigoText = findViewById(R.id.sign_codigo);
        SignCodigoEdit = findViewById(R.id.sign_codigo_edit);
        SignNomeText = findViewById(R.id.sign_nome);
        SignNomeEdit = findViewById(R.id.sign_nome_edit);
        SignCodigoText = findViewById(R.id.sign_codigo);
        SignCodigoEdit = findViewById(R.id.sign_codigo_edit);
        SignEmailText = findViewById(R.id.sign_email);
        SignEmailEdit = findViewById(R.id.sign_email_edit);
        SignNumeroText = findViewById(R.id.sign_numero);
        SignNumeroEdit = findViewById(R.id.sign_numero_edit);
        SignSenhaText = findViewById(R.id.sign_senha);
        SignSenhaEdit = findViewById(R.id.sign_senha_edit);
        SignConfirmarSenhaText = findViewById(R.id.sign_confirmar_senha);
        SignConfirmarSenhaEdit = findViewById(R.id.sign_confirmar_senha_edit);
        signUpCadastrar = findViewById(R.id.sign_up_button);
    }
}
