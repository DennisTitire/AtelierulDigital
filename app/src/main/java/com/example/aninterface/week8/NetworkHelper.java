package com.example.aninterface.week8;

import com.example.aninterface.BuildConfig;
import com.example.aninterface.week8.interceptors.QueryParamInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public final class NetworkHelper {

    public static Retrofit retrofit;
    private static final String BASE_URL = "https://api.themoviedb.org/";
    private static final String API_KEY = "0b808e56d790e7192b1fd1c794964caa";
    private static final String DEFAULT_LANGUAGE = "en-US";

    private NetworkHelper() {
        // hide
    }

    public static Retrofit gerRetrofit() {
        if(retrofit == null) {
            // Add any custom configuration to the http cient used by Retrofit
            OkHttpClient.Builder httpClient = getClient();
            // Add the api key as query for all requests
            httpClient.addInterceptor(new QueryParamInterceptor("api_key", API_KEY));
            // Add language as query for all requests
            httpClient.addInterceptor(new QueryParamInterceptor("language", DEFAULT_LANGUAGE));
            retrofit = new  Retrofit.Builder().baseUrl(BASE_URL)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
            return retrofit;
    }
    private static OkHttpClient.Builder getClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.addInterceptor(logging);
        }
        return client;
    }

}
