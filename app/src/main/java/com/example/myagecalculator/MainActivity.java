package com.example.myagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btndob,btntoday,calculate;
    TextView result;
    DatePickerDialog.OnDateSetListener dateSetListener1,dateSetListener2;   //The listener used to indicate the user has finished selecting a date

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btndob=(Button) findViewById(R.id.date_dob);
        btntoday=(Button) findViewById(R.id.date_of_find);
        calculate=(Button) findViewById(R.id.btn_calculate);

        result=(TextView) findViewById(R.id.result);

        Calendar calendar=Calendar.getInstance();
        final int y=calendar.get(Calendar.YEAR);
        final int m=calendar.get(Calendar.MONTH);
        final int d=calendar.get(Calendar.DAY_OF_MONTH);

        final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");   //It allows for formatting Date to Text in Android any given locale
        String date=simpleDateFormat.format(Calendar.getInstance().getTime());

        btntoday.setText(date);

        btndob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,dateSetListener1,y,m,d);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        dateSetListener1=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                btndob.setText(date);
            }
        };

        btntoday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,dateSetListener1,y,m,d);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        dateSetListener2=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                btntoday.setText(date);
            }
        };

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dobdate=btndob.getText().toString();
                String todaydate=btntoday.getText().toString();
                SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date1=simpleDateFormat1.parse(dobdate);
                    Date date2=simpleDateFormat1.parse(todaydate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}