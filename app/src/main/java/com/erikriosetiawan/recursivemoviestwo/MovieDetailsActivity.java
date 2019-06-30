package com.erikriosetiawan.recursivemoviestwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailsActivity extends AppCompatActivity {

    private ImageView imgMovieDetailPoster;
    private TextView tvMovieDetailTitle, tvMovieDetailReleaseDate, tvMovieDetailDescription;
    public static final String MOVIES_KEY = "uM76k90noidu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        imgMovieDetailPoster = findViewById(R.id.img_detail_movie_poster);
        tvMovieDetailTitle = findViewById(R.id.tv_detail_movie_title);
        tvMovieDetailReleaseDate = findViewById(R.id.tv_detail_movie_release_date);
        tvMovieDetailDescription = findViewById(R.id.tv_detail_movie_description);

        Movie movie = getIntent().getParcelableExtra(MovieDetailsActivity.MOVIES_KEY);
        imgMovieDetailPoster.setImageResource(movie.getPoster());
        tvMovieDetailTitle.setText(movie.getTitle());
        tvMovieDetailReleaseDate.setText(movie.getReleaseDate());
        tvMovieDetailDescription.setText(movie.getDescription());

    }
}
