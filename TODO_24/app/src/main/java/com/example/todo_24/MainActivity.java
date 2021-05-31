package com.example.todo_24;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private int mColor;
    private TextView mShowCountTextview;

    private final String COUNT_KEY = "count";
    private final String COLOR_KEY= "color";

    private SharedPreferences mPreference;
    private String sharedProfile = "com.example.todo_24";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCountTextview = findViewById(R.id.count_textview);
        mColor = ContextCompat.getColor(this,R.color.default_background);

        mPreference = getSharedPreferences(sharedProfile,MODE_PRIVATE);
        mCount = mPreference.getInt(COUNT_KEY,0);
        mShowCountTextview.setText(String.format("%s",mCount));
        mColor = mPreference.getInt(COLOR_KEY,mColor);
        mShowCountTextview.setBackgroundColor(mColor);


//        if (savedInstanceState != null){
//            mCount = savedInstanceState.getInt(COUNT_KEY);
//            if (mCount != 0 ){
//                mShowCountTextview.setText(String.format("%s",mCount));
//            }
//            mColor = savedInstanceState.getInt(COLOR_KEY);
//            mShowCountTextview.setBackgroundColor(mColor);
//        }
    }

    public void changeBackground(View view) {
        int color = ((ColorDrawable) view.getBackground()).getColor();
        mShowCountTextview.setBackgroundColor(color);
        mColor = color;
    }

    public void countUp(View view) {
        mCount++;
        mShowCountTextview.setText(String.format("%s",mCount));
    }

//    @Override
//    protected void onSaveInstanceState(@Nullable Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        outState.putInt(COUNT_KEY,mCount);
//        outState.putInt(COLOR_KEY,mColor);
//    }

    public void reset(View view) {
        mCount = 0;
        mShowCountTextview.setText(String.format("%s",mCount));

        mColor = ContextCompat.getColor(this,R.color.default_background);
        mShowCountTextview.setBackgroundColor(mColor);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor = mPreference.edit();
        preferencesEditor.putInt(COUNT_KEY, mCount);
        preferencesEditor.putInt(COLOR_KEY, mColor);
        preferencesEditor.apply();
    }
}