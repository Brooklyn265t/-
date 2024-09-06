package com.example.selectedlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.selectedlistview.databinding.ActivityMainBinding;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    final String LOG_TAG = "myLogs";
    ListView lvMain;
    String[] names;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        lvMain = binding.lvMain;
        lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names,
                android.R.layout.simple_list_item_multiple_choice);
        lvMain.setAdapter(adapter);
        Button btnChecked = binding.btnChecked;
        btnChecked.setOnClickListener(this);

        //получаем масив из файла ресурсов
        names = getResources().getStringArray(R.array.names);
    }

    //public void onClick(View arg0) {
    //пишем в лог выделенный элемент
    //    Log.d(LOG_TAG, "CHECKED: "+ names[lvMain.getCheckedItemPosition()]);
    //}
    public void onClick(View arg0) {
        //пишем в лог выделенный элемент
        Log.d(LOG_TAG, "CHECKED:");
        SparseBooleanArray sbArray = lvMain.getCheckedItemPositions();
        for (int i = 0; i <sbArray.size(); i++){
            int key = sbArray.keyAt(i);
            if (sbArray.get(key)){
                Log.d(LOG_TAG, names[key]);
            }
        }
    }
}