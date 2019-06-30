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

public class ListTvShowAdapter extends RecyclerView.Adapter<ListTvShowAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<TvShow> listTvShow;

    public ListTvShowAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<TvShow> getListTvShow() {
        return listTvShow;
    }

    public void setListTvShow(ArrayList<TvShow> listTvShow) {
        this.listTvShow = listTvShow;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_list, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvTitle.setText(getListTvShow().get(i).getTitle());
        categoryViewHolder.tvDescription.setText(getListTvShow().get(i).getDescription());

        Glide.with(context)
                .load(getListTvShow().get(i).getPoster())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPoster);

        categoryViewHolder.itemView.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                TvShow tvShow = new TvShow();
                tvShow.setTitle(getListTvShow().get(position).getTitle());
                tvShow.setReleaseDate(getListTvShow().get(position).getReleaseDate());
                tvShow.setDescription(getListTvShow().get(position).getDescription());
                tvShow.setPoster(getListTvShow().get(position).getPoster());

                Intent dataIntent = new Intent(context, TvShowDetailsActivity.class);
                dataIntent.putExtra(TvShowDetailsActivity.TV_SHOW_KEY, tvShow);
                context.startActivity(dataIntent);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListTvShow().size();
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
