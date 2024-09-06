package com.example.converttemparture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.converttemparture.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private double data =   0;
    private final double Celcius_Kelvin =   273.15;
    private final int Celcius_Farenheit =   32;
    private double res1;
    private double res2;
    private double res3;
    private double res4;
    private Button b_ok;

    private TextView message;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnOk.setOnClickListener(this);
        binding.temperatureGroup.setOnCheckedChangeListener(this::onTemperatureChanged);
        Intent intent = new Intent(this, SecondActivity.class); //создание намерения
        binding.btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);  //передача намерения на исполнение
            }
        });

    }

    @Override
    public void onClick(View view) {
        b_ok(view);
    }

    private void onTemperatureChanged(RadioGroup group, int checkedId) {
        try {
            data = Double.parseDouble(binding.InputTempar.getText().toString());
        } catch (NumberFormatException e) {
            // Обработка исключения для ввода некоректных данных
            binding.textView.setError("Неправильный ввод");
            binding.textView2.setError("Неправильный ввод");
            binding.textView3.setError("Неправильный ввод");
            binding.textView4.setError("Неправильный ввод");
        }

        if (checkedId == R.id.radio_celsius) {
            // Преобразование в Цельсий
            res1 = data + Celcius_Kelvin;
            res2 = data + Celcius_Farenheit;
            res3 = data *  9/5 +  491.67;
            res4 = data *  4/5;
            binding.textView.setText(res1 + "K");
            binding.textView2.setText(res2 + "F");
            binding.textView3.setText(res3 + "R");
            binding.textView4.setText(res4 + "Ré");
        } else if (checkedId == R.id.radio_fahrenheit) {
            // Преобразование в Фаренгейт
            res1 = (data - Celcius_Farenheit) *  5 /  9;
            res2 = ((data - Celcius_Farenheit) *  5 /  9) + Celcius_Kelvin;
            res3 = (data -  32) /  4.0 *  5.0 /  9.0;
            res4 = data +  459.67;
            binding.textView.setText(res1 + "C");
            binding.textView2.setText(res2 + "K");
            binding.textView3.setText(res3 + "R");
            binding.textView4.setText(res4 + "Ré");
        } else if (checkedId == R.id.radio_kelvin) {
            // Преобразование в Кельвин
            res1 = data - Celcius_Kelvin;
            res2 = ((data - Celcius_Kelvin) *  5 /  9) + Celcius_Farenheit;
            res3 = data * 9/5;
            res4 = (data - 273.15) * 9/5;
            binding.textView.setText(res1 + "C");
            binding.textView2.setText(res2 + "F");
            binding.textView3.setText(res3 + "R");
            binding.textView4.setText(res4 + "Ré");
        }
        else if (checkedId == R.id.radio_reaumur) {
            res1 = data *  4/5;
            res2 = data *  5/4;
            res3 = data *  9/4;
            res4 = data *  9/4 +  491.67;
            binding.textView.setText(res1 + "C");
            binding.textView2.setText(res2 + "K");
            binding.textView3.setText(res3 + "F");
            binding.textView4.setText(res4 + "R");
        }
        else if (checkedId == R.id.radio_rankin) {
            // Преобразование из Ранкина в другие шкалы
            res1 = (data -  491.67) /  1.8;
            // Перевод в Кельвин
            res2 = data;
            // Перевод в Фаренгейт
            res3 = data -  459.67;
            // Перевод в Реомюр
            res4 = (data -  491.67) /  2.25;
            binding.textView.setText(res1 + "C");
            binding.textView2.setText(res2 + "K");
            binding.textView3.setText(res3 + "F");
            binding.textView4.setText(res4 + "Ré");
        }
    }

    public void b_ok(View view) {
        onTemperatureChanged(binding.temperatureGroup, binding.temperatureGroup.getCheckedRadioButtonId());
    }
}
