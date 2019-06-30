package com.erikriosetiawan.recursivemoviestwo;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowsFragment extends Fragment {

    private String[] dataTitle;
    private String[] dataDescription;
    private String[] dataReleaseDate;
    private TypedArray dataPoster;
    private RecyclerView rvCategory;
    private ArrayList<TvShow> tvShows;

    public TvShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tv_shows, container, false);
        rvCategory = rootView.findViewById(R.id.rv_category_tv_shows);
        rvCategory.setHasFixedSize(true);
        prepare();
        addItem();
        showRecyclerList();
        return rootView;
    }

    private void addItem() {
        tvShows = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setTitle(dataTitle[i]);
            tvShow.setDescription(dataDescription[i]);
            tvShow.setReleaseDate(dataReleaseDate[i]);
            tvShow.setPoster(dataPoster.getResourceId(i, -1));
            tvShows.add(tvShow);
        }
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title_tv_shows);
        dataDescription = getResources().getStringArray(R.array.data_description_tv_shows);
        dataReleaseDate = getResources().getStringArray(R.array.data_release_date_tv_shows);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_tv_shows);
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        ListTvShowAdapter listTvShowAdapter = new ListTvShowAdapter(getContext());
        listTvShowAdapter.setListTvShow(tvShows);
        rvCategory.setAdapter(listTvShowAdapter);
    }
}
