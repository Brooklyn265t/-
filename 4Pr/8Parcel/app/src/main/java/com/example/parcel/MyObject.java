package com.example.parcel;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

public class MyObject implements Parcelable {
    static final String LOG_TAG = "myLogs";
    public String s;
    public int i;

    //конструктор
    protected MyObject(String _s, int _i) {
        Log.d(LOG_TAG, "MyObject(String _s, int _i)");
        s = _s;
        i = _i;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        Log.d(LOG_TAG, "writeToParcel");
        parcel.writeString(s);
        parcel.writeInt(i);
        Log.d(LOG_TAG,"sent: " + parcel.dataSize());
    }

    public static final Parcelable.Creator<MyObject> CREATOR = new Parcelable.Creator<MyObject>() {
        @Override
        public MyObject createFromParcel(Parcel in) {
            Log.d(LOG_TAG, "createFromParcel");
            return new MyObject(in);
        }

        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };
    private MyObject(Parcel parcel){
        Log.d(LOG_TAG, "MyObject(Parcel parcel)");
        Log.d(LOG_TAG,"received: " + parcel.dataSize());
        s = parcel.readString();
        i = parcel.readInt();
    }
}
