package com.example.fragmentcalculatortemparture;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fragmentcalculatortemparture.databinding.FragmentInputBinding;

public class Input extends Fragment {
    static final int Celsius = 0;
    static final int Fahrenheit = 1;
    static final int Kelvin = 2;
    static final int Rankine = 3;
    static final int Reaumur = 4;

    FragmentInputBinding binding;
    public interface onConvertListener {
        public void Convert(double numb, int type);
    }
    onConvertListener Convert;
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            Convert = (onConvertListener) context;
        }catch(ClassCastException e){}
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInputBinding.inflate(inflater, container, false);

        binding.Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedUnit = binding.temperatureGroup.getCheckedRadioButtonId();
                int unit = -1;
                if(selectedUnit == R.id.radio_celsius){
                    unit = Celsius;
                } else if (selectedUnit == R.id.radio_fahrenheit) {
                    unit = Fahrenheit;
                } else if (selectedUnit == R.id.radio_kelvin) {
                    unit = Kelvin;
                } else if (selectedUnit == R.id.radio_rankin) {
                    unit = Rankine;
                }else if (selectedUnit == R.id.radio_reaumur) {
                    unit = Reaumur;
                }
                String num = binding.editTextNumber.getText().toString();
                double data = Double.parseDouble(num.isEmpty() ? "0": num);
                Convert.Convert(data, unit);
            }
        });

        return binding.getRoot();
    }

}
