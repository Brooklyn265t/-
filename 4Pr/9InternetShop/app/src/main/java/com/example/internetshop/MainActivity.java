package com.example.internetshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internetshop.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<Product> products = new ArrayList<Product>();
    BoxAdapter boxAdapter;
    View footerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ListView listView = binding.listView;

        footerView = getLayoutInflater().inflate(R.layout.footer, null);
        TextView activeItemsCount = footerView.findViewById(R.id.activeItemsCount);
        Button btnShowCheckedItems = footerView.findViewById(R.id.btnShowCheckedItems);

        // Добавление Footer к ListView
        listView.addFooterView(footerView);

        // Создаём адаптер
        fillData();
        boxAdapter = new BoxAdapter(this, products);
        listView.setAdapter(boxAdapter); // Устанавливаем адаптер для ListView

        // Обработчик нажатия на кнопку Show Checked Items
        btnShowCheckedItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Реализация перехода во второе Activity
                ArrayList<Product> selectedProducts = boxAdapter.getBox();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("selectedProducts", (Serializable) selectedProducts);
                startActivity(intent);
            }
        });
    }

    View createFooter(String text) {
        // Создание экземпляра View из макета
        View view = getLayoutInflater().inflate(R.layout.footer, null);
        TextView footerTextView = view.findViewById(R.id.activeItemsCount); // Используйте правильный идентификатор
        footerTextView.setText(text);
        return view;
    }


    //генерируем данные для адаптера
    void fillData() {
        Random rn = new Random();
        int randomNum = 0;
        for (int i = 1; i <= 7; i++) {
            randomNum = rn.nextInt(999 - 10 + 1) + 10;
            int iconId;
            switch (i) {
                case 1:
                    iconId = R.drawable.icon1;
                    break;
                case 2:
                    iconId = R.drawable.icon2;
                    break;
                case 3:
                    iconId = R.drawable.icon3;
                    break;
                case 4:
                    iconId = R.drawable.icon4;
                    break;
                case 5:
                    iconId = R.drawable.icon5;
                    break;
                case 6:
                    iconId = R.drawable.icon6;
                    break;
                case 7:
                    iconId = R.drawable.icon7;
                    break;
                default:
                    iconId = R.drawable.ic_launcher_foreground; // По умолчанию, если что-то пошло не так
                    break;
            }
            products.add(new Product(randomNum, "Product " + i, i * 100, iconId, false));
        }
    }
}