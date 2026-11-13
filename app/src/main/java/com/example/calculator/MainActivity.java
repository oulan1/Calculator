package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonAdd, buttonSubtract, buttonDivide, buttonMultiply, buttonClean;
    private Button buttonPower, buttonSqrt;
    private TextView operation, result;
    private EditText number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        operation = (TextView) findViewById(R.id.operation);
        result = (TextView) findViewById(R.id.result);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonClean = (Button) findViewById(R.id.buttonClean);
        buttonPower = (Button) findViewById(R.id.buttonPower);
        buttonSqrt = (Button) findViewById(R.id.buttonSqrt);

        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonClean.setOnClickListener(this);
        buttonPower.setOnClickListener(this);
        buttonSqrt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.buttonClean) {
            number1.setText("");
            number2.setText("");
            operation.setText("");
            result.setText("");
            return;
        }

        String strNum1 = number1.getText().toString().trim();
        if (strNum1.isEmpty()) {
            Toast.makeText(this, "Введите первое число.", Toast.LENGTH_SHORT).show();
            return;
        }

        float num1 = Float.parseFloat(strNum1);

        if (id == R.id.buttonSqrt) {
            if (num1 < 0) {
                Toast.makeText(this, "Число под корнем должно быть >= 0", Toast.LENGTH_SHORT).show();
                return;
            }
            operation.setText("√");
            number2.setText("");
            float res = (float) Math.sqrt(num1);
            result.setText(String.valueOf(res));
            return;
        }

        String strNum2 = number2.getText().toString().trim();
        if (strNum2.isEmpty()) {
            Toast.makeText(this, "Введите второе число", Toast.LENGTH_SHORT).show();
            return;
        }

        float num2 = Float.parseFloat(strNum2);
        float res = 0;

        if (id == R.id.buttonAdd) {
            operation.setText("+");
            res = num1 + num2;
        } else if (id == R.id.buttonSubtract) {
            operation.setText("-");
            res = num1 - num2;
        } else if (id == R.id.buttonDivide) {
            if (num2 == 0) {
                Toast.makeText(this, "Деление на 0 невозможно", Toast.LENGTH_SHORT).show();
                return;
            }
            operation.setText("/");
            res = num1 / num2;
        } else if (id == R.id.buttonMultiply) {
            operation.setText("*");
            res = num1 * num2;
        } else if (id == R.id.buttonPower) {
            operation.setText("^");
            res = (float) Math.pow(num1, num2);
        }

        result.setText(String.valueOf(res));
    }
}