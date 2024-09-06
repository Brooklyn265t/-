package com.example.converttemparturemenu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.converttemparturemenu.databinding.ActivityInputBinding;

public class FragmentInput extends Fragment {
    ActivityInputBinding binding;
    private final double Celcius_Kelvin =   273.15;
    private final int Celcius_Farenheit =   32;
    private double c;
    private double f;
    private double k;
    private double r;
    private double re;
    private double data;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ActivityInputBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Извлечение значения из EditText
                data = Double.parseDouble(binding.InputTempar.getText().toString());
                // Извлечение идентификатора выбранной радиокнопки
                int selectedUnit = binding.temperatureGroup.getCheckedRadioButtonId();
                int unit = -1;
                if(selectedUnit == R.id.radio_celsius){
                    unit = 0;
                } else if (selectedUnit == R.id.radio_fahrenheit) {
                    unit = 1;
                } else if (selectedUnit == R.id.radio_kelvin) {
                    unit = 2;
                } else if (selectedUnit == R.id.radio_rankin) {
                    unit = 3;
                }else if (selectedUnit == R.id.radio_reaumur) {
                    unit = 4;
                }
                // Вызов функции Convert
                Convert(data, unit);
            }
        });
    }

    public void Convert(double numb, int type) {
        Log.d("","msg");
        data = numb;
        switch(type){
            case 0:
                c = data;
                k = data + Celcius_Kelvin;
                f = data + Celcius_Farenheit;
                r = data * 9 / 5 + 491.67;
                re = data * 4 / 5;
                break;
            case 1:
                c = (data - Celcius_Farenheit) * 5 / 9;
                k = ((data - Celcius_Farenheit) * 5 / 9) + Celcius_Kelvin;
                f = data;
                r = (data - 32) / 4.0 * 5.0 / 9.0;
                re = data + 459.67;
                break;
            case 2:
                c = data - Celcius_Kelvin;
                k = data;
                f = ((data - Celcius_Kelvin) * 5 / 9) + Celcius_Farenheit;
                r = data * 9 / 5;
                re = (data - 273.15) * 9 / 5;
                break;
            case 3:
                c = (data - 491.67) / 1.8;
                k = data;
                f = data - 459.67;
                r = data;
                re = (data - 491.67) / 2.25;
                break;
            case 4:
                c = data * 4 / 5;
                k = data * 5 / 4;
                f = data * 9 / 4;
                r = data * 9 / 4 + 491.67;
                re = data;
                break;
            default:

                break;
        }
        Log.d("","msg");
        binding.Celsius.setText(c + "C");
        binding.Kelvin.setText(k + "K");
        binding.Fahrenheit.setText(f + "F");
        binding.Rankine.setText(r + "R");
        binding.Reaumur.setText(re + "Ré");
    }
}
