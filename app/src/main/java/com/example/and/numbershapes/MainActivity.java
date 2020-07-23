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
            double sq = Math.sqrt(value*8+1);
            return (sq - Math.floor(sq)) == 0;
            // https://en.wikipedia.org/wiki/Square_triangular_number
        }

        public boolean isSquared(){
            double sq = Math.sqrt(value);
            return (sq - Math.floor(sq)) == 0;
        }
    }

    public void checkNumber(View view){
        Log.i("info", "button pressed");
        EditText number=(EditText) findViewById(R.id.editText2);
        int numberInt= Integer.parseInt(number.getText().toString());
        Number testNumber= new Number();
        testNumber.value=numberInt;
        String message;

        if (testNumber.isSquared() && testNumber.isTriangular()){
            message=numberInt+" is a square and a triangular number at the same time.";
        } else if (testNumber.isSquared()){
            message=numberInt+" is a square number.";
        } else if (testNumber.isTriangular()){
            message=numberInt+" is a triangular number.";
        } else {
            message=numberInt+" is not triangular or squared.";
        }

        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
        number.setText("");

    }
    //n(n+1)/2
    //n^2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
