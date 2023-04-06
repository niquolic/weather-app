package com.example.myapplication;

//import java.util.concurrent.locks.Condition;

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
        private String tz_id;
        private long localtime_epoch;
        private String localtime;

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

        public String getTz_id() {
            return tz_id;
        }

        public long getLocaltime_epoch() {
            return localtime_epoch;
        }

        public String getLocaltime() {
            return localtime;
        }
    }

    public static class CurrentWeather {
        private long last_updated_epoch;
        private String last_updated;
        private double temp_c;
        private double temp_f;
        private int is_day;
        //private Condition condition;
        private double wind_mph;
        private double wind_kph;
        private int wind_degree;
        private String wind_dir;
        private double pressure_mb;
        private double pressure_in;
        private double precip_mm;
        private double precip_in;
        private int humidity;
        private int cloud;
        private double feelslike_c;
        private double feelslike_f;
        private double vis_km;
        private double vis_miles;
        private double uv;
        private double gust_mph;
        private double gust_kph;

        public long getLast_updated_epoch() {
            return last_updated_epoch;
        }

        public String getLast_updated() {
            return last_updated;
        }

        public double getTemp_c() {
            return temp_c;
        }

        public double getTemp_f() {
            return temp_f;
        }

        public int getIs_day() {
            return is_day;
        }

        /*public Condition getCondition() {
            return condition;
        }*/

        public double getWind_mph() {
            return wind_mph;
        }

        public double getWind_kph() {
            return wind_kph;
        }

        public int getWind_degree() {
            return wind_degree;
        }

        public String getWind_dir() {
            return wind_dir;
        }

        public double getPressure_mb() {
            return pressure_mb;
        }

        public double getPressure_in() {
            return pressure_in;
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

        public double getFeelslike_f() {
            return feelslike_f;
        }

        public double getVis_km() {
            return vis_km;
        }

        public double getVis_miles() {
            return vis_miles;
        }

        public double getUv() {
            return uv;
        }

        public double getGust_mph() {
            return gust_mph;
        }

        public double getGust_kph() {
            return gust_kph;
        }
    }
}