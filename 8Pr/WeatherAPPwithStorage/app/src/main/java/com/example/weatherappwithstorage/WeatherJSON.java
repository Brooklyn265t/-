package com.example.weatherappwithstorage;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class WeatherJSON {
    private static final String FILE_NAME = "MoscowFinal.json";

    static List<DailyForecast> importFromJSON(Context context){
        try(FileInputStream fileInputStream = context.openFileInput(FILE_NAME)) {
            InputStreamReader streamReader = new InputStreamReader(fileInputStream);
            Gson gson = new Gson();
            MyJSON json = gson.fromJson(streamReader, MyJSON.class);
            return json.getCity().getForecast().getForecastDay();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}