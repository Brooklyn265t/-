package com.example.converttemparturemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.converttemparturemenu.databinding.ActivityMainBinding;

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        if (item.getItemId() == R.id.program) {
            intent = new Intent(this, aboutprograms.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.me) {
            intent = new Intent(this, aboutme.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}