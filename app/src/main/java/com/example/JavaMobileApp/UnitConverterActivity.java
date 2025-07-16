package com.example.JavaMobileApp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class UnitConverterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(32, 32, 32, 32);
        layout.setGravity(android.view.Gravity.CENTER);

        TextView title = new TextView(this);
        title.setText("Unit Converter");
        title.setTextSize(24);
        layout.addView(title);

        EditText inputValue = new EditText(this);
        inputValue.setHint("Enter value");
        layout.addView(inputValue);

        String[] units = {"Meter", "Kilometer", "Centimeter", "Millimeter"};
        Spinner fromUnit = new Spinner(this);
        Spinner toUnit = new Spinner(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromUnit.setAdapter(adapter);
        toUnit.setAdapter(adapter);
        layout.addView(fromUnit);
        layout.addView(toUnit);

        Button convertButton = new Button(this);
        convertButton.setText("Convert");
        layout.addView(convertButton);

        TextView resultView = new TextView(this);
        layout.addView(resultView);

        convertButton.setOnClickListener(v -> {
            String valueStr = inputValue.getText().toString();
            if (valueStr.isEmpty()) {
                resultView.setText("Please enter a value.");
                return;
            }
            double value = Double.parseDouble(valueStr);
            String from = fromUnit.getSelectedItem().toString();
            String to = toUnit.getSelectedItem().toString();
            double result = convertUnits(value, from, to);
            resultView.setText(value + " " + from + " = " + result + " " + to);
        });

        setContentView(layout);
    }

    private double convertUnits(double value, String from, String to) {
        double meterValue = value;
        switch (from) {
            case "Kilometer": meterValue = value * 1000; break;
            case "Centimeter": meterValue = value / 100; break;
            case "Millimeter": meterValue = value / 1000; break;
        }
        switch (to) {
            case "Kilometer": return meterValue / 1000;
            case "Centimeter": return meterValue * 100;
            case "Millimeter": return meterValue * 1000;
            default: return meterValue;
        }
    }
}

