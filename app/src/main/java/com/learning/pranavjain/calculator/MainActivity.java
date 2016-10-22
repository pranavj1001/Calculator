package com.learning.pranavjain.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private float num1 = 0,num2 = 0;
    private float result;

    private String lower = "";
    private String upper = "";

    EditText editText;
    EditText editText1;

    boolean add = false;
    boolean sub = false;
    boolean mul = false;
    boolean div = false;
    boolean ans = false;
    boolean con = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText1 = (EditText) findViewById(R.id.editText2);

        editText.setEnabled(false);
        editText1.setEnabled(false);

    }

    public void setText(View view){

        //Log.i("Check","Reached here");

        Button numChoice = (Button) view;

        int tag = Integer.parseInt(numChoice.getTag().toString());
        //Log.i("Check",String.valueOf(tag));

        if (tag < 10){
            if(ans && con){
                editText1.setText("");
                editText.setText("");
                lower += String.valueOf(tag);
                editText1.setText(lower);
                ans = false;
                con = false;
            }else {
                lower += String.valueOf(tag);
                editText1.setText(lower);
            }
        }else if (tag > 9 && tag < 100 && tag != 50 && !add && !sub && !div && !mul){
            editText1.setText("");
            if(lower != "") {
                if (tag == 10) {
                    num1 = Float.parseFloat(lower);
                    lower += " + ";
                    add = true;
                }
                if (tag == 11) {
                    num1 = Float.parseFloat(lower);
                    lower += " - ";
                    sub = true;
                }
                if (tag == 12) {
                    num1 = Float.parseFloat(lower);
                    lower += " x ";
                    mul = true;
                }
                if (tag == 13) {
                    num1 = Float.parseFloat(lower);
                    lower += " / ";
                    div = true;
                }
                upper += lower;
                lower = "";
                editText.setText(upper);
            }else{
                con = false;
                if(num1 != 0 ){
                    lower += String.valueOf(num1);
                    if(tag == 10){
                        lower += " + ";
                        add = true;
                    }
                    if(tag == 11){
                        lower += " - ";
                        sub = true;
                    }
                    if(tag == 12){
                        lower += " * ";
                        mul = true;
                    }
                    if(tag == 13){
                        lower += " / ";
                        div = true;
                    }
                    upper += lower;
                    lower = "";
                    editText.setText(upper);
                }else{
                    Toast.makeText(this,"Enter a number",Toast.LENGTH_SHORT).show();
                }
            }

        }else if (tag == 50){
            ans = true;
            con = true;
            editText1.setText("");
            num2 = Float.parseFloat(lower);
            upper += String.valueOf(num2) + " = ";
            editText.setText(upper);
            lower = "";
            if(add){
                result = num1 + num2;
                lower = String.valueOf(result);
                add = false;
            }else if(sub){
                result = num1 - num2;
                lower = String.valueOf(result);
                sub = false;
            }else if (mul){
                result = num1 * num2;
                lower = String.valueOf(result);
                mul = false;
            }else if (div){
                result = num1 / num2;
                lower = String.valueOf(result);
                div = false;
            }else{
                result = num1;
                lower = String.valueOf(result);
            }
            editText1.setText(lower);
            lower = "";
            upper = "";
            num1 = result;
            num2 = 0;
        } else{
            if(tag == 100){
                num1 = 0;
                num2 = 0;
                result = 0;
                add = false;
                sub = false;
                mul = false;
                div = false;
                ans = false;
                lower = "";
                upper = "";
                editText.setText("");
                editText1.setText("");
            }
        }

    }


}
