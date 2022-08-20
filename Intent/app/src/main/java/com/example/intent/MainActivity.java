package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    Button plus,minus,send;
    TextView score;
    int progress=50;
    static String message="Data : ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.progressBar);
        plus = findViewById(R.id.inr);
        minus = findViewById(R.id.dcr);
        send = findViewById(R.id.Send);
        score = findViewById(R.id.textView);
        pb.setProgress(50);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress=progress+1;
                score.setText(progress+"/200");
                pb.setProgress(progress);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress=progress-1;
                score.setText(progress+"/200");
                pb.setProgress(progress);
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,next_activity.class);
                intent.putExtra(message,progress);
                startActivity(intent);
            }
        });
    }
}