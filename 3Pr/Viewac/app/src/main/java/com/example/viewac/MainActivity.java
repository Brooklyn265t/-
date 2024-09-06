package com.example.viewac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast message = Toast.makeText (this, "Белоглинцев Иван Алексеевич!", Toast.LENGTH_SHORT);
        message.setGravity(Gravity.CENTER, 0, 0);
    }
}