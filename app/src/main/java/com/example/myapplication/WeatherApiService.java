package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {
    @GET("current.json")
    Call<WeatherData> getCurrentWeather(
            @Query("key") String apiKey,
            @Query("q") String location
    );

    @GET("current.json")
    Call<WeatherData> getCurrentWeatherPos(
            @Query("key") String apiKey,
            @Query("lat") double latitude,
            @Query("lon") double longitude
    );
}