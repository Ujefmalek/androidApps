package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    EditText f1;
    Button add,sub,mul,div,ansB;
    Button key[]=new Button[12];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ansB=findViewById(R.id.ansB);

        f1= findViewById(R.id.f1);

        add=findViewById(R.id.Add);
        sub= findViewById(R.id.Sub);
        mul=findViewById(R.id.Mul);
        div=findViewById(R.id.Div);

        key[0]=findViewById(R.id.num1);
        key[1]=findViewById(R.id.num2);
        key[2]=findViewById(R.id.num3);
        key[3]=findViewById(R.id.num4);
        key[4]=findViewById(R.id.num5);
        key[5]=findViewById(R.id.num6);
        key[6]=findViewById(R.id.num7);
        key[7]=findViewById(R.id.num8);
        key[8]=findViewById(R.id.num9);
        key[9]=findViewById(R.id.num_);
        key[10]=findViewById(R.id.num0);
        key[11]=findViewById(R.id.numc);

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"+");
            }
        });
        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"-");
            }
        });
        mul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"*");
            }
        });
        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"/");
            }
        });

        key[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"1");
            }
        });
        key[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"2");
            }
        });
        key[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"3");
            }
        });
        key[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"4");
            }
        });
        key[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"5");
            }
        });
        key[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"6");
            }
        });
        key[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"7");
            }
        });
        key[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"8");
            }
        });
        key[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"9");
            }
        });
        key[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+".");
            }
        });
        key[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setText(f1.getText()+"0");
            }
        });
        key[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setText("");
            }
        });

        ansB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stack<Integer> op  = new Stack<Integer>();
                Stack<Double> val = new Stack<Double>();
                /* Create temporary stacks for operators and operands */
                Stack<Integer> optmp  = new Stack<Integer>();
                Stack<Double> valtmp = new Stack<Double>();
                /* Accept expression */
                String input = f1.getText().toString();
                input = "0" + input;
                input = input.replaceAll("-","+-");
                /* Store operands and operators in respective stacks */
                String temp = "";
                for (int i = 0;i < input.length();i++)
                {
                    char ch = input.charAt(i);
                    if (ch == '-')
                        temp = "-" + temp;
                    else if (ch != '+' &&  ch != '*' && ch != '/')
                        temp = temp + ch;
                    else
                    {
                        val.push(Double.parseDouble(temp));
                        op.push((int)ch);
                        temp = "";
                    }
                }
                val.push(Double.parseDouble(temp));
                /* Create char array of operators as per precedence */
                /* -ve sign is already taken care of while storing */
                char operators[] = {'/','*','+'};
                /* Evaluation of expression */
                for (int i = 0; i < 3; i++)
                {
                    boolean it = false;
                    while (!op.isEmpty())
                    {
                        int optr = op.pop();
                        double v1 = val.pop();
                        double v2 = val.pop();
                        if (optr == operators[i])
                        {
                            /* if operator matches evaluate and store in temporary stack */
                            if (i == 0)
                            {
                                valtmp.push(v2 / v1);
                                it = true;
                                break;
                            }
                            else if (i == 1)
                            {
                                valtmp.push(v2 * v1);
                                it = true;
                                break;
                            }
                            else if (i == 2)
                            {
                                valtmp.push(v2 + v1);
                                it = true;
                                break;
                            }
                        }
                        else
                        {
                            valtmp.push(v1);
                            val.push(v2);
                            optmp.push(optr);
                        }
                    }
                    /* Push back all elements from temporary stacks to main stacks */
                    while (!valtmp.isEmpty())
                        val.push(valtmp.pop());
                    while (!optmp.isEmpty())
                        op.push(optmp.pop());
                    /* Iterate again for same operator */
                    if (it)
                        i--;
                }
                f1.setText(val.pop().toString());
            }
        });
    }
}