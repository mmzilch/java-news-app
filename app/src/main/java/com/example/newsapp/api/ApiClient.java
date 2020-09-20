package com.example.newsapp.api;

import com.example.newsapp.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //public static final String BASE_URL = "http://newsapi.org/v2/";//only one api
        //companion obj = static
    public static Retrofit retrofit;

    public static Retrofit getApiClient(String BASE_URL){//two or three api(baseurl)
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        //build retrofit//create class as obj== new
        }
        return retrofit;
    }


    /*public static ApiInterface apiInterface(){//if two or three api, create interface in another class
        //return retrofit.create(ApiInterface.class)//only one api
        return ApiClient.getApiClient().create(ApiInterface.class);
    }*/


}
