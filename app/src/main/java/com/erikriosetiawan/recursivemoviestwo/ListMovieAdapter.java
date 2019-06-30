package com.erikriosetiawan.recursivemoviestwo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Movie> listMovie;

    public ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    public ListMovieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_list, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvTitle.setText(getListMovie().get(i).getTitle());
        categoryViewHolder.tvDescription.setText(getListMovie().get(i).getDescription());

        Glide.with(context)
                .load(getListMovie().get(i).getPoster())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPoster);

        categoryViewHolder.itemView.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Movie movie = new Movie();
                movie.setTitle(getListMovie().get(position).getTitle());
                movie.setReleaseDate(getListMovie().get(position).getReleaseDate());
                movie.setDescription(getListMovie().get(position).getDescription());
                movie.setPoster(getListMovie().get(position).getPoster());

                Intent dataIntent = new Intent(context, MovieDetailsActivity.class);
                dataIntent.putExtra(MovieDetailsActivity.MOVIES_KEY, movie);
                context.startActivity(dataIntent);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDescription;
        ImageView imgPoster;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            imgPoster = itemView.findViewById(R.id.img_item_poster);
        }
    }
}
