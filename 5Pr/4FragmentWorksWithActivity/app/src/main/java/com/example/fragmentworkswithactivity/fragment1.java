package com.example.fragmentworkswithactivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragmentworkswithactivity.databinding.FragmentFragment1Binding;



public class fragment1 extends Fragment {
    private FragmentFragment1Binding binding;
    final String LOG_TAG = "myLogs";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFragment1Binding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(LOG_TAG, "Button click in Fragment1");
                ((Button)getActivity().findViewById(R.id.btnFind)).setText("Acess from Fragment1");
            }
        });
        return view;
    }
}