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
public class MoviesFragment extends Fragment {

    private String[] dataTitle;
    private String[] dataDescription;
    private String[] dataReleaseDate;
    private TypedArray dataPoster;
    private RecyclerView rvCategory;
    private ArrayList<Movie> movies;

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movies, container, false);
        rvCategory = rootView.findViewById(R.id.rv_category_movies);
        rvCategory.setHasFixedSize(true);
        prepare();
        addItem();
        showRecyclerList();
        return rootView;
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataTitle.length;i++) {
            Movie movie = new Movie();
            movie.setTitle(dataTitle[i]);
            movie.setDescription(dataDescription[i]);
            movie.setReleaseDate(dataReleaseDate[i]);
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movies.add(movie);
        }
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title_movies);
        dataDescription = getResources().getStringArray(R.array.data_description_movies);
        dataReleaseDate = getResources().getStringArray(R.array.data_release_date_movies);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_movies);
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(getContext());
        listMovieAdapter.setListMovie(movies);
        rvCategory.setAdapter(listMovieAdapter);
    }
}
