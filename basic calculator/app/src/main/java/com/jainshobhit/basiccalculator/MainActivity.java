package com.jainshobhit.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button calculate;
    EditText number1;
    EditText number2;
    EditText operator;
    TextView output;
    double ans=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = findViewById(R.id.calculate);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        output = findViewById(R.id.output);
        operator = findViewById(R.id.operator);

        calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(number1.getText().toString());
                double num2 = Double.parseDouble(number2.getText().toString());
                String sign = operator.getText().toString();


                switch (sign) {
                    case "+":
                        ans = num1 + num2;
                        output.setText(Double.toString(ans));
                        break;
                    case "-":
                        ans = num1 - num2;
                        output.setText(Double.toString(ans));
                        break;
                    case "*":
                        ans = num1 * num2;
                        output.setText(Double.toString(ans));
                        break;
                    case "/":
                        ans = num1 / num2;
                        output.setText(Double.toString(ans));
                        break;
                    default:
                        output.setText(R.string.warning);
                        break;
                }
            }
        });
    }
}