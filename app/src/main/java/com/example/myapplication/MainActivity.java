package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final String API_KEY = "b8e8d154cae645d3beb70902230604";
    private final String LOCATION = "Mouvaux";
    private TextView temperatureTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_main);
        temperatureTextView = findViewById(R.id.temperatureTextView);
        getWeatherData();
    }

    private void getWeatherData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApiService service = retrofit.create(WeatherApiService.class);
        Call<WeatherData> call = service.getCurrentWeather(API_KEY, LOCATION);
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if (!response.isSuccessful()) {
                    temperatureTextView.setText("Code: " + response.code());
                    return;
                }

                WeatherData weatherData = response.body();
                double temperature = weatherData.getCurrent().getTemp_c();
                temperatureTextView.setText(String.format("%.1f °C", temperature));
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                temperatureTextView.setText(t.getMessage());
            }
        });
    }
}