package com.example.todo_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private int i = 100;
    private int data = 100;
    private TextView mShowCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.textView);

        if ( savedInstanceState != null){
            mCount = savedInstanceState.getInt("count");
            mShowCount.setText(String.valueOf(mCount));
        }
    }

    public void countup(View view) {
        mCount++;
        if(mCount==data){
            Toast toast = Toast.makeText(this,"Data = "+data+"",Toast.LENGTH_LONG);
            toast.show();
            data+=1;
        }
        if (mShowCount!=null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count",mCount);
    }
}