package com.example.spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] dept={"Computer","IT","Electronics","Civil","Mechanical"};
    AlertDialog.Builder builder;
    ListView lv;
    String[] prog_lang={"C","C++","JAVA","PYTHON","DART"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner s=findViewById(R.id.spinner);
        s.setOnItemSelectedListener(this);

        ArrayAdapter aa=new ArrayAdapter(this, android.R.layout.simple_spinner_item,dept);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(aa);

        builder=new AlertDialog.Builder(this);

        lv=findViewById(R.id.LV);
        ArrayAdapter laa=new ArrayAdapter(this, android.R.layout.simple_list_item_1,android.R.id.text1,prog_lang);
        lv.setAdapter(laa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value=laa.getItem(i).toString();
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        builder.setMessage(dept[i]+" Selected").setCancelable(true).setPositiveButton("OK",null);
        AlertDialog alert = builder.create();
        alert.setTitle("Your Department : ");
        alert.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}