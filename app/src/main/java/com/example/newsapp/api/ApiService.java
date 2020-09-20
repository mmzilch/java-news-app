package com.example.newsapp.api;

import android.util.Log;

import com.example.newsapp.model.News;

import retrofit2.Call;

public class ApiService {//if  there is two or more api

    public static final String BASE_URL = "http://newsapi.org/v2/";//companion obj = static

    public static ApiInterface apiInterface = getApi();//get url

    public static ApiInterface getApi() {//call interface
        apiInterface =
                ApiClient.getApiClient(BASE_URL).create(ApiInterface.class);
        return apiInterface;
    }

    //call fun from apiInterface
    public static Call<News> getNews(String query, String apiKey){
        return apiInterface.getNews(query,apiKey);
    }

    /*public static final String Login_URL = "http://Login";
    public static ApiInterface getLoginApi() {
        return ApiClient.getApiClient(Login_URL).create(ApiInterface.class);
    }*/
}
