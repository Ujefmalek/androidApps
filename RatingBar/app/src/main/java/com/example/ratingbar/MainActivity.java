package com.example.ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button b;
    RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.et1);
        b=findViewById(R.id.button);
        rb=findViewById(R.id.ratingBar);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float f=Float.parseFloat(et.getText().toString());
                rb.setRating(f);
            }
        });
    }
}