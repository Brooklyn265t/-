package com.example.a2activityconverttemparture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a2activityconverttemparture.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private double data;
    private ActivityMainBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = new Intent(this, PrintActivity.class); //создание намерения
        binding.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSecondActivity();
            }
        });
    }
    private void startSecondActivity() {
        Intent intent = new Intent(this, PrintActivity.class);
        intent.putExtra("temperature", data);
        intent.putExtra("selectedUnit", binding.temperatureGroup.getCheckedRadioButtonId());
        startActivity(intent);
    }
}