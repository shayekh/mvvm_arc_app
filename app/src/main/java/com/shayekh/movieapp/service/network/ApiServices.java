package com.shayekh.movieapp.service.network;

import com.shayekh.movieapp.service.model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("3/movie/top_rated?api_key=d190aafd3961f2cdd74cca833628f95d&language=en-US&page=1")
    Call<MovieModel> getTopRatedMovieLists();


}
