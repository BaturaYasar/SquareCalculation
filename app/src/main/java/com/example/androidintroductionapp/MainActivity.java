package com.example.androidintroductionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnWelcome = findViewById(R.id.btnWelcome);
        if (btnWelcome != null) {
            btnWelcome.setOnClickListener(view -> {
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                finish();
            });
        } //if
    }


}