package com.example.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDatas {

    // Informations sur la localisation
    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;

    // Informations actuelles
    private double temp_c;
    private int is_day;
    private double wind_kph;
    private double precip_mm;
    private double precip_in;
    private int humidity;
    private int cloud;
    private double feelslike_c;
    private double uv;
    private double gust_kph;
    private String curText;
    private String curIcon;

    // Prévisions pour le jour en cours
    private String forecastDate;
    private long forecastDateEpoch;
    private double maxTempC;
    private double maxTempF;
    private double minTempC;
    private double minTempF;
    private double avgTempC;
    private double avgTempF;
    private double maxWindMph;
    private double maxWindKph;
    private String todayText;
    private String todayIcon;

    // Prévisions pour les 7 jours à venir
    private int time_epoch;
    private String time;
    private double temp_c_future;
    private String futureText;
    private String futureIcon;

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

    public double getTemp_c() {
        return temp_c;
    }

    public int getIs_day() {
        return is_day;
    }

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

    public String getCurText() {
        return curText;
    }

    public String getCurIcon() {
        return curIcon;
    }

    public String getForecastDate() {
        return forecastDate;
    }

    public long getForecastDateEpoch() {
        return forecastDateEpoch;
    }

    public double getMaxTempC() {
        return maxTempC;
    }

    public double getMaxTempF() {
        return maxTempF;
    }

    public double getMinTempC() {
        return minTempC;
    }

    public double getMinTempF() {
        return minTempF;
    }

    public double getAvgTempC() {
        return avgTempC;
    }

    public double getAvgTempF() {
        return avgTempF;
    }

    public double getMaxWindMph() {
        return maxWindMph;
    }

    public double getMaxWindKph() {
        return maxWindKph;
    }

    public String getTodayText() {
        return todayText;
    }

    public String getTodayIcon() {
        return todayIcon;
    }

    public int getTimeEpoch() {
        return time_epoch;
    }

    public String getTime() {
        return time;
    }

    public double getTempCFuture() {
        return temp_c_future;
    }

    public String getFutureText() {
        return futureText;
    }

    public String getFutureIcon() {
        return futureIcon;
    }

    // Constructeur
    public WeatherDatas(JSONObject json) throws JSONException {
        JSONObject currentObj = json.getJSONObject("location");
        this.name = currentObj.getString("name");
        this.country = currentObj.getString("country");
        this.lon = currentObj.getLong("lon");
        this.lat = currentObj.getLong("lat");
        this.region = currentObj.getString("region");
        this.temp_c = json.getJSONObject("current").getDouble("temp_c");
        this.is_day = json.getJSONObject("current").getInt("is_day");
        this.wind_kph = json.getJSONObject("current").getDouble("wind_kph");
        this.precip_mm = json.getJSONObject("current").getDouble("precip_mm");
        this.precip_in = json.getJSONObject("current").getDouble("precip_in");
        this.humidity = json.getJSONObject("current").getInt("humidity");
        this.cloud = json.getJSONObject("current").getInt("cloud");
        this.feelslike_c = json.getJSONObject("current").getDouble("feelslike_c");
        this.uv = json.getJSONObject("current").getDouble("uv");
        this.gust_kph = json.getJSONObject("current").getDouble("gust_kph");
        this.curText = json.getJSONObject("current").getJSONObject("condition").getString("text");
        this.curIcon = json.getJSONObject("current").getJSONObject("condition").getString("icon");
        this.forecastDate = json.getJSONObject("forecast").getJSONObject("forecastday").getString("date");
        this.forecastDateEpoch = json.getJSONObject("forecast").getJSONObject("forecastday").getLong("date_epoch");
        this.maxTempC = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("day").getDouble("maxtemp_c");
        this.maxTempF = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("day").getDouble("maxtemp_f");
        this.minTempC = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("day").getDouble("mintemp_c");
        this.minTempF = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("day").getDouble("mintemp_f");
        this.avgTempC = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("day").getDouble("avgtemp_c");
        this.avgTempF = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("day").getDouble("avgtemp_f");
        this.maxWindMph = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("day").getDouble("maxwind_mph");
        this.maxWindKph = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("day").getDouble("maxwind_kph");
        this.todayText = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("day").getJSONObject("condition").getString("text");
        this.todayIcon = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("day").getJSONObject("condition").getString("icon");
        this.time_epoch = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("hour").getInt("time_epoch");
        this.time = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("hour").getString("time");
        this.temp_c_future = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("hour").getDouble("temp_c");
        this.futureText = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("hour").getJSONObject("condition").getString("text");
        this.futureIcon = json.getJSONObject("forecast").getJSONObject("forecastday").getJSONObject("hour").getJSONObject("condition").getString("icon");
    }
}