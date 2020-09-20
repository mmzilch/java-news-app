package com.example.newsapp.api;

import com.example.newsapp.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface ApiInterface {

    @GET("everything")
    Call<News> getNews(
            @Query("q") String keyword,
            @Query("apiKey") String apiKey);
}
