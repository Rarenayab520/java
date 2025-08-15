package com.codingempire.java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    EditText username, password, email;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        btnSignUp = findViewById(R.id.btnSignUp);
        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        email = findViewById(R.id.etEmail);
        SharedPrefs sharedPrefs = new SharedPrefs(this);


        btnSignUp.setOnClickListener(v -> {

            String userNameString = username.getText().toString().trim();
            String emailString = email.getText().toString().trim();
            String passwordStr = password.getText().toString().trim();

            if (userNameString.isEmpty() || emailString.isEmpty() || passwordStr.isEmpty()) {
                Toast.makeText(this, "Please fill all the feilds", Toast.LENGTH_SHORT).show();
                return;
            }
            UserModel user = new UserModel(userNameString, emailString, passwordStr);
            sharedPrefs.saveUser(user);
            sharedPrefs.setIsLoggedIn(false);

            Toast.makeText(this, "Sign Up Successful! Please login.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SignUpActivity.this, MainActivity.class));
        });
    }
}