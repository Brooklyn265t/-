package com.example.actionbarfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PageFragment extends Fragment {

    private int pageNumber;

    public static PageFragment newInstance(int page) {
        PageFragment fragment1 = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("num", page);
        fragment1.setArguments(args);
        return fragment1;
    }
    public PageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment, container, false);
        TextView pageHeader = result.findViewById(R.id.displayText);
        String header = "Фрагмент " + (pageNumber+1);
        pageHeader.setText(header);
        return result;
    }
}