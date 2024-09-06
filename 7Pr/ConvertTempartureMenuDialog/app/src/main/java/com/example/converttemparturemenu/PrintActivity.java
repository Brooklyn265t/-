package com.example.converttemparturemenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.converttemparturemenu.databinding.ActivityPrintBinding;

public class PrintActivity extends AppCompatActivity {
    private ActivityPrintBinding binding;
    private final double Celcius_Kelvin =   273.15;
    private final int Celcius_Farenheit =   32;
    private double res1;
    private double res2;
    private double res3;
    private double res4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrintBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        double data = intent.getDoubleExtra("temperature", 0);
        int selectedUnit = intent.getIntExtra("selectedUnit", R.id.radio_celsius); // По умолчанию выбираем Цельсий

        count(data, selectedUnit); // Вызов метода для выполнения расчетов
        binding.newprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Закрытие текущей активности и возврат к предыдущей активности
            }
        });
    }
    protected void count(double data, int selectedUnit) {
        if (selectedUnit == R.id.radio_celsius) {
            // Преобразование в Цельсий
            res1 = data + Celcius_Kelvin;
            res2 = data + Celcius_Farenheit;
            res3 = data * 9 / 5 + 491.67;
            res4 = data * 4 / 5;
            binding.textView.setText(res1 + "K");
            binding.textView2.setText(res2 + "F");
            binding.textView3.setText(res3 + "R");
            binding.textView4.setText(res4 + "Ré");
        } else if (selectedUnit == R.id.radio_fahrenheit) {
            // Преобразование в Фаренгейт
            res1 = (data - Celcius_Farenheit) * 5 / 9;
            res2 = ((data - Celcius_Farenheit) * 5 / 9) + Celcius_Kelvin;
            res3 = (data - 32) / 4.0 * 5.0 / 9.0;
            res4 = data + 459.67;
            binding.textView.setText(res1 + "C");
            binding.textView2.setText(res2 + "K");
            binding.textView3.setText(res3 + "R");
            binding.textView4.setText(res4 + "Ré");
        } else if (selectedUnit == R.id.radio_kelvin) {
            // Преобразование в Кельвин
            res1 = data - Celcius_Kelvin;
            res2 = ((data - Celcius_Kelvin) * 5 / 9) + Celcius_Farenheit;
            res3 = data * 9 / 5;
            res4 = (data - 273.15) * 9 / 5;
            binding.textView.setText(res1 + "C");
            binding.textView2.setText(res2 + "F");
            binding.textView3.setText(res3 + "R");
            binding.textView4.setText(res4 + "Ré");
        } else if (selectedUnit == R.id.radio_reaumur) {
            res1 = data * 4 / 5;
            res2 = data * 5 / 4;
            res3 = data * 9 / 4;
            res4 = data * 9 / 4 + 491.67;
            binding.textView.setText(res1 + "C");
            binding.textView2.setText(res2 + "K");
            binding.textView3.setText(res3 + "F");
            binding.textView4.setText(res4 + "R");
        } else if (selectedUnit == R.id.radio_rankin) {
            // Преобразование из Ранкина в другие шкалы
            res1 = (data - 491.67) / 1.8;
            // Перевод в Кельвин
            res2 = data;
            // Перевод в Фаренгейт
            res3 = data - 459.67;
            // Перевод в Реомюр
            res4 = (data - 491.67) / 2.25;
            binding.textView.setText(res1 + "C");
            binding.textView2.setText(res2 + "K");
            binding.textView3.setText(res3 + "F");
            binding.textView4.setText(res4 + "Ré");
        }
    }
}