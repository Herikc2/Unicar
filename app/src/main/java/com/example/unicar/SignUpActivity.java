package com.example.unicar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        findId();
        disableHint();
    }

    public void disableHint(){
        // Desativa hint ao clique
        SignCodigoEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) SignCodigoText.setHintEnabled(false); }
        });
        SignNomeEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) SignNomeText.setHintEnabled(false); }
        });
        SignEmailEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) SignEmailText.setHintEnabled(false); }
        });
        SignNumeroEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) SignNumeroText.setHintEnabled(false); }
        });
        SignSenhaEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) SignSenhaText.setHintEnabled(false); }
        });
        SignConfirmarSenhaEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) { if (hasFocus) SignConfirmarSenhaText.setHintEnabled(false); }
        });
    }

    public void findId(){
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
    }
}
