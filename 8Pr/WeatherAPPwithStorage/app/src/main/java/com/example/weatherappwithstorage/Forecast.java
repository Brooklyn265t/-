package com.example.weatherappwithstorage;

import java.util.List;

//прогноз из объекта city
public class Forecast{
    private List<DailyForecast> forecastDay;

    public Forecast(List<DailyForecast> forecastDay) {
        this.forecastDay = forecastDay;
    }

    public List<DailyForecast> getForecastDay() {
        return forecastDay;
    }

    public void setForecastDay(List<DailyForecast> forecastDay) {
        this.forecastDay = forecastDay;
    }
}