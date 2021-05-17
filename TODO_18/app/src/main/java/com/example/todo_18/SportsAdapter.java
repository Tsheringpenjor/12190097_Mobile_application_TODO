package com.example.todo_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {

    private ArrayList<Sport> mSportsData;
    private Context mContext;

    SportsAdapter(Context context, ArrayList<Sport> sportsData){
        this.mSportsData = sportsData;
        this.mContext = context;
    }


    @NonNull
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdapter.ViewHolder holder, int position) {
        //get current sport
        Sport currentSport = mSportsData.get(position);
        //populate the textview with data
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSportsData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTitletext,mInfotext;
        private ImageView mSportImage;

        ViewHolder(View itemView){
            super(itemView);
            mSportImage = itemView.findViewById(R.id.sport_img);
            mTitletext = (TextView)itemView.findViewById(R.id.Title);
            mInfotext = (TextView)itemView.findViewById(R.id.subTitle);

        }

        void bindTo(Sport currentSport){
            mTitletext.setText(currentSport.getTitle());
            mInfotext.setText(currentSport.getInfo());
            Glide.with(mContext).load(currentSport.getImageResource()).into(mSportImage);

        }
    }

}
