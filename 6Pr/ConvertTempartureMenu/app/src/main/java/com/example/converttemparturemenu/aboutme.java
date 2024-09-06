package com.example.converttemparturemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.converttemparturemenu.databinding.ActivityAboutmeBinding;
import com.example.converttemparturemenu.databinding.ActivityAboutprogramsBinding;

public class aboutme extends AppCompatActivity {

    ActivityAboutmeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutmeBinding.inflate(getLayoutInflater());
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