package com.example.exercise_16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final EditText e=(EditText)findViewById(R.id.edit);
        Button b=(Button)findViewById(R.id.ok);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Main2Activity.this,MainActivity.class);
                i.putExtra("msg",e.getText().toString());
                startActivity(i);
            }
        });
    }
}
