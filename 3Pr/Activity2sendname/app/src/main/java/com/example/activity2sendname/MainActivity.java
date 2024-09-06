package com.example.activity2sendname;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.activity2sendname.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //создание намерения
        Intent intent = new Intent(this, Activity2.class);
        binding.Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity2ForResult.launch(intent); //передача намерения на исполнение
                //startActivity(intent);
            }
        });
    }
    ActivityResultLauncher<Intent> startActivity2ForResult = registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //обработка результата, возращённого из 2
                    if(result.getResultCode() == Activity2.RESULT_OK){
                        Intent intent = result.getData();
                        if(intent != null){
                            String name = intent.getStringExtra("Name");
                            binding.name.setText(name);
                        }
                    }
                    else {
                        String textError = "Error!";
                        binding.name.setText(textError);
                    }
                }
            });
}