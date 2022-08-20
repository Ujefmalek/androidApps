package com.example.toggle_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton t;
    TextView tv1,tv2,tv3;
    CheckBox cb1,cb2,cb3;
    RadioGroup rg;
    RadioButton rb;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t=findViewById(R.id.TB);
        tv1=findViewById(R.id.TV1);
        tv2=findViewById(R.id.TV2);
        tv3=findViewById(R.id.TV3);
        cb1=findViewById(R.id.CB1);
        cb2=findViewById(R.id.CB2);
        cb3=findViewById(R.id.CB3);
        rg=findViewById(R.id.RG);
        b1=findViewById(R.id.BT1);
        b2=findViewById(R.id.BT2);

        t.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    tv1.setText("Status is : ON");
                }
                else
                {
                    tv1.setText("Status is : OFF");
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1="Your Hobbies : ";
                if(cb1.isChecked())
                {
                    s1=s1+"\n Football";
                }
                if(cb2.isChecked())
                {
                    s1=s1+"\n Travelling";
                }
                if(cb3.isChecked())
                {
                    s1=s1+"\n Reading";
                }
                Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s2="Your gender : ";
                int a=rg.getCheckedRadioButtonId();
                rb=findViewById(a);
                if(a==-1)
                {
                    s2=s2+" Not specified";
                }
                else
                {
                    s2=s2+rb.getText();
                }
                Toast.makeText(getApplicationContext(),s2,Toast.LENGTH_LONG).show();
            }
        });
    }
}