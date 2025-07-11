package com.example.JavaMobileApp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.Gravity;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class CalcActivity extends AppCompatActivity {
    private EditText inputField;
    private TextView resultView;
    private StringBuilder currentInput = new StringBuilder();
    private double lastResult = 0;
    private String lastOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER);
        mainLayout.setPadding(32, 32, 32, 32);

        inputField = new EditText(this);
        inputField.setEnabled(false);
        inputField.setTextSize(24);
        mainLayout.addView(inputField);

        resultView = new TextView(this);
        resultView.setTextSize(20);
        resultView.setGravity(Gravity.END);
        mainLayout.addView(resultView);

        GridLayout grid = new GridLayout(this);
        grid.setColumnCount(4);
        grid.setRowCount(5);
        grid.setPadding(0, 32, 0, 0);
        grid.setAlignmentMode(GridLayout.ALIGN_BOUNDS);
        grid.setUseDefaultMargins(true);

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label : buttons) {
            Button btn = new Button(this);
            btn.setText(label);
            btn.setTextSize(20);
            btn.setOnClickListener(v -> onButtonClick(label));
            grid.addView(btn);
        }

        mainLayout.addView(grid);
        setContentView(mainLayout);
    }

    private void onButtonClick(String label) {
        switch (label) {
            case "+": case "-": case "*": case "/":
                if (currentInput.length() > 0) {
                    lastResult = Double.parseDouble(currentInput.toString());
                    lastOperator = label;
                    // Do not clear input, just append operator
                    currentInput.append(label);
                    inputField.setText(currentInput.toString());
                }
                break;
            case "=":
                try {
                    String expr = currentInput.toString();
                    double result = evaluateExpression(expr);
                    resultView.setText("Result: " + result);
                    currentInput.setLength(0);
                    inputField.setText("");
                    lastOperator = "";
                } catch (Exception e) {
                    resultView.setText("Invalid input");
                }
                break;
            default:
                currentInput.append(label);
                inputField.setText(currentInput.toString());
                break;
        }
    }

    // Simple expression evaluator for two operands and one operator
    private double evaluateExpression(String expr) {
        expr = expr.replaceAll("\\s", "");
        if (expr.contains("+")) {
            String[] parts = expr.split("\\+");
            return Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
        } else if (expr.contains("-")) {
            String[] parts = expr.split("-");
            return Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
        } else if (expr.contains("*")) {
            String[] parts = expr.split("\\*");
            return Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
        } else if (expr.contains("/")) {
            String[] parts = expr.split("/");
            return Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
        }
        return Double.parseDouble(expr);
    }
}
