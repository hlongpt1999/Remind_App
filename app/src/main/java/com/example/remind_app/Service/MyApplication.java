package com.example.remind_app.Service;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;

import com.example.remind_app.R;
import com.example.remind_app.Song;
import com.google.android.material.bottomnavigation.BottomNavigationView;


//Lớp để chạy Foreground Service trong android
public class MyApplication extends Application {

    public static final String CHANNEL_ID = "CHANNEL_MUSIC" ;
    private MyService myService;
    private Boolean isServiceConnected;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.MyBinder myBinder = (MyService.MyBinder) iBinder;
            myService = myBinder.getMyService();
            isServiceConnected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            myService=null;
            isServiceConnected=false;
        }
    };


    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChanel();//Notification cho Foreground service.
    }

    private void createNotificationChanel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) // Kiểm tra phiên bản di động.
        {
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID, "Chanel Music", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager!=null){
                manager.createNotificationChannel(channel);
            }
            
        }
    }

    private void StartService(){
        Intent intent = new Intent(this, MyService.class);
        Song song = new Song("Music", R.raw.app);
        Bundle bundle = new Bundle();
        bundle.putSerializable("1Song",song);
        intent.putExtras(bundle);
        startService(intent);

        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private void StopForegoundService(){
        Intent intent = new Intent(this, MyService.class);

        stopService(intent);
    }

    private void StopBoundService(){
        if (isServiceConnected){
            unbindService(mServiceConnection);
            isServiceConnected =false;
        }
    }
}
