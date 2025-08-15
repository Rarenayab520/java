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
        SharedPrefs sharedPrefs = new SharedPrefs(this);
        UserModel user = sharedPrefs.getUser();
       if (user != null) {
           tvWelcome.setText("Welcome " + user.getUsername() + "!");
       }
        btnLogout.setOnClickListener(view -> {
            sharedPrefs.setIsLoggedIn(false);
            startActivity(new Intent(HomeActivity.this, MainActivity.class));
            finish();
        });


    }
}
