package com.example.todo_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private ArrayList<Sport> mSportData;
    private SportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the Recycle View
        mRecycleView = findViewById(R.id.recycleview);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //Set Layout Manager
        mRecycleView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        //Initialize the arraylist that contain data
        mSportData = new ArrayList<>();
        //Initialize the adapter and set it at the RecycleView
        mAdapter = new SportsAdapter(this,mSportData);
        mRecycleView.setAdapter(mAdapter);


        //get the data
        initializeData();
    }

    private void initializeData() {
        //get the resources from the string xml file
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_image);
        String[] sportsList = getResources().getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        //Clear the existing data (to avoid duplication)
        mSportData.clear();
        //sportsImageResources.recycle();

        //Create the ArrayList of Sports obj with the titles and information
        for(int i=0;i<sportsList.length;i++){
            mSportData.add(new Sport(sportsList[i],sportsInfo[i],sportsImageResources.getResourceId(i,0)));
        }
        //Notify the Adapter of the change
        mAdapter.notifyDataSetChanged();

    }
}