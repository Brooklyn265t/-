package com.example.internetshop;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import com.example.internetshop.databinding.CartBinding;

public class SecondActivity extends AppCompatActivity {
    private CartBinding binding;
    private int totalSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CartBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ListView listView = binding.listView;

        // Получение списка товаров из Intent
        ArrayList<Product> selectedProducts = getIntent().getParcelableArrayListExtra("selectedProducts");

        // Создание и установка адаптера
        BoxAdapter adapter = new BoxAdapter(this, selectedProducts);
        listView.setAdapter(adapter);

        // Расчёт общей суммы
        totalSum = 0;
        for (Product product : selectedProducts) {
            totalSum += product.getPrice();
        }

        // Отображение общей суммы
        TextView totalPrice = binding.totalPrice;
        totalPrice.setText("Total: $" + totalSum);
    }
}