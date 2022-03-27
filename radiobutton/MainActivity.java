package com.example.exercise12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void handleradiobutton(View view)
    {
        boolean checked=((RadioButton)view).isChecked();
        switch (view.getId())
        {
            case R.id.radioM:
                if (checked)
                    displaymessage( "Selected Male");
                break;
            case R.id.radioF:
                if(checked)
                    displaymessage("Selected Female");
                break;
        }
    }
    public void displaymessage(String s)
    {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
