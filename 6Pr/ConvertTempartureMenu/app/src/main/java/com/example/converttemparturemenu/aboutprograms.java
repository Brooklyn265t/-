package com.example.converttemparturemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.converttemparturemenu.databinding.ActivityAboutprogramsBinding;
import com.example.converttemparturemenu.databinding.ActivityPrintBinding;

public class aboutprograms extends AppCompatActivity {
    ActivityAboutprogramsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutprogramsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Закрытие текущей активности и возврат к предыдущей активности
            }
        });
    }
}