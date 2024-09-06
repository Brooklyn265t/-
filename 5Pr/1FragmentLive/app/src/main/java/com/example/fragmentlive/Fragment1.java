package com.example.fragmentlive;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.fragmentlive.databinding.Fragment1Binding;

public class Fragment1 extends Fragment {
    private Fragment1Binding binding;
    final String LOG_TAG = "myLogs";

    @Override
    //при ghbrktgktybb ahfpvtynf r сешмшен
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        Log.d(LOG_TAG, "Fragment1 onAttach");
    }
    //при создании фрагмента (пока без доступа к UI)
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onCreate");
    }
    //оздание view (содержимого) фрагмента и передача его системе
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        Log.d(LOG_TAG, "Fragment1 onCreateView");
        binding = Fragment1Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    //далле срабатывает метод Activity - onCreate
    //сообщаем фрагменту, что view ргамент создано (можно с ним рабоать)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onViewStateRestored");
    }
    public void onViewStateRestored(@Nullable Bundle savedInstanceState){
        super.onViewStateRestored(savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onViewStateRestored");
    }

    //далее метод Activity - onStart, после него onStart фрагмента - аналогичен методу Activity,
    //фрагмент виден пользователю
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "Fragment1 onStart");
    }
    //далее метод Activity - onResume, после него onResume фрагмента - аналогичен методу Activity,
    //фрагмент доступн для взаимодействия:
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "Fragment1 onResume");
    }
    //методы onPause и onStop для фрагментов Activity - фрагмента и Activity более недоступны,
    //для взаимодействия, а потом не видны пользователю:
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "Fragment1 onPause");
    }

    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "Fragment1 onStop");
    }
    //View, которое создавали в onCreateView, более недоступно:
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(LOG_TAG, "Fragment1 onDestroyView");
    }
    //аналог метода onDestroy у Activity:
    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "Fragment1 onDestroy");
    }
    //фрагмент отсоединён от Activity:
    public void onDetach(){
        super.onDetach();
        Log.d(LOG_TAG, "Fragment1 onDetach");
    }
    //в конце вызывается метод onDestory для Activity
}
