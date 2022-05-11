package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1;
    EditText number2;
    Button BMI;
    TextView result;
    RadioButton imperial;
    RadioButton metric;
    RadioGroup group;
    Button clear;
    int ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText) findViewById(R.id.mass);
        number2 = (EditText) findViewById(R.id.height);
        BMI = (Button) findViewById(R.id.calc);
        imperial = (RadioButton) findViewById(R.id.radioButton1);
        metric = (RadioButton) findViewById(R.id.radioButton2);
        group = (RadioGroup) findViewById(R.id.group);
        result = (TextView) findViewById(R.id.result);
        clear = (Button) findViewById(R.id.clear);

        BMI.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                double num1 = Double.parseDouble(number1.getText().toString());
                double num2 = Double.parseDouble(number2.getText().toString());

                RadioGroup g = (RadioGroup) findViewById(R.id.group);

                switch (g.getCheckedRadioButtonId()) {
                    case R.id.radioButton1:
                        double bmi1 = num1 / (num2 * num2);

                        result.setText(Double.toString(bmi1));

                        break;

                    case R.id.radioButton2:
                        double bmi2 = (num1 / (num2 * num2)) * 703;

                        result.setText(Double.toString(bmi2));
                        break;
                }

                clear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        result.setText("");
                        number1.setText("");
                        number2.setText("");

                    }
                });
            }
        });
    }
}