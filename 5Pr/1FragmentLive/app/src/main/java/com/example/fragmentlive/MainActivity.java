package com.example.fragmentlive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.fragmentlive.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Log.d(LOG_TAG, "MainActivity onCreate");
    }

    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "MainActivity onStart");
    }

    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "MainActivity onResume");
    }

    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "MainActivity onPause");
    }

    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "MainActivity onStop");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "MainActivity onDestroy");
    }
}