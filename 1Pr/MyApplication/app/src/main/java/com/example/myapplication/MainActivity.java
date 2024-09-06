package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button b_ok;
    private Button b_cancel;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }


    private void initViews(){
        b_ok = (Button) findViewById(R.id.btnOk);
        b_cancel = (Button) findViewById(R.id.bCancel);
        message = (TextView) findViewById(R.id.textview);
        b_ok.setOnClickListener(this);
        b_cancel.setOnClickListener(this);
        if (b_ok != null)
            message.setText("Кнопка есть");
        else
            message.setText("Кнопки нет");
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnOk) {
            message.setText("Ок! нажми Cancel");
            b_ok.setEnabled(false);
            b_cancel.setEnabled(true);
        } else if (id == R.id.bCancel) {
            message.setText("Cancel! нажми Ok");
            b_cancel.setEnabled(false);
            b_ok.setEnabled(true);
        }
    }
}