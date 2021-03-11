package com.jiggy.relifeassignment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.jiggy.relifeassignment.R;
import com.jiggy.relifeassignment.adapters.ArticleAdapter;
import com.jiggy.relifeassignment.models.ArticleModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.jiggy.relifeassignment.utils.Constants.articleURL;

public class MainFragment extends Fragment {

    ArticleAdapter articleAdapter;
    ArrayList<ArticleModel> articleModels = new ArrayList<>();
    RecyclerView recyclerViewArticle;
    RequestQueue requestQueue;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    CircularProgressIndicator progressIndicator;
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewArticle = view.findViewById(R.id.article_recycler);
        progressIndicator = view.findViewById(R.id.cpi);
        requestQueue = Volley.newRequestQueue(getActivity());
        getArticleData();
    }

    public void getArticleData() {
        progressIndicator.setVisibility(View.VISIBLE);
        StringRequest stringRequest=new StringRequest(articleURL,
                response -> {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        if (!jsonArray.isNull(0)) {
                            progressIndicator.setVisibility(View.GONE);
                            articleModels.clear();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String id = jsonObject.optString("id");
                                String title = jsonObject.optString("title");
                                String url = jsonObject.optString("url");
                                String imageUrl = jsonObject.optString("imageUrl");
                                String summary = jsonObject.optString("summary");


                                ArticleModel model = new ArticleModel(id, title, url, imageUrl, summary);
                                articleModels.add(model);
                            }

                            if (articleModels.size() > 0) {
                                articleAdapter = new ArticleAdapter(getActivity(), articleModels,MainFragment.this);
                                recyclerViewArticle.setLayoutManager(new LinearLayoutManager(getActivity()));
                                recyclerViewArticle.setAdapter(articleAdapter);
                            }
                        }




                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getActivity(), "Error while retrieving data", Toast.LENGTH_LONG).show();
                    }
                },
                error -> {
                    Toast.makeText(getActivity(), "Network Error, Check Your network connection.", Toast.LENGTH_LONG).show();

                });

        requestQueue.add(stringRequest);

    }

}