package com.example.datepickerdialogandtimepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.datepickerdialogandtimepickerdialog.databinding.ActivityMainBinding;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    Calendar dataAndTime=Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setInitialDateTime();
    }
    // отоюражение диалогового окна для выбора даты
    public void setData(View v){
        new DatePickerDialog(MainActivity.this, d,
                dataAndTime.get(Calendar.YEAR),
                dataAndTime.get(Calendar.MONTH),
                dataAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }
    // отоюражение диалогового окна для выбора времени
     public void setTime(View v){
        new TimePickerDialog(MainActivity.this, t,
                dataAndTime.get(Calendar.HOUR_OF_DAY),
                dataAndTime.get(Calendar.MINUTE), true)
                .show();
    }
    // установка начальных даты и времени
    public void  setInitialDateTime(){
        binding.currentDataTime.setText(DateUtils.formatDateTime(this, dataAndTime.getTimeInMillis(),
        DateUtils.FORMAT_SHOW_DATE |DateUtils.FORMAT_SHOW_YEAR
        | DateUtils.FORMAT_SHOW_TIME));
    }
    // установка обработчика выбора времени
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dataAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dataAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTime();
        }
    };
    // установка обработчика выбора даты
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            dataAndTime.set(Calendar.YEAR, year);
            dataAndTime.set(Calendar.MONTH, monthOfYear);
            dataAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };
}