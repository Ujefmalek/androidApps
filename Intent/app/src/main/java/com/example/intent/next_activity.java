package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class next_activity extends AppCompatActivity {
    TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        data=findViewById(R.id.tv);

       Intent intent = getIntent();
       int progress = intent.getIntExtra(MainActivity.message,0);
        data.setText("Received Number : "+progress);
    }
}