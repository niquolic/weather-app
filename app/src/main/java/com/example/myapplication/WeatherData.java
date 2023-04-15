package com.example.myapplication;

//import java.util.concurrent.locks.Condition;

import java.util.Date;

public class WeatherData {
    private Location location;
    private CurrentWeather current;
    private forecast forecast;
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
        public Forecastday[] forecastday;

        public Forecastday[] getForecastday() {
            return forecastday;
        }

        public static class Forecastday {
            private String date;
            private ConditionDay conditionday;
            private Day day;
            private Hour[] hour;

            public String getDate() {
                return date;
            }

            public ConditionDay getConditionday() {
                return conditionday;
            }

            public Day getDay() {
                return day;
            }

            public Hour[] getHour() {
                return hour;
            }

            public static class Day {
                private double maxtemp_c;
                private double mintemp_c;
                private ConditionDay condition;

                public double getMaxtemp_c() {
                    return maxtemp_c;
                }

                public double getMintemp_c() {
                    return mintemp_c;
                }

                public ConditionDay getCondition() {
                    return condition;
                }
            }

            public static class ConditionDay {
                private String text;
                private String icon;

                public String getText() {
                    return text;
                }

                public String getIcon() {
                    return icon;
                }
            }

            public static class Hour {
                private String time;
                private double temp_c;
                private ConditionHour condition;

                public String getTime() {
                    return time;
                }

                public double getTemp_c() {
                    return temp_c;
                }

                public ConditionHour getCondition() {
                    return condition;
                }
            }

            public static class ConditionHour {
                private String text;
                private String icon;

                public String getText() {
                    return text;
                }

                public String getIcon() {
                    return icon;
                }
            }
        }

    }
}