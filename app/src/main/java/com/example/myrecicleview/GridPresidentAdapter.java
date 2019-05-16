package com.example.myrecicleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridPresidentAdapter extends RecyclerView.Adapter<GridPresidentAdapter.GridViewHolder> {
    private Context contextgrid;
    private ArrayList<President> gridPresident;

    public ArrayList<President> getGridPresident() {
        return gridPresident;
    }

    public void setGridPresident(ArrayList<President> gridPresident) {
        this.gridPresident = gridPresident;
    }

    public GridPresidentAdapter(Context context) {
        this.contextgrid = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_president, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int position) {
        Glide.with(contextgrid).load(getGridPresident().get(position).getPhoto()).apply(new RequestOptions().override(350, 350)).into(gridViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getGridPresident().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}