package com.example.aninterface.week8;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    String PAGE_QUERY = "page";

    @GET("3/movie/top_rated")
    Call<MovieResult> topRatedMovies(@Query(PAGE_QUERY) int page);


    @GET("/movie/upcoming")
    Call<List<MovieResult>> upcomingMovies();

    @GET("/movie/new_playing")
    Call<List<MovieResult>> newPlayingMovies();

}
