package com.example.and.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    class Number{

        int value;

        public boolean isTriangular(){

            // if N*8+1 is a square number, then N is a triangular number
            double sq = Math.sqrt(value*8+1);

            // math.floor get the integer part from a double
            return (sq - Math.floor(sq)) == 0;

            // https://en.wikipedia.org/wiki/Square_triangular_number
        }

        public boolean isSquared(){

            // if the square root is integer the number is a square number
            double sq = Math.sqrt(value);
            return (sq - Math.floor(sq)) == 0;
        }
    }

    public void checkNumber(View view){

        // check if button was pressed
        Log.i("info", "button pressed");
        String message;

        // take number from the form
        EditText number=(EditText) findViewById(R.id.editText2);
        if (number.getText().toString().isEmpty()){
            message="Please type a number.";
        } else {
            int numberInt = Integer.parseInt(number.getText().toString());

            // use the class Number
            Number testNumber = new Number();
            testNumber.value = numberInt;

            // prepare to print message
            message = number.getText().toString();

            if (testNumber.isSquared() && testNumber.isTriangular()) {
                message += " is a square and a triangular number.";
            } else if (testNumber.isSquared()) {
                message += " is a square number.";
            } else if (testNumber.isTriangular()) {
                message += " is a triangular number.";
            } else {
                message += " is neither triangular nor squared.";
            }
        }
        // show a floating message that desapear after a few seconds
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
        // clean the form
        number.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
