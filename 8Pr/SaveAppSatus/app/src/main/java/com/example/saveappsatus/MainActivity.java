package com.example.saveappsatus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.saveappsatus.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    String name = "???";
    final static String strVariableKey = "STRING_VARIABLE";
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Находим кнопку для сохранения имени и устанавливаем слушатель событий
        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveName(v);
            }
        });

        // Находим кнопку для получения имени и устанавливаем слушатель событий
        binding.loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName(v);
            }
        });
    }
    //сохранение состояния Activity
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(strVariableKey, name);
        super.onSaveInstanceState(outState);
    }
    //полчучение ранее сохранённого состояния
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        name = savedInstanceState.getString(strVariableKey);
        binding.nameView.setText(name);
    }
    public void saveName(View view){
        //запоминаем введёный текст
        name = binding.nameBox.getText().toString();
    }
    public void getName(View view){
        //получаем введёный текст
        binding.nameView.setText(name);
    }
}