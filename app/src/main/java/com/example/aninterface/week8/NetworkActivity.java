package com.example.aninterface.week8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.aninterface.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkActivity extends AppCompatActivity {

    private static final String TAG = "NetworkActivity";
    private MovieService movieService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        movieService = NetworkHelper.gerRetrofit().create(MovieService.class);
    }

    public void goToRatedMovies(View view) {
        movieService.topRatedMovies(1).enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(@NonNull Call<MovieResult> call, @NonNull Response<MovieResult> response) {
                handleMovieResponse(response);
            }

            @Override
            public void onFailure(@NonNull Call<MovieResult> call, @NonNull Throwable t) {
                Log.e(TAG, "Failed to get top rated movies", t);
            }
        });
    }

    private void handleMovieResponse(@NonNull Response<MovieResult> response) {
        MovieResult movieResult = response.body();
        if (movieResult == null)
            return;
        List<Result> resultList = movieResult.getResults();
        if (resultList == null)
            return;

        for (Result result : resultList) {
            Log.d(TAG, "onResponse: result=" + result);
        }
    }
}