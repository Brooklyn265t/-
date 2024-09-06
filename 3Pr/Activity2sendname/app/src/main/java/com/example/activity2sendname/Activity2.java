package com.example.activity2sendname;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.activity2sendname.databinding.Activity2Binding;

public class Activity2 extends AppCompatActivity {
    private Activity2Binding binding;
    SharedPreferences sPref;
    final String keyName = "BeloglintsevIvan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Activity2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.Sumbitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.Name.getText().toString();
                Intent intent = new Intent();
                //передаём содержимое текстового поля:
                intent.putExtra("Name", binding.Name.getText().toString());
                //фиксируем результат перед завершением Activity
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        //добавление сохраняемых данных
        editor.putString(keyName, binding.Name.getText().toString());
        editor.commit(); //сохранение данных
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        //извлечение сохранённых данных:
        String savedText = sPref.getString(keyName, "");
        binding.Name.setText(savedText); // вывод в текстовое поле
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }
}
