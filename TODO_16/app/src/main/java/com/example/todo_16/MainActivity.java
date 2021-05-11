package com.example.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private  final LinkedList<String> mList = new LinkedList<>();
    RecyclerView mRecycleView;
    WordListAdapter mAdapter;
    FloatingActionButton mfab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0 ; i<20 ; i++){
            mList.addLast("Word"+ i);
        }
        mRecycleView = findViewById(R.id.recycleview);
        mAdapter = new WordListAdapter(this,mList);
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        mfab = findViewById(R.id.fab);
        mfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordListSize = mList.size();
                //Add a new word to word list
                mList.addLast("+ Word "+ wordListSize);
                //Notify the adapter, that the data has changed
                mRecycleView.getAdapter().notifyItemInserted(wordListSize);
                //Scroll to bottom
                mRecycleView.smoothScrollToPosition(wordListSize);
            }
        });

    }
}