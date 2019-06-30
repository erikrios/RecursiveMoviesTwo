package com.erikriosetiawan.recursivemoviestwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TvShowDetailsActivity extends AppCompatActivity {

    private ImageView imgTvShowDetailPoster;
    private TextView tvTvShowDetailTitle;
    private TextView tvTvShowDetailReleaseDate;
    private TextView tvTvShowDetailDescription;
    public static final String TV_SHOW_KEY = "iH6LArDUO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_details);

        imgTvShowDetailPoster = findViewById(R.id.img_detail_tv_show_poster);
        tvTvShowDetailTitle = findViewById(R.id.tv_detail_tv_show_title);
        tvTvShowDetailReleaseDate = findViewById(R.id.tv_detail_tv_show_release_date);
        tvTvShowDetailDescription = findViewById(R.id.tv_detail_tv_show_description);

        TvShow tvShow = getIntent().getParcelableExtra(TV_SHOW_KEY);
        imgTvShowDetailPoster.setImageResource(tvShow.getPoster());
        tvTvShowDetailTitle.setText(tvShow.getTitle());
        tvTvShowDetailReleaseDate.setText(tvShow.getReleaseDate());
        tvTvShowDetailDescription.setText(tvShow.getDescription());
    }
}
