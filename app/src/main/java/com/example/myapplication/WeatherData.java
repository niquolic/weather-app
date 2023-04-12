package com.example.myapplication;

//import java.util.concurrent.locks.Condition;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Date;

public class WeatherData {
    private Location location;
    private CurrentWeather current;
    private forecast forecast;
    private WeatherData.forecast.forecastday[] forecastday;
    private WeatherData.forecast.forecastday.day day;
    private WeatherData.forecast.forecastday.day.hour[] hour;
    //private DailyForecast dailyForecast;

    public Location getLocation() {
        return location;
    }

    public CurrentWeather getCurrent() {
        return current;
    }

    public forecast getForecast() {
        return forecast;
    }

    public WeatherData.forecast.forecastday[] getForecastday() {
        return forecastday;
    }

    public WeatherData.forecast.forecastday.day getDay() {
        return day;
    }

    public WeatherData.forecast.forecastday.day.hour[] getHour() {
        return hour;
    }

    /*public DailyForecast getDailyForecast() {
        return dailyForecast;
    }*/

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

    public static class forecast {
        public static class forecastday {
            public static class day {
                public static class condition {
                    private String text;
                    private String icon;

                    public String getText() {
                        return text;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }
                }

                private double maxtemp_c;
                private double mintemp_c;
                private double avgtemp_c;
                private double maxwind_kph;
                private double totalprecip_mm;
                private double totalprecip_in;
                private int avgvis_km;
                private int avghumidity;
                private double uv;
                private condition condition;

                public double getMaxtemp_c() {
                    return maxtemp_c;
                }

                public double getMintemp_c() {
                    return mintemp_c;
                }

                public double getAvgtemp_c() {
                    return avgtemp_c;
                }

                public double getMaxwind_kph() {
                    return maxwind_kph;
                }

                public double getTotalprecip_mm() {
                    return totalprecip_mm;
                }

                public double getTotalprecip_in() {
                    return totalprecip_in;
                }

                public int getAvgvis_km() {
                    return avgvis_km;
                }

                public int getAvghumidity() {
                    return avghumidity;
                }

                public double getUv() {
                    return uv;
                }

                public condition getCondition() {
                    return condition;
                }

                public void setMaxtemp_c(double maxtemp_c) {
                    this.maxtemp_c = maxtemp_c;
                }

                public void setMintemp_c(double mintemp_c) {
                    this.mintemp_c = mintemp_c;
                }

                public void setAvgtemp_c(double avgtemp_c) {
                    this.avgtemp_c = avgtemp_c;
                }

                public void setMaxwind_kph(double maxwind_kph) {
                    this.maxwind_kph = maxwind_kph;
                }

                public void setTotalprecip_mm(double totalprecip_mm) {
                    this.totalprecip_mm = totalprecip_mm;
                }

                public void setTotalprecip_in(double totalprecip_in) {
                    this.totalprecip_in = totalprecip_in;
                }

                public void setAvgvis_km(int avgvis_km) {
                    this.avgvis_km = avgvis_km;
                }

                public void setAvghumidity(int avghumidity) {
                    this.avghumidity = avghumidity;
                }

                public void setUv(double uv) {
                    this.uv = uv;
                }

                public void setCondition(condition condition) {
                    this.condition = condition;
                }

                public static class hour{

                    public static class condition{
                        private String text;
                        private String icon;

                        public String getText() {
                            return text;
                        }

                        public String getIcon() {
                            return icon;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }

                        public void setIcon(String icon) {
                            this.icon = icon;
                        }
                    }

                    private Date time;
                    private double temp_c;
                    private double wind_kph;
                    private double precip_mm;
                    private double precip_in;
                    private int humidity;
                    private int cloud;
                    private double feelslike_c;
                    private double uv;
                    private double gust_kph;
                    private condition condition;

                    public Date getTime() {
                        return time;
                    }

                    public double getTemp_c() {
                        return temp_c;
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

                    public condition getCondition() {
                        return condition;
                    }

                    public void setTime(Date time) {
                        this.time = time;
                    }

                    public void setTemp_c(double temp_c) {
                        this.temp_c = temp_c;
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

                    public void setCondition(condition condition) {
                        this.condition = condition;
                    }
                }
            }
        }
    }
}