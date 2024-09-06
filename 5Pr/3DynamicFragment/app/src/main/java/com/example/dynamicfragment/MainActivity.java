package com.example.dynamicfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.dynamicfragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction fTrans;
    Fragment1 frag1;
    Fragment2 frag2;
    private ActivityMainBinding binding;

    //числовой индефикатор контейнера для фрагментов
    private static final int CONTENT_VIEW_ID = 10101010;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.fragmentContainer.setId(CONTENT_VIEW_ID);
        frag1 = new Fragment1();
        frag2 = new Fragment2();

        binding.Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(savedInstanceState == null){
                    fTrans = getSupportFragmentManager().beginTransaction();
                    fTrans.add(CONTENT_VIEW_ID, frag1);
                    if (binding.swStack.isChecked()){
                        fTrans.addToBackStack(null);
                    }
                    fTrans.commit();
                }
            }
        });

        binding.Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fTrans = getSupportFragmentManager().beginTransaction();
                fTrans.remove(frag1);
                if (binding.swStack.isChecked()){
                    fTrans.addToBackStack(null);
                }
                fTrans.commit();
            }
        });

        binding.Replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fTrans = getSupportFragmentManager().beginTransaction();
                fTrans.replace(CONTENT_VIEW_ID, frag2);
                if (binding.swStack.isChecked()){
                    fTrans.addToBackStack(null);
                }
                fTrans.commit();
            }
        });
    }
}