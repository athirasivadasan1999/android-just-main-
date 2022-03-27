package com.example.insert_view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id1,sname1,name1,mark1;
    Button insert1,view1,update1,delete1;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id1=(EditText) findViewById(R.id.id);
        name1=(EditText) findViewById(R.id.name);
        sname1=(EditText) findViewById(R.id.sname);
        mark1=(EditText) findViewById(R.id.mark);

        insert1=(Button)findViewById(R.id.insert);
        view1=(Button)findViewById(R.id.view);
        update1=(Button)findViewById(R.id.update);
        delete1=(Button)findViewById(R.id.delete);

        myDb=new DatabaseHelper(this);

        AddData();
        ViewData();
        UpdateData();
        DeleteData();

    }

    public void DeleteData() {
        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleteRows=myDb.deleteData(id1.getText().toString());
                if(deleteRows > 0)
                {
                    Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Data not deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void UpdateData() {
        update1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdate=myDb.updateData(id1.getText().toString(),name1.getText().toString(),sname1.getText().toString(),mark1.getText().toString());
                if (isUpdate==true)
                {
                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Data not updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void AddData() {
        insert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted=myDb.insertData(id1.getText().toString(),name1.getText().toString(),sname1.getText().toString(),mark1.getText().toString());
                if (isInserted==true)
                {
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void ViewData() {
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=myDb.getAllData();
                if (res.getCount()==0)
                {
                    //SHOW MESSAGE
                    showMessage("Error","Nothing Found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("ID : "+res.getString(0)+"\n");
                    buffer.append("NAME : "+res.getString(1)+"\n");
                    buffer.append("SURNAME : "+res.getString(2)+"\n");
                    buffer.append("MARKS : "+res.getString(3)+"\n");
                }
                //SHOW ALL DATA
                showMessage("Data",buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
