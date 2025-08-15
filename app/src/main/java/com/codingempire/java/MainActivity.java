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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        password = findViewById(R.id.etPassword);
        email = findViewById(R.id.etEmail);
        signUp = findViewById(R.id.tvsignup);
        btnSign = findViewById(R.id.btnSignIn);
       SharedPrefs sharedPrefs=new SharedPrefs(this);
       if(sharedPrefs.isLoggedIn()){
           startActivity(new Intent(MainActivity.this,HomeActivity.class));
           finish();
       }
        btnSign.setOnClickListener(view -> {
            String inputEmail = email.getText().toString();
            String inputPassword = password.getText().toString();
            UserModel savedUser = sharedPrefs.getUser();

            if (savedUser != null && inputEmail.equals(savedUser.getEmail()) && inputPassword.equals(savedUser.getPassword())){

                sharedPrefs.setIsLoggedIn(true);
                Toast.makeText(this, "Login Successful...!!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();
            } else {
                Toast.makeText(this, "InValid Credentials", Toast.LENGTH_SHORT).show();
            }
        });
        signUp.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, SignUpActivity.class));
        });
    }
}