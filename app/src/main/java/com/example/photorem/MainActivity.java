package com.example.photorem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private String operator = "";
    private String firstNumber;
    private boolean firstZero = true;
    private  boolean dotPoint = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.input);


    }

    public void ClickNumber(View view)
    {
        if(firstZero){
            editText.setText("");
            firstZero = false;
        }

        String number = editText.getText().toString();
        int id = view.getId();
        if (id == R.id.one) {
            number += "1";
        } else if (id == R.id.two) {
            number += "2";
        } else if (id == R.id.three) {
            number += "3";
        } else if (id == R.id.four) {
            number += "4";
        } else if (id == R.id.five) {
            number += "5";
        } else if (id == R.id.six) {
            number += "6";
        } else if (id == R.id.seven) {
            number += "7";
        } else if (id == R.id.eight) {
            number += "8";
        } else if (id == R.id.nine) {
            number += "9";
        } else if (id == R.id.dot && dotPoint) {
            dotPoint = false;
            if(number.equals("")){
                number += "0.";
            }else {
                number += ".";
            }
        } else if (id == R.id.zero && !number.equals("") && !number.equals("0") && !number.equals("-0")) {
            number += "0";
        } else {
            if(number.equals("")){
                number = "0";
                firstZero = true;
            }
        }
        editText.setText(number);
    }

    public void PlusMinus(View view) {
        String number = editText.getText().toString();
        if (!number.equals("") && !number.equals("0")) {
            if (number.charAt(0) == '-') {
                number = number.substring(1);
            } else {
                number = "-" + number;
            }

        }
        editText.setText(number);
    }






    public void BackSpace(View view)
    {
        String input = editText.getText().toString();

        if(input.charAt(0) == '-' && input.length() == 2){
            input = input.substring(1);
        }


        if(input.length() > 1){
            if(input.charAt(input.length() - 1) == '.'){
                dotPoint = true;
            }
            input = input.substring(0,input.length() - 1);
        }else{
            input = "0";
            firstZero = true;
            dotPoint = true;
        }

        if(input.equals("0")){
            firstZero = true;
        }


        editText.setText(input);
    }

    public void EC(View view){
        editText.setText("0");
        operator = "";
        firstZero = true;
        dotPoint = true;
    }


    @SuppressLint("SetTextI18n")
    public void Operator(View view){

        firstNumber = editText.getText().toString();
        editText.setText("0");
        firstZero = true;
        dotPoint = true;


        int id = view.getId();
        if (id == R.id.plus) {
            operator = "+";
        } else if (id == R.id.minus) {
            operator = "-";
        } else if (id == R.id.divide) {
            operator = "/";
        } else if (id == R.id.multiply) {
            operator = "*";
        }

    }

    @SuppressLint("SetTextI18n")
    public void Result(View view){
        double result = 0.0;
        dotPoint = false;
        String secondNumber = editText.getText().toString();

        if (Objects.equals(operator, "+")) {
            result = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
        } else if (Objects.equals(operator, "-")) {
            result = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
        } else if (Objects.equals(operator, "/")) {
            result = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
        } else if (Objects.equals(operator, "*")) {
            result = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
        }


        editText.setText(result+"");
    }

    @SuppressLint("SetTextI18n")
    public void Percentage(View view){

        double result;
        if(operator.equals("")){
            String firstNumber = editText.getText().toString();
            result = Double.parseDouble(firstNumber) / 100.0;
            editText.setText(result+"");
        }else{
            String secondNumber = editText.getText().toString();
            result = Double.parseDouble(firstNumber) / (100.0 / Double.parseDouble(secondNumber));
            editText.setText(result+"");
        }
    }



}