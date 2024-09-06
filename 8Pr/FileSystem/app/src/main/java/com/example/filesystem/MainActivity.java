package com.example.filesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.example.filesystem.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private final static String FILE_NAME = "aaaa.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.saveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveText(v);
            }
        });
        binding.openText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openText(v);
            }
        });
    }
    //работа на внешнем накопителе
    private File getExternalPath(){
        //return new File(getExternalFilesDir(null), FILE_NAME);
        File folder = new File(getExternalFilesDir(null), "download");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return new File(folder, FILE_NAME);
    }

    //сохранение из файла
    public void saveText(View view) {
        FileOutputStream fos = null;
        try {
            String text = binding.editor.getText().toString();
            fos = new FileOutputStream(getExternalPath());
            fos.write(text.getBytes());
            Toast.makeText(this, "Файл сохранён", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            throw new RuntimeException(ex);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    //чтение из файла
    public void openText(View view){
        File file = getExternalPath();
        //если файл не существует, то - выход
        if(!file.exists()) return;
        FileInputStream fin = null;
        try{
            fin = new FileInputStream(file);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            binding.text.setText(text);
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

// запись и чтение во внутренном хранилище
//    //чтение из файла
//    public void openText(View view){
//        FileInputStream fin = null;
//        try{
//            fin = openFileInput(FILE_NAME);
//            byte[] bytes = new byte[fin.available()];
//            fin.read(bytes);
//            String text = new String (bytes);
//            binding.text.setText(text);
//        }
//        catch (IOException ex){
//            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//        finally {
//            try {
//                if(fin!=null){
//                    fin.close();
//                }
//            }
//            catch (IOException ex){
//                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//}