package com.example.myagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btndob,btndate,calculate;
    TextView result;
    DatePickerDialog.OnDateSetListener dateSetListener1,dateSetListener2;   //The listener used to indicate the user has finished selecting a date

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}