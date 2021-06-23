package com.example.remind_app.Service;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;


//Lớp để chạy Foreground Service trong android
public class MyApplication extends Application {

    public static final String CHANNEL_ID = "CHANNEL_MUSIC" ;

    /*Hệ thống gọi phương thức này khi Service được khởi tạo,
         và nó chỉ chạy một lần trước khi onStartCommand() hoặc onBind() được gọi.
         Nếu Service đã chạy thì phương thức này không được gọi lại lần nào nữa.
         */
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


}
