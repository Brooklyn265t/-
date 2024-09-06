package com.example.bigtextreadfromfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Toast;

import com.example.bigtextreadfromfile.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.openText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openText(v);
            }
        });
    }
    //работа на внешнем накопителе
    private File getExternalPath(){
        return new File(getExternalFilesDir(null), "BigText.txt");
    }

    //чтение из файла
    public void openText(View view){
        File file = getExternalPath();
        //если файл не существует, то - выход
        if(!file.exists()) return;
        FileInputStream fin = null;
        try{
            fin = new FileInputStream(file);
            // Используем File.length() для определения размера файла
            byte[] bytes = new byte[(int) file.length()];
            fin.read(bytes);
            // Указываем кодировку при создании строки
            String text = new String(bytes, StandardCharsets.UTF_8);
            binding.text.setText(text);
            binding.text.setMovementMethod(new ScrollingMovementMethod());

        }
        catch (IOException ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                if(fin!=null){
                    fin.close();
                }
            }
            catch (IOException ex){
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
