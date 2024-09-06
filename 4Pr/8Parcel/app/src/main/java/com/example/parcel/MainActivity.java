package com.example.parcel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";
    Parcel p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onclick(View v) {
        MyObject myobj = new MyObject("yupi", 1);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MyObject.class.getCanonicalName(), myobj);
        Log.d(LOG_TAG, "startActivity");
        startActivity(intent);
    }
}

//    void writeParcel(){
//        p = Parcel.obtain();
//        byte b = 1;
//        int i = 2;
//        long l = 3;
//        float f = 4;
//        double d = 5;
//        String s = "abcdefgh";
//        logWriteInfo("before writing");
//        p.writeByte(b);
//        logWriteInfo("Byte");
//        p.writeInt(i);
//        logWriteInfo("int");
//        p.writeLong(l);
//        logWriteInfo("long");
//        p.writeFloat(f);
//        logWriteInfo("float");
//        p.writeDouble(d);
//        logWriteInfo("double");
//        p.writeString(s);
//        logWriteInfo("String");
//    }
//    void logWriteInfo(String txt){
//        Log.d(LOG_TAG, txt + ": " + "dataSize = " + p.dataSize());
//    }
//    void readParcel(){
//        logReadInfo("Before reading");
//        p.setDataPosition(0);
//        logReadInfo("byte = " + p.readByte());
//        logReadInfo("int = " + p.readInt());
//        logReadInfo("long = " + p.readLong());
//        logReadInfo("float = " + p.readFloat());
//        logReadInfo("double = " + p.readDouble());
//        logReadInfo("string = " + p.readString());
//    }
//    void logReadInfo(String txt) {
//        Log.d(LOG_TAG, txt + ": " + "dataPosition = " + p.dataPosition());
//    }
//}