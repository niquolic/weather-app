package com.example.myapplication;

//import java.util.concurrent.locks.Condition;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;

public class WeatherData {
    private Location location;
    private CurrentWeather current;
    private DailyForecast dailyForecast;

    public Location getLocation() {
        return location;
    }

    public CurrentWeather getCurrent() {
        return current;
    }

    public DailyForecast getDailyForecast() {
        return dailyForecast;
    }

    public static class Location {
        private String name;
        private String region;
        private String country;
        private double lat;
        private double lon;

        public String getName() {
            return name;
        }

        public String getRegion() {
            return region;
        }

        public String getCountry() {
            return country;
        }

        public double getLat() {
            return lat;
        }

        public double getLon() {
            return lon;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }
    }

    public static class CurrentWeather {
        public static class Condition {
            private String text;
            private String icon;

            public String getText() {
                return text;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
        private double temp_c;
        private int is_day;
        private Condition condition;
        private double wind_kph;
        private double precip_mm;
        private double precip_in;
        private int humidity;
        private int cloud;
        private double feelslike_c;
        private double uv;
        private double gust_kph;

        public double getTemp_c() {
            return temp_c;
        }

        public int getIs_day() {
            return is_day;
        }

        public Condition getCondition() { return condition; }

        public double getWind_kph() {
            return wind_kph;
        }

        public double getPrecip_mm() {
            return precip_mm;
        }

        public double getPrecip_in() {
            return precip_in;
        }

        public int getHumidity() {
            return humidity;
        }

        public int getCloud() {
            return cloud;
        }

        public double getFeelslike_c() {
            return feelslike_c;
        }

        public double getUv() {
            return uv;
        }

        public double getGust_kph() {
            return gust_kph;
        }

        public void setTemp_c(double temp_c) {
            this.temp_c = temp_c;
        }

        public void setIs_day(int is_day) {
            this.is_day = is_day;
        }

        public void setCondition(CurrentWeather.Condition condition) {
            this.condition = condition;
        }

        public void setWind_kph(double wind_kph) {
            this.wind_kph = wind_kph;
        }

        public void setPrecip_mm(double precip_mm) {
            this.precip_mm = precip_mm;
        }

        public void setPrecip_in(double precip_in) {
            this.precip_in = precip_in;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public void setCloud(int cloud) {
            this.cloud = cloud;
        }

        public void setFeelslike_c(double feelslike_c) {
            this.feelslike_c = feelslike_c;
        }

        public void setUv(double uv) {
            this.uv = uv;
        }

        public void setGust_kph(double gust_kph) {
            this.gust_kph = gust_kph;
        }
    }

    public static class DailyForecast {
        public static class Condition {
            private String text;
            private String icon;

            public String getText() {
                return text;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
        private String date;
        private int maxTemp;
        private int minTemp;
        private DailyForecast.Condition condition;

        public String getDate() {return date;}

        public int getMaxTemp() {return maxTemp;}

        public int getMinTemp() {return minTemp;}

        public DailyForecast.Condition getCondition() { return condition; }

        public void setDate(String date) {
            this.date = date;
        }

        public void setMaxTemp(int maxTemp) {
            this.maxTemp = maxTemp;
        }

        public void setMinTemp(int minTemp) {
            this.minTemp = minTemp;
        }

        public void setCondition(DailyForecast.Condition condition) {
            this.condition = condition;
        }
    }

    public static WeatherData fromJson(JSONObject json) throws JSONException {
        WeatherData weatherData = new WeatherData();

        // Set location data
        JSONObject locationJson = json.getJSONObject("location");
        Location location = new Location();
        location.setName(locationJson.getString("name"));
        location.setRegion(locationJson.getString("region"));
        location.setCountry(locationJson.getString("country"));
        location.setLat(locationJson.getDouble("lat"));
        location.setLon(locationJson.getDouble("lon"));
        weatherData.location = location;

        // Set current weather data
        JSONObject currentJson = json.getJSONObject("current");
        CurrentWeather current = new CurrentWeather();
        current.setTemp_c(currentJson.getDouble("temp_c"));
        current.setIs_day(currentJson.getInt("is_day"));
        CurrentWeather.Condition condition = new CurrentWeather.Condition();
        condition.setIcon(currentJson.getJSONObject("condition").getString("icon"));
        current.setCondition(condition);
        current.setWind_kph(currentJson.getDouble("wind_kph"));
        current.setPrecip_mm(currentJson.getDouble("precip_mm"));
        current.setPrecip_in(currentJson.getDouble("precip_in"));
        current.setHumidity(currentJson.getInt("humidity"));
        current.setCloud(currentJson.getInt("cloud"));
        current.setFeelslike_c(currentJson.getDouble("feelslike_c"));
        current.setUv(currentJson.getDouble("uv"));
        current.setGust_kph(currentJson.getDouble("gust_kph"));
        weatherData.current = current;

        // Set daily forecast data
        JSONArray forecastJsonArray = json.getJSONObject("forecast").getJSONArray("forecastday");
        JSONObject firstForecastJson = forecastJsonArray.getJSONObject(0);
        DailyForecast dailyForecast = new DailyForecast();
        dailyForecast.setDate(firstForecastJson.getString("date"));
        dailyForecast.setMaxTemp((int) firstForecastJson.getJSONObject("day").getDouble("maxtemp_c"));
        dailyForecast.setMinTemp((int) firstForecastJson.getJSONObject("day").getDouble("mintemp_c"));
        DailyForecast.Condition dailyCondition = new DailyForecast.Condition();
        dailyCondition.setIcon(firstForecastJson.getJSONObject("day").getJSONObject("condition").getString("icon"));
        dailyForecast.setCondition(dailyCondition);
        weatherData.dailyForecast = dailyForecast;

        return weatherData;
    }

}