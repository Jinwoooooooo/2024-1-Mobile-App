package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private String currentInput = "";
    private String operator = "";
    private double operand1 = 0;
    private double operand2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        setNumberButtonListeners();
        setOperatorButtonListeners();
    }

    private void setNumberButtonListeners() {
        int[] numberButtonIds = {
                R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3,
                R.id.btn_4, R.id.btn_5, R.id.btn_6,
                R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_dot
        };

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                currentInput += button.getText().toString();
                display.setText(currentInput);
                animateButton(button);
            }
        };

        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setOperatorButtonListeners() {
        int[] operatorButtonIds = {
                R.id.btn_add, R.id.btn_subtract,
                R.id.btn_multiply, R.id.btn_divide, R.id.btn_equals, R.id.btn_clear
        };

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                String text = button.getText().toString();

                if (text.equals("C")) {
                    clear();
                } else if (text.equals("=")) {
                    calculateResult();
                } else {
                    setOperator(text);
                }
                animateButton(button);
            }
        };

        for (int id : operatorButtonIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setOperator(String op) {
        if (!currentInput.isEmpty()) {
            operand1 = Double.parseDouble(currentInput);
            currentInput = "";
            operator = op;
        }
    }

    private void calculateResult() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            operand2 = Double.parseDouble(currentInput);
            double result = 0;

            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }

            display.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            operator = "";
        }
    }

    private void clear() {
        currentInput = "";
        operator = "";
        operand1 = 0;
        operand2 = 0;
        display.setText("0");
    }

    private void animateButton(Button button) {
        Animation anim = new AlphaAnimation(0.3f, 1.0f);
        anim.setDuration(300);
        button.startAnimation(anim);
    }
}
