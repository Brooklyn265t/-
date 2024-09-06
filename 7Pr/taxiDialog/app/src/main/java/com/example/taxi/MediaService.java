package com.example.taxi;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MediaService extends Service {
    MediaPlayer ambientMediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate(){
        Log.d("MediaService", "Сервис создан");
        ambientMediaPlayer = MediaPlayer.create(this, R.raw.yupi);
        ambientMediaPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d("MediaService", "Сервис запущен");
        ambientMediaPlayer.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy(){
        Log.d("MediaService", "Сервис уничтожен");
        ambientMediaPlayer.stop();
    }
}


