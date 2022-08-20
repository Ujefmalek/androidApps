package com.example.optionmenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.imageView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.Rectangle:
                // do your code
                iv.setImageResource(R.drawable.rect);
                return true;
            case R.id.Circle:
                // do your code
                iv.setImageResource(R.drawable.circle);
                return true;
            case R.id.Triangle:
                // do your code
                iv.setImageResource(R.drawable.triangle);
                return true;
            case R.id.Line:
                // do your code
                iv.setImageResource(R.drawable.line);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}