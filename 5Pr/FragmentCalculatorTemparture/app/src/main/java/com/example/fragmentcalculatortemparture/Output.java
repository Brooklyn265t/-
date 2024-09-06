package com.example.fragmentcalculatortemparture;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fragmentcalculatortemparture.databinding.FragmentOutputBinding;

public class Output extends Fragment {
    FragmentOutputBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOutputBinding.inflate(inflater, container, false);

        // Получение ссылок на TextView
//        final TextView dataTextView = view.findViewById(R.id.dataTextView);
//        final TextView unitTextView = view.findViewById(R.id.unitTextView);


        return binding.getRoot();
    }

//    private String getUnitString(int unit) {
//        // Реализация метода для преобразования ID единицы измерения в строку
//        // Например:
//        switch (unit) {
//            case R.id.radio_celsius:
//                return "Celsius";
//            case R.id.radio_fahrenheit:
//                return "Fahrenheit";
//            case R.id.radio_kelvin:
//                return "Fahrenheit";
//            case R.id.radio_rankin:
//                return "Fahrenheit";
//            case R.id.radio_reaumur:
//                return "Fahrenheit";
//            default:
//                return "Unknown";
//        }
//    }
}
