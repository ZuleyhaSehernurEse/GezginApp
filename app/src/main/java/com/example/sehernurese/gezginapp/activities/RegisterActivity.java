package com.example.sehernurese.gezginapp.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sehernurese.gezginapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText etEmail;
    EditText etPassword;
    EditText etPasswordOkay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        etPasswordOkay = (EditText) findViewById(R.id.et_password_okay);
        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String passwordOkay = etPasswordOkay.getText().toString();

                if (email.isEmpty() || password.isEmpty() || passwordOkay.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Email ve parola alanları boş bırakılamaz!", Toast.LENGTH_LONG).show();
                } else if (!password.equals(passwordOkay)) {
                    Toast.makeText(getApplicationContext(), "Parolalar eşleşmiyor!", Toast.LENGTH_LONG).show();
                } else {
                    register(email, password);
                }

            }
        });

    }

    private void register(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Kayıt işlemi başarıyla tamamlandı.", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
