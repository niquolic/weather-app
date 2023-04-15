package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final String API_KEY = "b8e8d154cae645d3beb70902230604";
    private String LOCATION = "Mouvaux";
    private TextView temperatureTextView;
    private TextView cityTextView;
    private ImageView weatherNowImageView;
    private LocationManager locationManager;
    private String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_default);
        temperatureTextView = findViewById(R.id.temperatureTextView);
        cityTextView = findViewById(R.id.cityTextView);
        weatherNowImageView = findViewById(R.id.weatherNowImageView);
        EditText cityEditText = findViewById(R.id.cityEditText);
        Button searchButton = findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = cityEditText.getText().toString();
                if (!TextUtils.isEmpty(city)) {
                    LOCATION = city;
                    getWeatherData();
                } else {
                    Toast.makeText(MainActivity.this, "Entrez un nom de ville valide", Toast.LENGTH_SHORT).show();
                }
            }
        });


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
                    // If location is null, display error message and launch by city
                    temperatureTextView.setText("Location not available");
                    getWeatherData();
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
        Call<WeatherData> call = service.getCurrentWeather(API_KEY, LOCATION, 7);
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
                WeatherData.forecast.Forecastday[] forecastday = weatherData.getForecast().getForecastday();
                Log.d("Forecast", forecastday.toString());
                // Récupération de l'URL vers l'image
                String iconUrl = weatherData.getCurrent().getCondition().getIcon();
                iconUrl = "https://"+iconUrl.substring(2);
                // Affichage de l'image
                Glide.with(MainActivity.this).load(iconUrl).into(weatherNowImageView);
                for (int i = 0; i < 24; i++) {
                    WeatherData.forecast.Forecastday.Hour[] hours = forecastday[0].getHour();
                    Log.d("Hour", String.valueOf(hours));
                    String time = hours[i].getTime();
                    double temp_c = hours[i].getTemp_c();
                    String condition = hours[i].getCondition().getIcon();
                    int hourTextViewId = getResources().getIdentifier("textViewHour" + (i+1), "id", getPackageName());
                    TextView textViewHour = findViewById(hourTextViewId);
                    int imageViewId = getResources().getIdentifier("imageViewIcon" + (i+1), "id", getPackageName());
                    ImageView imageViewIcon = findViewById(imageViewId);
                    int tempTextViewId = getResources().getIdentifier("textViewTemp" + (i+1), "id", getPackageName());
                    TextView textViewTemp = findViewById(tempTextViewId);
                    String hour = time.substring(11, 13); // Get the hour from the time
                    textViewHour.setText(String.format("%sh", hour));
                    textViewTemp.setText(String.format("%.1f °C", temp_c));
                    // Set the image for the corresponding hour
                    Glide.with(MainActivity.this).load("https:"+hours[i].getCondition().getIcon().substring(2)).into(imageViewIcon);
                }
                for (int i = 0; i < 7; i++){
                    Log.d("ForecastdayArray", String.valueOf(forecastday[i].getDay()));
                    double maxtemp_c = forecastday[i].getDay().getMaxtemp_c();
                    double mintemp_c = forecastday[i].getDay().getMintemp_c();
                    String condition = forecastday[i].getDay().getCondition().getIcon();
                    String day = forecastday[i].getDate();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    try {
                        date = dateFormat.parse(day);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    dateFormat.applyPattern("EEEE");
                    String dayOfWeek = dateFormat.format(date);
                    int dayViewFieldId = getResources().getIdentifier("dayView" + i, "id", getPackageName());
                    TextView dayView = findViewById(dayViewFieldId);
                    int imageViewId = getResources().getIdentifier("imageViewWeather" + i, "id", getPackageName());
                    ImageView imageViewWeather = findViewById(imageViewId);
                    int tempViewFieldId = getResources().getIdentifier("tempView" + i, "id", getPackageName());
                    TextView tempView = findViewById(tempViewFieldId);
                    tempView.setText(String.format("%.1f °C -- %.1f °C", mintemp_c, maxtemp_c));
                    Glide.with(MainActivity.this).load("https:"+forecastday[i].getDay().getCondition().getIcon().substring(2)).into(imageViewWeather);
                    dayView.setText(dayOfWeek);
                }

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
        Call<WeatherData> call = service.getCurrentWeatherPos(API_KEY, latitude, longitude, 7);
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
                // Récupération de l'URL vers l'image
                String iconUrl = weatherData.getCurrent().getCondition().getIcon();
                iconUrl = "https://"+iconUrl.substring(2);
                // Affichage de l'image
                Glide.with(MainActivity.this).load(iconUrl).into(weatherNowImageView);
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                temperatureTextView.setText(t.getMessage());
            }
        });
    }
}
