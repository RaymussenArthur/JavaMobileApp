package com.example.JavaMobileApp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.Gravity;
import androidx.appcompat.app.AppCompatActivity;

public class Feature3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        TextView tv = new TextView(this);
        tv.setText("Feature 3 Page");
        tv.setTextSize(24);
        layout.addView(tv);
        setContentView(layout);
    }
}

