package com.example.JavaMobileApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(32, 32, 32, 32);
        layout.setGravity(android.view.Gravity.CENTER);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 24, 0, 24);

        Button buttonCalc = new Button(this);
        buttonCalc.setText("Basic Calculator");
        buttonCalc.setLayoutParams(params);
        layout.addView(buttonCalc);
        buttonCalc.setOnClickListener(v -> startActivity(new Intent(this, CalcActivity.class)));

        Button buttonFeature2 = new Button(this);
        buttonFeature2.setText("Unit Converter");
        buttonFeature2.setLayoutParams(params);
        layout.addView(buttonFeature2);
        buttonFeature2.setOnClickListener(v -> startActivity(new Intent(this, UnitConverterActivity.class)));

        Button buttonFeature3 = new Button(this);
        buttonFeature3.setText("Feature 3");
        buttonFeature3.setLayoutParams(params);
        layout.addView(buttonFeature3);
        buttonFeature3.setOnClickListener(v -> startActivity(new Intent(this, Feature3Activity.class)));

        Button buttonFeature4 = new Button(this);
        buttonFeature4.setText("Feature 4");
        buttonFeature4.setLayoutParams(params);
        layout.addView(buttonFeature4);
        buttonFeature4.setOnClickListener(v -> startActivity(new Intent(this, Feature4Activity.class)));

        setContentView(layout);
    }
}
