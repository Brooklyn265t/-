package com.example.weatherappwithstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

import com.example.weatherappwithstorage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Context ctx = this;
        binding.openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               List<DailyForecast> casts = WeatherJSON.importFromJSON(ctx);
                if(casts == null){
                    Toast.makeText(ctx, "Не удалось прочесть файл", Toast.LENGTH_SHORT).show();
                    return;
                }
                DailyForecast cast = casts.get(0);
                binding.CityName.setText("Москва");
                binding.DataToday.setText(cast.getForecastDate());
                binding.minTemp.setText(cast.getMinTemp());
                binding.maxTemp.setText(cast.getMaxTemp());
                if (cast.getWeatherIcon() == 1401){
                    binding.IconWeather.setImageResource(R.drawable.storm);
                }
                else if (cast.getWeatherIcon() == 2501 | cast.getWeatherIcon() == 2502){
                    binding.IconWeather.setImageResource(R.drawable.sun);
                }
                else{
                    binding.IconWeather.setImageResource(R.drawable.cloud);
                }
            }
        });
    }
}
