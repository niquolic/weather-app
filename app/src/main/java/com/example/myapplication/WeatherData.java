package com.example.myapplication;

//import java.util.concurrent.locks.Condition;

import java.lang.reflect.Array;

public class WeatherData {
    private Location location;
    private CurrentWeather current;

    public Location getLocation() {
        return location;
    }

    public CurrentWeather getCurrent() {
        return current;
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
    }

    public static class CurrentWeather {
        public class Condition {
            private String text;
            private String icon;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
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
    }
}