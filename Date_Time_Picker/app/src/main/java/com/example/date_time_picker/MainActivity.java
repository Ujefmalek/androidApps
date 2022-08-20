package com.example.date_time_picker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2;
    Button b1,b2;
    int D,M,Y,HH,MM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c=Calendar.getInstance();
                HH=c.get(Calendar.HOUR);
                MM=c.get(Calendar.MINUTE);
                TimePickerDialog tpd=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        tv1.setText("Time : "+i+":"+i1);
                    }
                },HH,MM,false);
                tpd.show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c=Calendar.getInstance();
                D=c.get(Calendar.DAY_OF_MONTH);
                M=c.get(Calendar.MONTH);
                Y=c.get(Calendar.YEAR);
                DatePickerDialog dpd=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tv2.setText("Date : "+i2+"/"+(i1+1)+"/"+i);
                    }
                },Y,M,D);
                dpd.show();
            }
        });
    }
}