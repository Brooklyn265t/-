package com.example.taxi;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.taxi.databinding.ActivityMainBinding;
import com.example.taxi.databinding.ActivitySendTaxiBinding;

public class SendTaxi extends AppCompatActivity {
    private ActivitySendTaxiBinding binding;
    private boolean isFromAddressEntered = false;
    private boolean isToAddressEntered = false;


    private ActivityResultLauncher<Intent> addressResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                //лямбда выражение тело
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        String fromAddress = data.getStringExtra("Address");
                        String toAddress = data.getStringExtra("toAdress");
                        // Отображение данных в TextView
                        binding.fromAdress.setText(fromAddress);
                        binding.toAdress.setText(toAddress);
                        // Устанавливаем флаги в true, если адреса были введены
                        isFromAddressEntered = !fromAddress.isEmpty();
                        isToAddressEntered = !toAddress.isEmpty();
                        // Проверяем, должна ли кнопка быть активирована
                        updateSendTaxiButtonState();
                    }
                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendTaxiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.sendtaxi.setEnabled(false);

        binding.fromAdress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Не требуется
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Не требуется
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Проверяем, не пустое ли поле ввода
            }
        });

        // Извлечение данных из MainActivity
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String surname = intent.getStringExtra("surname");
        String phone = intent.getStringExtra("phone");

        // Использование полученных данных
        binding.viewname.setText(name);
        binding.viewsurname.setText(surname);
        binding.viewphone.setText(phone);

        //создание намерения
        Intent adressIntent = new Intent(this, Adress.class);
        binding.addadress.setOnClickListener((View view1) -> {
            addressResultLauncher.launch(adressIntent); // Запуск Adress активности
        });

        binding.sendtaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(SendTaxi.this, "Такси отправлено", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void updateSendTaxiButtonState() {
        // Кнопка активируется только если оба адреса были введены
        binding.sendtaxi.setEnabled(isFromAddressEntered && isToAddressEntered);
    }
}