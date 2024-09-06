package com.example.sqliteopenhelper;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqliteopenhelper.databinding.ActivityCatBinding;

public class CatActivity extends AppCompatActivity {
    ActivityCatBinding binding;
    DatabaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor catCursor;
    long catId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCatBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        sqlHelper = new DatabaseHelper(getApplicationContext());
        db = sqlHelper.getWritableDatabase();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            catId = extras.getLong("id");
        }
        if (catId > 0) {
            catCursor = db.rawQuery(
                    "select * from " +
                            DatabaseHelper.TABLE +
                            " where  +" +
                            DatabaseHelper.COLUMN_ID + "=?",
                    new String[]{String.valueOf(catId)});
            catCursor.moveToFirst();
            binding.name.setText(catCursor.getString(1));
            binding.year.setText(String.valueOf(catCursor.getInt(2)));
            catCursor.close();
        } else {
            binding.deleteButton.setVisibility(View.GONE);
        }
    }
    public void save(View view){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME,
                binding.name.getText().toString());
        cv.put(DatabaseHelper.COLUMN_YEAR,
                Integer.parseInt(binding.year.getText().toString()));

        if (catId > 0) {
            db.update(DatabaseHelper.TABLE,
                    cv,
                    DatabaseHelper.COLUMN_ID + "=" + catId,
                    null);
        }
        else{
            db.insert(DatabaseHelper.TABLE, null, cv);
        }
        goMainActivity();
    }
    public void delete(View view){
        db.delete(DatabaseHelper.TABLE,
                "_id = ?",
                new String[]{String.valueOf(catId)});
        goMainActivity();
    }
    public void  goMainActivity(){
        db.close();
        //переход к main activity
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
