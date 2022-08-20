package com.example.image_switcher;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher imageSwitcher;
    ImageButton ib1,ib2;
    private int[] images = {R.drawable.app_icon,R.drawable.app_icon2};
    private int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib1=findViewById(R.id.imageButton);
        ib2=findViewById(R.id.imageButton2);
        imageSwitcher=findViewById(R.id.imageSwitcher);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imv=new ImageView(MainActivity.this);
                imv.setImageResource(images[position]);
                return imv;
            }
        });
        imageSwitcher.setInAnimation(this, android.R.anim.fade_in);
        imageSwitcher.setOutAnimation(this,android.R.anim.fade_out);

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position>0)
                    position--;
                else if(position<0)
                    position = 0;
                imageSwitcher.setImageResource(images[position]);
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position<images.length)
                    position++;
                if(position>=images.length)
                    position = images.length-1;
                imageSwitcher.setImageResource(images[position]);
            }
        });
    }
}