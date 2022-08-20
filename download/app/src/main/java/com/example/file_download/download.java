package com.example.file_download;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class download extends AppCompatActivity {
    TextView tv;
    ProgressBar pb;
    Button download;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        tv=findViewById(R.id.filefound);
        pb=findViewById(R.id.progressBar);
        download=findViewById(R.id.download);

        Intent intent=getIntent();
        String str=intent.getStringExtra("path");
        tv.setText(tv.getText().toString()+str);

        boolean check=intent.getBooleanExtra("exist",true);
        if(!check)
        {
           // tv.setText("File not found");
            tv.setText(tv.getText().toString());
            download.setEnabled(false);
        }
        else
        {
            download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pb.setVisibility(View.VISIBLE);
                    for(int i=0;i<101;i++)
                    {
                        try {
                            TimeUnit.MILLISECONDS.sleep(50);
                            pb.setProgress(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    AlertDialog.Builder builder=new AlertDialog.Builder(com.example.file_download.download.this);
                    builder.setMessage("Download complete!!");
                    builder.setTitle("Alert!!");
                    builder.setCancelable(true);
                    builder.setPositiveButton(
                            "OK",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                   dialogInterface.cancel();
                                }
                            }
                    );
                    builder.setNegativeButton("OkN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    pb.setVisibility(View.INVISIBLE);
                }
            });
        }
    }
}