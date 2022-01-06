package com.example.pg9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    Button plus,minus;
    TextView count,reset;
    int mycount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        minus=(Button)findViewById(R.id.minus);
        plus=(Button)findViewById(R.id.plus);
        count=(TextView)findViewById(R.id.text);
        reset=(TextView)findViewById(R.id.reset1);
        plus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                mycount++;
                count.setText(mycount+"");
            }
        });
        minus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                mycount--;
                count.setText(mycount+"");
            }
        });
        reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                mycount=0;
                count.setText(mycount+"");
            }
        });
    }
