package com.example.saveappstatus2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.saveappstatus2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    User user = new User("undefined", 0);
    final static String userVariableKey = "USER_VARIABLE_KEY";
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
                saveData(v);
            }
        });

        // Находим кнопку для получения имени и устанавливаем слушатель событий
        binding.loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData(v);
            }
        });
    }
    //сохранение состояния Activity
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(userVariableKey, user);
        super.onSaveInstanceState(outState);
    }
    //полчучение ранее сохранённого состояния
    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        // получем объект User в переменную
        user = (User)savedInstanceState.getSerializable(userVariableKey);
        binding.dataView.setText("Name: " + user.getName() + " Age: " + user.getAge());
    }
    public void saveData(View view){
        //получаем введёные данные
        String name = binding.nameBox.getText().toString();
        int age = 0; // по умолчанию, если пользователь ввёл некоректные данные
        try{
            age = Integer.parseInt(binding.yearBox.getText().toString());
        }
        catch (NumberFormatException ex){}
        user = new User(name, age);
    }
    @SuppressLint("SetTextI18n")
    public void getData(View view){
        //получаем сохранёные данные
        binding.dataView.setText("Name: " + user.getName() + " Age: " + user.getAge());
    }
}