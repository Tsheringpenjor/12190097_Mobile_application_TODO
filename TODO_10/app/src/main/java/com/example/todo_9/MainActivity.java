package com.example.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mResult;
    private calculator mCalculator;
    private EditText mOperator1,mOperator2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOperator1 = findViewById(R.id.Operator1);
        mOperator2 = findViewById(R.id.Operator2);
        mResult = findViewById(R.id.result);

        mCalculator = new calculator();



    }
    public void compute(calculator.operator operator){
        String operandone =  mOperator1.getText().toString();
        String operandtwo = mOperator2.getText().toString();
        String result = "";
        switch (operator){
            case ADD:
                result = String.valueOf(mCalculator.add(Double.valueOf(operandone),Double.valueOf(operandtwo)));
                break;
            case SUB:
                result = String.valueOf(mCalculator.sub(Double.valueOf(operandone),Double.valueOf(operandtwo)));
                break;
            case MUL:
                result = String.valueOf(mCalculator.mul(Double.valueOf(operandone),Double.valueOf(operandtwo)));
                break;
            case DIV:
                result = String.valueOf(mCalculator.div(Double.valueOf(operandone),Double.valueOf(operandtwo)));
                break;
            default:
                Log.d("Invalid Operation","Error in Operation");
                break;
        }
        mResult.setText(result);
    }

    public void add(View view) {
        compute(calculator.operator.ADD);
//        String operandone =  mOperator1.getText().toString();
//        String operandtwo = mOperator2.getText().toString();
//
//        double value = mCalculator.add(Double.valueOf(operandone),Double.valueOf(operandtwo));
    }


    public void sub(View view) {
        compute(calculator.operator.SUB);
    }

    public void mul(View view) {
        compute(calculator.operator.MUL);
    }

    public void div(View view) {
        compute(calculator.operator.DIV);
    }
}