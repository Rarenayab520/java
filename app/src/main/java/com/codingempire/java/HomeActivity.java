package com.codingempire.java;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    TextView tvWelcome;
    Button btnLogout;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        tvWelcome = findViewById(R.id.tvRecieved);
        btnLogout = findViewById(R.id.btnLogout);
        prefs = getSharedPreferences("MyPrefrences", MODE_PRIVATE);
        String username = prefs.getString("username", "User");

        tvWelcome.setText("Welcome " + username + "!");

        btnLogout.setOnClickListener(view -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("isLoggedIn", false);
            editor.apply();
            startActivity(new Intent(HomeActivity.this,MainActivity.class));
            finish();
        });


    }
}
