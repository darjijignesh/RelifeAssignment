package com.jiggy.relifeassignment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.jiggy.relifeassignment.R;

public class ArticleFragment extends Fragment {

    private static final String TAG = "ArticleFragment";
    TextView tvTitle,tvSummary;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    String imgUrl;
    ImageView articleImageView;
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTitle = view.findViewById(R.id.tv_title);
        tvSummary = view.findViewById(R.id.tv_summary);
        articleImageView = view.findViewById(R.id.img_article);


        tvTitle.setText(getArguments().getString("title","No-Data"));
        tvSummary.setText(getArguments().getString("summary","No-Data"));
        imgUrl = getArguments().getString("imgurl", "No-Data");

        if (imgUrl.contains("http")) {
            Glide.with(getActivity())
                    .load(imgUrl)
                    .into(articleImageView);


        }



    }
}