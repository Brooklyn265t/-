package com.example.jsonsavedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.jsonsavedata.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private ArrayAdapter<Cat> adapter;
    private List<Cat> cats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cats = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, cats);
        binding.list.setAdapter(adapter);
        binding.addButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add(view);
            }
        });
        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(view);
            }
        });
        binding.openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(view);
            }
        });
    }

    public void add(View view){
        String name = binding.nameText.getText().toString();
        int age = Integer.parseInt(binding.ageText.getText().toString());
        Cat cat = new Cat(name, age);
        cats.add(cat);
        adapter.notifyDataSetChanged();
    }
    public void save(View view){
        boolean result = myJSON.exportToJSON(this, cats);
        if(result){
            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Данные не сохранены",
                    Toast.LENGTH_LONG).show();
        }
    }
    public void open(View view){
        cats = myJSON.importFromJSON(this);
        if(cats!=null){
            adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, cats);
            binding.list.setAdapter(adapter);
            Toast.makeText(this, "Данные восстановлены",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Не удалось открыть данные",
                    Toast.LENGTH_LONG).show();
        }
    }
}