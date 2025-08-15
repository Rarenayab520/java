package com.codingempire.java;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    TextView tvWelcome;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvWelcome = findViewById(R.id.tvRecieved);
        btnLogout = findViewById(R.id.btnLogout);

        SharedPrefs sharedPrefs = new SharedPrefs(this);
        UserModel user = sharedPrefs.getUser();

        if (user != null) {
            tvWelcome.setText("Welcome " + user.getUsername() + "!");
        } else {
            startActivity(new Intent(HomeActivity.this, MainActivity.class));
            finish();
        }

        btnLogout.setOnClickListener(view -> {
            sharedPrefs.setIsLoggedIn(false);
            sharedPrefs.clear();
            startActivity(new Intent(HomeActivity.this, MainActivity.class));
            finish();
        });
    }
}