package com.shayekh.movieapp.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.shayekh.movieapp.service.model.Result;
import com.shayekh.movieapp.service.repository.MovieRepository;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {

    private MovieRepository mRepo;


    public MovieListViewModel(@NonNull Application application) {
        super(application);
        mRepo = MovieRepository.getInstance(application);
    }

    public LiveData<List<Result>> getTopLists()
    {
        return mRepo.getTopMovieLists();
    }
}
