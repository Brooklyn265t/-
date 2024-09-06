package com.example.parcel;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity {
    final String LOG_TAG = "myLogs";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Log.d(LOG_TAG, "getParcelableExtra");
        MyObject myobj = (MyObject) getIntent().getParcelableExtra(
                MyObject.class.getCanonicalName());
        Log.d(LOG_TAG, "myObj " +myobj.s + ", " + myobj.i);
    }
}
