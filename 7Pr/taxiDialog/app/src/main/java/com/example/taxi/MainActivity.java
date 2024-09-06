package com.example.taxi;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.taxi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private SharedPreferences sPref;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String keyName = "nameKey";
    private static final String keySurname = "surnameKey";
    private static final String keyPhone = "phoneKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        loadText();
        Intent intent = new Intent(this, SendTaxi.class);
        binding.Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.name.getText().toString();
                String surname = binding.surname.getText().toString();
                String phone = binding.phone.getText().toString();
                //передаём содержимое текстового поля:
                intent.putExtra("name", binding.name.getText().toString());
                intent.putExtra("surname", binding.surname.getText().toString());
                intent.putExtra("phone", binding.phone.getText().toString());
                saveText();
                //фиксируем результат перед завершением Activity
                startActivity(intent);
            }
        });
    }
    private void saveText() {
        sPref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        // Добавление сохраняемых данных
        editor.putString(keyName, binding.name.getText().toString());
        editor.putString(keySurname, binding.surname.getText().toString());
        editor.putString(keyPhone, binding.phone.getText().toString());
        editor.apply(); // Используйте apply() для асинхронного сохранения данных
    }

    private void loadText() {
        sPref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        // Извлечение сохранённых данных:
        String savedName = sPref.getString(keyName, "");
        String savedSurname = sPref.getString(keySurname, "");
        String savedPhone = sPref.getString(keyPhone, "");
        binding.name.setText(savedName); // Вывод в текстовое поле
        binding.surname.setText(savedSurname); // Вывод в текстовое поле
        binding.phone.setText(savedPhone); // Вывод в текстовое поле
    }
}
