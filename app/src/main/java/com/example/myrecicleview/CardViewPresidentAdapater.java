package com.example.myrecicleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewPresidentAdapater extends RecyclerView.Adapter<CardViewPresidentAdapater.CardViewHolder> {

    private Context contextcardview;
    private ArrayList<President> cardviewpresident;

    public CardViewPresidentAdapater(Context context) {
        this.contextcardview = context;
    }

    public ArrayList<President> getCardviewPresident() {
        return cardviewpresident;
    }

    public void setCardviewPresident(ArrayList<President> cardviewPresident) {
        this.cardviewpresident = cardviewPresident;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_president, viewGroup, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
        President p = getCardviewPresident().get(i);
        Glide.with(contextcardview).load(p.getPhoto()).apply(new RequestOptions().override(350, 350)).into(cardViewHolder.imgPhoto);

        cardViewHolder.tvName.setText(p.getName());
        cardViewHolder.tvRemarks.setText(p.getRemarks());

        cardViewHolder.btnFaforite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(contextcardview, "Faforite "+getCardviewPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        cardViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(contextcardview,"Share "+getCardviewPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getCardviewPresident().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFaforite, btnShare;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnFaforite = itemView.findViewById(R.id.btn_set_faforite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}
