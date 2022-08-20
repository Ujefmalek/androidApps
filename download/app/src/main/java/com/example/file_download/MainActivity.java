package com.example.file_download;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText et;
    Button search,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.file);
        et=findViewById(R.id.filepath);
        search=findViewById(R.id.search);
        cancel=findViewById(R.id.Cancel);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path=et.getText().toString().trim();
                Intent i=new Intent(MainActivity.this,download.class);

                File f=new File(path);
                if(f.exists())
                {
                    i.putExtra("exist",true);
                }
                else
                {
                    i.putExtra("exist",false);
                }
                i.putExtra("path",path);
                startActivity(i);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you want to exit ?");
                builder.setTitle("Alert!!");
                builder.setCancelable(false);
                builder.setPositiveButton(
                        "yes",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }
                );
                builder.setNegativeButton("NO",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog ad=builder.create();
                ad.show();
            }
        });
    }
}