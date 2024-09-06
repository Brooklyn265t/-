package com.example.savedata_1key2data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sPref;
    final String keyName = "BeloglintsevIvan";

    private void saveText(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        //добавление сохраняемых данных
        editor.putString(keyName, txtV.getText().toString());
        editor.commit(); //сохранение данных
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    private void loadText(){
        sPref = getPreferences(MODE_PRIVATE);
        //извлечение сохранённых данных:
        String savedText = sPref.getString(keyName, "");
        txtV.setText(savedText); // вывод в текстовое поле
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}