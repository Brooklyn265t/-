package com.example.fragmentworkswithactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fragmentworkswithactivity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
        implements fragment2.onSomeEventListener{
    private ActivityMainBinding binding;
    private static final int CONTENT_VIEW_ID = 10101010;
    fragment2 frag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.fragment2.setId(CONTENT_VIEW_ID);
        frag2 = new fragment2();
        FragmentTransaction fTrans;
        fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.add(CONTENT_VIEW_ID, frag2);
        fTrans.commit();
    }
    public void onClick(View v){
        Fragment frag1 = getSupportFragmentManager().findFragmentById(R.id.fragment1);
        ((TextView) frag1.getView().findViewById(R.id.textView))
                .setText("Access to Fragment 1 from Activity");
        ((TextView) frag2.getView().findViewById(R.id.textView))
                .setText("Access to Fragment 2 from Activity");
    }

    @Override
    public void someEvent(String s) {
        Fragment frag1 = getSupportFragmentManager().findFragmentById(R.id.fragment1);
        ((TextView) frag1.getView().findViewById(R.id.textView))
                .setText("Text from Fragment 2:" + s);
    }
}