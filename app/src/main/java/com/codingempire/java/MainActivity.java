package com.codingempire.java;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    TextView signUp;
    Button btnSign;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        btnSign = findViewById(R.id.btnSignIn);
        signUp = findViewById(R.id.tvsignup);

        sharedPreferences = getSharedPreferences("MyPrefrences", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("isLoggedIn", false)) {
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }
        btnSign.setOnClickListener(view -> {
            String inputEmail = email.getText().toString();
            String inputPassword = password.getText().toString();

            String savedEmail = sharedPreferences.getString("email", "");
            String savedPass = sharedPreferences.getString("password", "");

            if (inputEmail == savedEmail && inputPassword == savedPass) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("isLoggedIn", true);
                edit.apply();
                Toast.makeText(this, "Login Successful...!!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            } else {
                Toast.makeText(this, "InValid Credentials", Toast.LENGTH_SHORT).show();
            }
        });
        signUp.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, SignUpActivity.class));
        });
    }
}