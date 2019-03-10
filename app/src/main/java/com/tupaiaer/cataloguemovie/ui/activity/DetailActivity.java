package com.tupaiaer.cataloguemovie.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tupaiaer.cataloguemovie.R;
import com.tupaiaer.cataloguemovie.model.Movie;

import static com.tupaiaer.cataloguemovie.util.GlobalVars.EXTRA_MOVIES;
import static com.tupaiaer.cataloguemovie.util.GlobalVars.IMAGE_BASE_URL;

/**
 * Created by sandypriyatna on 10/03/19
 * github.com/sandypriyatna
 */

public class DetailActivity extends AppCompatActivity {

    private TextView tvTitle, tvVoteAverage, tvReleaseDate, tvOverview;
    private ImageView ivPoster, ivBackdrop;
    private Button btnFavorite;
    private boolean isFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tv_title);
        tvVoteAverage = findViewById(R.id.tv_vote_average);
        tvReleaseDate = findViewById(R.id.tv_release_date);
        tvOverview = findViewById(R.id.tv_overview);
        ivPoster = findViewById(R.id.iv_poster);
        ivBackdrop = findViewById(R.id.iv_backdrop_path);
        btnFavorite = findViewById(R.id.btn_fav);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIES);

        tvTitle.setText(movie.getTitle());
        tvVoteAverage.setText(movie.getVoteAverage().toString());
        tvReleaseDate.setText(movie.getReleaseDate());
        tvOverview.setText(movie.getOverview());

        Glide.with(this)
                .load(IMAGE_BASE_URL + movie.getPosterPath())
                .into(ivPoster);

        Glide.with(this)
                .load(IMAGE_BASE_URL + movie.getBackdropPath())
                .into(ivBackdrop);

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFavorite) {
                    isFavorite = true;
                    btnFavorite.setBackground(getResources().getDrawable(R.drawable.fav_red));
                    Toast.makeText(DetailActivity.this, "Favorit ditambahkan", Toast.LENGTH_SHORT).show();
                } else {
                    isFavorite = false;
                    btnFavorite.setBackground(getResources().getDrawable(R.drawable.fav));
                    Toast.makeText(DetailActivity.this, "Favorit dihapus", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
