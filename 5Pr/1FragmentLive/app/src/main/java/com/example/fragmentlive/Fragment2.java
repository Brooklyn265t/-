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


import com.example.fragmentlive.databinding.Fragment2Binding;

public class Fragment2 extends Fragment {
    private Fragment2Binding binding;
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
        binding = Fragment2Binding.inflate(inflater,container,false);
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
    //в конце вызывается метод onDestory для Activity
}

