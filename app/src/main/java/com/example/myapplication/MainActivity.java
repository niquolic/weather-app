package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
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
    private TextView cityTextView;
    private LocationManager locationManager;
    private String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_default);
        temperatureTextView = findViewById(R.id.temperatureTextView);
        cityTextView = findViewById(R.id.cityTextView);

        // Initialize location manager and provider
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        provider = LocationManager.GPS_PROVIDER;

        // Check if location provider is enabled
        if (locationManager.isProviderEnabled(provider)) {
            // Get current location
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // Request location permissions if not already granted
                ActivityCompat.requestPermissions(this, new String[] { android.Manifest.permission.ACCESS_FINE_LOCATION }, 1);
            } else {
                Location location = locationManager.getLastKnownLocation(provider);
                if (location != null) {
                    // Get latitude and longitude
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    // Get weather data for current location
                    getWeatherDataPos(latitude, longitude);
                } else {
                    // If location is null, display error message
                    temperatureTextView.setText("Location not available");
                }
            }
        } else {
            // If location provider is disabled, display error message
            temperatureTextView.setText("Location provider not enabled");
        }
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
                cityTextView.setText(weatherData.getLocation().getName());
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                temperatureTextView.setText(t.getMessage());
            }
        });
    }

    private void getWeatherDataPos(double latitude, double longitude) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApiService service = retrofit.create(WeatherApiService.class);
        Call<WeatherData> call = service.getCurrentWeatherPos(API_KEY, latitude, longitude);
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
                cityTextView.setText(weatherData.getLocation().getName());
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                temperatureTextView.setText(t.getMessage());
            }
        });
    }
}