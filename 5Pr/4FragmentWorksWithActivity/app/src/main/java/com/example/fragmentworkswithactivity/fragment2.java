package com.example.fragmentworkswithactivity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentworkswithactivity.databinding.FragmentFragment1Binding;
import com.example.fragmentworkswithactivity.databinding.FragmentFragment2Binding;


public class fragment2 extends Fragment {
    public interface onSomeEventListener{
        public void someEvent(String s);
    }
    onSomeEventListener someEventListener;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try {
            someEventListener = (onSomeEventListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString() +
                    "must implement on-SomeEventListener");
        }
    }
    private FragmentFragment2Binding binding;
    final String LOG_TAG = "myLogs";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFragment2Binding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(LOG_TAG, "Button click in Fragment2");
                someEventListener.someEvent("Text text to Fragment1");
            }
        });
        return view;
    }
}