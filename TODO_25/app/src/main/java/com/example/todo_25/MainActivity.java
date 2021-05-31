package com.example.todo_25;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editSurname, editMarks, editTextId;
    Button madd,mview,mupdate,mdelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.fname);
        editSurname = findViewById(R.id.lname);
        editMarks = findViewById(R.id.mark);
        editTextId = findViewById(R.id.id);

        madd = findViewById(R.id.add_btn);
        mview = findViewById(R.id.view_btn);
        mupdate = findViewById(R.id.update_btn);
        mdelete = findViewById(R.id.delete_btn);


    }

    public void AddData(){
        madd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(editTextId.getText().toString(),
                        editName.getText().toString(), editSurname.getText().toString(),
                        editMarks.getText().toString());
                if (isInserted == true){
                    Toast.makeText(MainActivity.this,"Data is Inserted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Dtat is not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}