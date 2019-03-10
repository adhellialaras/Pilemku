package com.tupaiaer.cataloguemovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tupaiaer.cataloguemovie.model.Movie;
import com.tupaiaer.cataloguemovie.R;
import com.tupaiaer.cataloguemovie.ui.activity.DetailActivity;

import java.util.List;

import static com.tupaiaer.cataloguemovie.util.GlobalVars.EXTRA_MOVIES;
import static com.tupaiaer.cataloguemovie.util.GlobalVars.IMAGE_BASE_URL;

/**
 * Created by sandypriyatna on 10/03/19
 * github.com/sandypriyatna
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvOverview;
        TextView tvReleaseDate;
        TextView tvVoteAverage;
        ImageView ivPoster;
        Button btnDetail;

        public MovieViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.txt_title);
            tvOverview = v.findViewById(R.id.txt_overview);
            tvReleaseDate = v.findViewById(R.id.txt_release_date);
            tvVoteAverage = v.findViewById(R.id.tv_vote_average);
            ivPoster = v.findViewById(R.id.img_poster);
            btnDetail = v.findViewById(R.id.btn_detail);
        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final MovieViewHolder holder, final int position) {
        holder.tvTitle.setText(movies.get(position).getTitle());
        holder.tvReleaseDate.setText(movies.get(position).getReleaseDate());
        holder.tvOverview.setText(movies.get(position).getOverview());
        holder.tvVoteAverage.setText(movies.get(position).getVoteAverage().toString());
        Glide.with(context).load(IMAGE_BASE_URL + movies.get(position).getPosterPath())
                .into(holder.ivPoster);

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(EXTRA_MOVIES, movies.get(position));
                context.startActivity(intent);
            }
        });

        Log.v("IMG_URL", IMAGE_BASE_URL + movies.get(position).getPosterPath().toString());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
