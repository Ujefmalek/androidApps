package com.example.progressbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText[] tv=new EditText[8];
    ProgressBar pb;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv[0]=findViewById(R.id.et11);
        tv[1]=findViewById(R.id.et22);
        tv[2]=findViewById(R.id.et33);
        tv[3]=findViewById(R.id.et44);
        tv[4]=findViewById(R.id.et55);
        tv[5]=findViewById(R.id.et66);
        tv[6]=findViewById(R.id.et77);
        tv[7]=findViewById(R.id.et88);
        pb=findViewById(R.id.progressBar);
        b=findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View view) {
                int count=8;
                for(int i=0;i<8;i++)
                {
                    if(tv[i].getText().toString().trim().equals(""))
                        --count;
                }
                pb.setAccessibilityPaneTitle("Field set");
                pb.setProgress((int) (count*12.5));
            }
        });
    }
}