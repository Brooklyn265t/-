package com.example.sqliteopenhelper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sqliteopenhelper.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor catCursor;
    SimpleCursorAdapter catAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.catList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), CatActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        databaseHelper = new DatabaseHelper(getApplicationContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        //подключение к БД
        db = databaseHelper.getReadableDatabase();
        //получение данных из БД в курсоре
        catCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE,
                null);
        //какие столбца из курсора будут выведены в ListView
        String[] headers = new String[]{DatabaseHelper.COLUMN_NAME,
                DatabaseHelper.COLUMN_YEAR};
        //
        catAdapter = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item,
                catCursor,
                headers,
                new int[]{android.R.id.text1, android.R.id.text2},
                0);
        binding.catList.setAdapter(catAdapter);
    }

    public void add(View view){
        Intent intent = new Intent(this, CatActivity.class);
        startActivity(intent);
    }

    @Override
    public void  onDestroy(){
        super.onDestroy();
        db.close();
        catCursor.close();
    }
}


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);
//        databaseHelper = new DatabaseHelper(getApplicationContext());
//    }
//    @Override
//    public void onResume(){
//        super.onResume();
//        //подключение к БД
//        db = databaseHelper.getReadableDatabase();
//        //получение данных из БД в курсоре
//        catCursor = db.rawQuery("select * from "+DatabaseHelper.TABLE,
//                null);
//        //какие столбца из курсора будут выведены в ListView
//        String[] headers = new String[] {DatabaseHelper.COLUMN_NAME,
//                                         DatabaseHelper.COLUMN_YEAR};
//        //
//        catAdapter = new SimpleCursorAdapter(this,
//                android.R.layout.two_line_list_item,
//                catCursor,
//                headers,
//                new int[] {android.R.id.text1, android.R.id.text2},
//                0);
//        binding.header.setText("Найдено элементов: " + catCursor.getCount());
//        binding.catList.setAdapter(catAdapter);
//    }
//    @Override
//    public void  onDestroy(){
//        super.onDestroy();
//        db.close();
//        catCursor.close();
//    }
//}