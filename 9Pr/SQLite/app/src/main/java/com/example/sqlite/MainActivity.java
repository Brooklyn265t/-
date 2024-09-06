package com.example.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sqlite.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                SQLiteDatabase db = getBaseContext().openOrCreateDatabase("myDB.db",
                        MODE_PRIVATE, null);
//                db.execSQL("CREATE TABLE IF NOT EXISTS cats (name TEXT, age INTEGER)");
//                db.execSQL("INSERT OR IGNORE INTO cats VALUES ('Tom', 7), ('Mtroskin', 3);");
                Cursor query = db.rawQuery("SELECT * FROM cats;", null);
                binding.textView.setText("");
                while (query.moveToNext()) {
                    String name = query.getString(0);
                    int age = query.getInt(1);
                    binding.textView.append("Name: " + name + ", Age: "+ age + ".\n");
                }
                query.close();
                db.close();
            }
        });
    }
}