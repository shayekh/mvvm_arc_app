package com.shayekh.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.shayekh.movieapp.service.model.Result;
import com.shayekh.movieapp.view.adapter.MovieListAdapter;
import com.shayekh.movieapp.viewmodel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieListViewModel movieListViewModel;
    private MovieListAdapter movieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(linearLayoutManager);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        //Observable
        movieListViewModel.getTopLists().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                movieListAdapter = new MovieListAdapter(MainActivity.this,results);
                recyclerView.setAdapter(movieListAdapter);

            }
        });

    }
}