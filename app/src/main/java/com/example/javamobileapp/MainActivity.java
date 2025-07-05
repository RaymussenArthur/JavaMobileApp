package com.example.javamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewHello;
    private Button buttonChangeText;
    private Button buttonPageCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHello = findViewById(R.id.textViewHello);
        buttonChangeText = findViewById(R.id.buttonChangeText);

        buttonChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewHello.setText("Button Clicked!");
            }
        });

        buttonPageCalc = findViewById(R.id.buttonPageCalc);
        buttonPageCalc.setOnClickListener(view -> startActivity(new Intent(this, CalcActivity.class)));
    }
}
