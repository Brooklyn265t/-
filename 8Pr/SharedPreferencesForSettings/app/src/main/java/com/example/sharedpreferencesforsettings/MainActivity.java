package com.example.sharedpreferencesforsettings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.sharedpreferencesforsettings.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    final static String PREFS_FILE = "Account";
    final static String PREF_NAME = "Name";
    SharedPreferences settings;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        settings = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
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
    public void saveName(View view){
        //ввод имени
        String name = binding.nameBox.getText().toString();
        //сохраняем его в настройках
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(PREF_NAME, name);
        prefEditor.apply();
    }
    public void getName(View view){
        //получаем сохранённое имя
        String name = settings.getString(PREF_NAME, "не определено");
        binding.nameView.setText(name);
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        // Сохраняем текущее значение текстового поля в SharedPreferences перед выходом из активности
//        String currentName = binding.nameBox.getText().toString();
//        SharedPreferences.Editor prefEditor = settings.edit();
//        prefEditor.putString(PREF_NAME, currentName);
//        prefEditor.apply();
//    }
}