package com.example.newsapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.newsapp.R;
import com.example.newsapp.adapter.ArticleListAdapter;
import com.example.newsapp.model.News;
import com.example.newsapp.viewmodel.ArticleViewModel;

public class AriticleListFragment extends Fragment {


    RecyclerView rcyView;
    ProgressBar progressBar;
    TextView textView;
    private ArticleViewModel articleViewModel;
    ArticleListAdapter articleListAdapter = new ArticleListAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ariticle_list, container, false);

        rcyView = root.findViewById(R.id.rcyNews);

        articleViewModel = new ViewModelProvider(this).get(ArticleViewModel.class);

        articleViewModel.loadResult();

        rcyView.setLayoutManager(new LinearLayoutManager(getContext()));
        articleViewModel.getResults().observe(getViewLifecycleOwner(),
                news -> {//alt+enter Observer >>replace with lambda
            articleListAdapter.updateArticle(
                    news.getArticles()
            );
                    Log.d("responsefrag", news.getArticles().toString());
            articleListAdapter.notifyDataSetChanged();
        });

        setupRecyclerView();
        return root;
    }

    private void setupRecyclerView(){
        rcyView.setAdapter(articleListAdapter);
        rcyView.setVisibility(View.VISIBLE);
        //progressBar.setVisibility(View.INVISIBLE);
    }
}