package com.codingempire.java;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {
    EditText username, password, email;
    Button btnSignUp;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        prefs = getSharedPreferences("MyPrefrences", Context.MODE_PRIVATE);
        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        email = findViewById(R.id.etEmail);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(v -> {

            String userStr = username.getText().toString();
            String emailStr = email.getText().toString();
            String passStr = password.getText().toString();

            if (userStr.isEmpty() || emailStr.isEmpty() || passStr.isEmpty()) {
                Toast.makeText(this, "Please fill all the feilds", Toast.LENGTH_SHORT).show();
                return;
            }
            SharedPreferences.Editor edit = prefs.edit();
            edit.putString("username", userStr);
            edit.putString("email", emailStr);
            edit.putString("password", passStr);
            edit.putBoolean("isLoggedIn", false);
            edit.apply();

            Toast.makeText(this, "Sign Up Successful! Please login.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SignUpActivity.this, MainActivity.class));
        });

    }
}