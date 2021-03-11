package com.jiggy.relifeassignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jiggy.relifeassignment.R;
import com.jiggy.relifeassignment.models.ArticleModel;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    Context context;
    ArrayList<ArticleModel> articleModels;

    public ArticleAdapter(Context context, ArrayList<ArticleModel> articleModels) {
        this.context = context;
        this.articleModels = articleModels;
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

