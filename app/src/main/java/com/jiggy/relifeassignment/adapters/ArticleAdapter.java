package com.jiggy.relifeassignment.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jiggy.relifeassignment.R;
import com.jiggy.relifeassignment.fragments.ArticleFragment;
import com.jiggy.relifeassignment.fragments.MainFragment;
import com.jiggy.relifeassignment.models.ArticleModel;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    Context context;
    ArrayList<ArticleModel> articleModels;
    MainFragment fragment;

    public ArticleAdapter(Context context, ArrayList<ArticleModel> articleModels, MainFragment fragment) {
        this.context = context;
        this.articleModels = articleModels;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item_card, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        ArticleModel model = articleModels.get(position);

        holder.tvTitle.setText(model.getTitle());
        holder.tvSummary.setText(model.getSummary());
        Glide.with(context)
                .load(model.getImageUrl())
                .into(holder.imgArticle);


        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArticleModel model = articleModels.get(position);

                Bundle bundle = new Bundle();
                bundle.putString("title",model.getTitle());
                bundle.putString("summary",model.getSummary());
                bundle.putString("imgurl",model.getImageUrl());

                NavHostFragment.findNavController(fragment)
                        .navigate(R.id.action_MainFragment_to_ArticleFragment,bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return articleModels.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {

        LinearLayoutCompat llMain;
        ImageView imgArticle;
        TextView tvTitle, tvSummary;


        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            llMain = itemView.findViewById(R.id.ll_main);
            imgArticle = itemView.findViewById(R.id.img_article);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvSummary = itemView.findViewById(R.id.tv_summary);

        }
    }
}

