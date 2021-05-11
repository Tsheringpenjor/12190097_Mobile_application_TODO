package com.example.todo_16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    LinkedList<String> mList;
    LayoutInflater inflater;

    public WordListAdapter(Context context, LinkedList<String> mList){
        inflater = LayoutInflater.from(context);
        this.mList = mList;
    }


    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = inflater.inflate(R.layout.wordlist_item, parent, false);
        return  new WordViewHolder(mItemView,this);

    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView wordItemView;
        WordListAdapter mAdapter;

        public WordViewHolder (@NonNull View itemView, WordListAdapter mAdapter){
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = mList.get(mPosition);
            mList.set(mPosition, " Clicked! "+element);
            mAdapter.notifyDataSetChanged();

        }
    }
}
