package com.example.prgm7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void clickMethod( View view){
        Toast.makeText(this,"You are always Welcome",Toast.LENGTH_LONG).show();
    }
}
