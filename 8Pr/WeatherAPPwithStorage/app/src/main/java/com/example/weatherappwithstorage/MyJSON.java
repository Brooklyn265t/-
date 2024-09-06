package com.example.weatherappwithstorage;

public class MyJSON {
    City city;

    public MyJSON(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
