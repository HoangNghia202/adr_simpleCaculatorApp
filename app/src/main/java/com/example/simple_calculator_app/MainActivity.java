package com.example.simple_calculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public TextView firstNum;
    public TextView secondNum;
    public Button btnAdd;
    public Button btnSub;
    public  Button btnDiv;
    public  Button btnMul;

    public  TextView resultShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNum=findViewById(R.id.firstNum);
        secondNum=findViewById(R.id.secondNum);
        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        btnMul=findViewById(R.id.btnMul);
        btnDiv=findViewById(R.id.btnDiv);
        resultShow=findViewById(R.id.showResult);



    }

    public void calculate(View view){


        float floatResult;
        String num1= firstNum.getText().toString();
        String num2=secondNum.getText().toString();

            if (num1.equals("") && num2.equals("")){
                Toast.makeText(getApplicationContext(), "Empty input", Toast.LENGTH_SHORT).show();
            }else{
                if (checkIsNum(num1)&& checkIsNum(num2)){
                    float floatNum1=Float.parseFloat(num1);
                    float floatNum2=Float.parseFloat(num2);
                    int buttonId = view.getId();
                    if (buttonId==R.id.btnAdd){
                        floatResult=floatNum1+floatNum2;
                        showResult(String.format("%.2f", floatResult), "");
                        return;
                    } else if(buttonId==R.id.btnSub){
                        floatResult=floatNum1-floatNum2;
                        showResult(String.format("%.2f", floatResult), "");
                        return;
                    } else if (buttonId==R.id.btnDiv) {
                        if (floatNum2==0){
                            showResult("", "num2 must be equal 0");
                            return;
                        }else {
                            floatResult=floatNum1/floatNum2;
                            showResult(String.format("%.2f", floatResult), "");
                        }
                    } else if (buttonId==R.id.btnMul) {
                        floatResult=floatNum1*floatNum2;
                        showResult(String.format("%.2f", floatResult), "");
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Must enter a number", Toast.LENGTH_SHORT).show();
                }
            }


       
    }
    private boolean checkIsNum(String _number){
        for (char c: _number.toCharArray()) {
            if (Character.isLetter(c)) {
                return false;
            }
        }
        return true;
       
    }

    public void  showResult(String result, String errMsg){
        resultShow.setText("Result: "+ result);
        if (errMsg.length()>0){
            Toast.makeText(getApplicationContext(),"Result: "+ errMsg, Toast.LENGTH_SHORT).show();
        }
    }


}