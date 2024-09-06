package com.example.emptyactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация view перед добавлением в LinearLayout
        LayoutInflater ltInflater = getLayoutInflater();
        View view = ltInflater.inflate(R.layout.text, null, false);
        Log.d(LOG_TAG, "Class of view: " + view.getClass().toString());

        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);
        // Добавление view в LinearLayout
        linLayout.addView(view);

        // Инициализация view2 перед добавлением в RelativeLayout
        RelativeLayout rellayout = (RelativeLayout) findViewById(R.id.rellayout);
        View view2 = ltInflater.inflate(R.layout.text, rellayout, true);
        Log.d(LOG_TAG, "Class of view2: " + view2.getClass().toString());
    }
}

