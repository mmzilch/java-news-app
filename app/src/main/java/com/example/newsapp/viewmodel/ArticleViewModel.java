package com.example.newsapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.api.ApiService;
import com.example.newsapp.model.News;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleViewModel extends ViewModel {

    MutableLiveData<News> results =new MutableLiveData<>();
    MutableLiveData<Boolean> loadError = new MutableLiveData<>();
    MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public MutableLiveData<News> getResults() {
        return results;
    }

    public MutableLiveData<Boolean> getLoadError() {
        return loadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void loadResult(){
        loading.setValue(true);
        String apiKey = "8f39db3aa4ef40ea83d8ff29a4794ef4";
        //apicall
        Call<News> newsCall = ApiService.getNews("technologies",apiKey);

        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                loading.setValue(false);
                results.setValue(
                        response.body()
                );
                Log.d("response", response.body().toString());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                loading.setValue(false);
                loadError.setValue(true);
            }
        });
    }
}
