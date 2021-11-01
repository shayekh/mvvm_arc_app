package com.shayekh.movieapp.service.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.shayekh.movieapp.service.model.MovieModel;
import com.shayekh.movieapp.service.model.Result;
import com.shayekh.movieapp.service.network.ApiServices;
import com.shayekh.movieapp.service.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static Context mContext;
    private static MovieRepository instance;
    private MovieModel movieModel;
    private List<Result> mResult;
    private MutableLiveData mLiveData;

    public static MovieRepository getInstance(Context context) {
        if (instance == null) {
            mContext = context;
            instance = new MovieRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Result>> getTopMovieLists() {
        if (mLiveData == null) {
            mLiveData = new MutableLiveData();
        }


        ApiServices apiServices = RetrofitInstance.getRetroInstance().create(ApiServices.class);
        Call<MovieModel> call = apiServices.getTopRatedMovieLists();
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                movieModel = response.body();
                mResult = movieModel.getResults();

                mLiveData.postValue(mResult);


            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });

        return mLiveData;
    }
}
