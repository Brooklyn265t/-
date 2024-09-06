package com.example.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.taxi.databinding.ActivityAdressBinding;

public class Adress extends AppCompatActivity {

    private ActivityAdressBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdressBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.Saveaddres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String street= binding.fromStreet.getText().toString();
                String home = binding.fromHome.getText().toString();
                String flat = binding.fromFlat.getText().toString();
                String tostreet= binding.toStreet.getText().toString();
                String tohome = binding.toHome.getText().toString();
                String toflat = binding.toFlat.getText().toString();

                String fromAdress = String.format("%s, %s, %s", street, home, flat);
                String toAdress = String.format("%s, %s, %s", tostreet, tohome, toflat);
                Intent from = new Intent();
                // Передаём объединённые данные
                from.putExtra("Address", fromAdress);
                from.putExtra("toAdress", toAdress);
                //фиксируем результат перед завершением Activity
                setResult(RESULT_OK, from);
                finish();
            }
        });
    }
}