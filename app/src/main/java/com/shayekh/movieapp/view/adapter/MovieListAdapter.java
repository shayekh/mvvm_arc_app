package com.shayekh.movieapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shayekh.movieapp.R;
import com.shayekh.movieapp.service.model.Result;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private Context mContext;
    private List<Result> mList;

    public MovieListAdapter(Context mContext, List<Result> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_single_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mTitle.setText(mList.get(position).getTitle());
        holder.mRating.setText(mList.get(position).getVoteAverage().toString());
        holder.mReleaseDate.setText(mList.get(position).getReleaseDate());
        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w500/" + mList.get(position).getPosterPath())
                .into(holder.imageView);

//        https://image.tmdb.org/t/p/w780//5hNcsnMkwU2LknLoru73c76el3z.jpg

    }

    @Override
    public int getItemCount() {

        if (this.mList != null) {
            return mList.size();
        } else
            return 0;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView mTitle, mRating, mReleaseDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mRating = itemView.findViewById(R.id.rating);
            mReleaseDate = itemView.findViewById(R.id.date);
            imageView = itemView.findViewById(R.id.avatar);
        }
    }
}
