package com.example.fragmentcalculatortemparture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fragmentcalculatortemparture.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Input.onConvertListener {
    private ActivityMainBinding binding;
    private final double Celcius_Kelvin =   273.15;
    private final int Celcius_Farenheit =   32;
    private double c;
    private double f;
    private double k;
    private double r;
    private double re;
    private double data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.ActivityConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Input in = (Input) getSupportFragmentManager().findFragmentById(R.id.fragment1);
                Output out = (Output) getSupportFragmentManager().findFragmentById(R.id.fragment2);

                int id = in.binding.temperatureGroup.getCheckedRadioButtonId();
                String numbcinvert = in.binding.editTextNumber.getText().toString();
                if(id == R.id.radio_celsius){
                    c = data;
                    k = data + Celcius_Kelvin;
                    f = data + Celcius_Farenheit;
                    r = data * 9 / 5 + 491.67;
                    re = data * 4 / 5;
                } else if (id == R.id.radio_fahrenheit) {
                    c = (data - Celcius_Farenheit) * 5 / 9;
                    k = ((data - Celcius_Farenheit) * 5 / 9) + Celcius_Kelvin;
                    f = data;
                    r = (data - 32) / 4.0 * 5.0 / 9.0;
                    re = data + 459.67;
                } else if (id == R.id.radio_kelvin) {
                    c = data - Celcius_Kelvin;
                    k = data;
                    f = ((data - Celcius_Kelvin) * 5 / 9) + Celcius_Farenheit;
                    r = data * 9 / 5;
                    re = (data - 273.15) * 9 / 5;
                } else if (id == R.id.radio_rankin) {
                    c = (data - 491.67) / 1.8;
                    k = data;
                    f = data - 459.67;
                    r = data;
                    re = (data - 491.67) / 2.25;
                }else if (id == R.id.radio_reaumur) {
                    c = data * 4 / 5;
                    k = data * 5 / 4;
                    f = data * 9 / 4;
                    r = data * 9 / 4 + 491.67;
                    re = data;
                }
                out.binding.Celsius.setText(c + "C");
                out.binding.Kelvin.setText(k + "K");
                out.binding.Fahrenheit.setText(f + "F");
                out.binding.Rankine.setText(r + "R");
                out.binding.Reaumur.setText(re + "Ré");
            }
        });
    }

    @Override
    public void Convert(double numb, int type) {
        data = numb;
        switch(type){
            case Input.Celsius:
                c = data;
                k = data + Celcius_Kelvin;
                f = data + Celcius_Farenheit;
                r = data * 9 / 5 + 491.67;
                re = data * 4 / 5;
                break;
            case Input.Fahrenheit:
                c = (data - Celcius_Farenheit) * 5 / 9;
                k = ((data - Celcius_Farenheit) * 5 / 9) + Celcius_Kelvin;
                f = data;
                r = (data - 32) / 4.0 * 5.0 / 9.0;
                re = data + 459.67;
                break;
            case Input.Kelvin:
                c = data - Celcius_Kelvin;
                k = data;
                f = ((data - Celcius_Kelvin) * 5 / 9) + Celcius_Farenheit;
                r = data * 9 / 5;
                re = (data - 273.15) * 9 / 5;
                break;
            case Input.Rankine:
                c = (data - 491.67) / 1.8;
                k = data;
                f = data - 459.67;
                r = data;
                re = (data - 491.67) / 2.25;
                break;
            case Input.Reaumur:
                c = data * 4 / 5;
                k = data * 5 / 4;
                f = data * 9 / 4;
                r = data * 9 / 4 + 491.67;
                re = data;
                break;
            default:

                break;
        }
        Output out = (Output) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        out.binding.Celsius.setText(c + "C");
        out.binding.Kelvin.setText(k + "K");
        out.binding.Fahrenheit.setText(f + "F");
        out.binding.Rankine.setText(r + "R");
        out.binding.Reaumur.setText(re + "Ré");
    }
}