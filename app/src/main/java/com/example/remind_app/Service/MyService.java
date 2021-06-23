package com.example.remind_app.Service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.remind_app.R;
import com.example.remind_app.Song;

import java.security.Provider;

import static com.example.remind_app.Service.MyApplication.CHANNEL_ID;

public class MyService extends Service {

    Song mSong;

    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private MyBinder myBinder = new MyBinder();

    public class MyBinder extends Binder{
        public MyService getMyService(){
            return MyService.this;
        }
    }


    /*Triển khai phương thức này là cung cấp một giao diện để client
    có thể giao tiếp với Service thông qua một đối tượng IBinder do Service trả về.
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    /*Hệ thống gọi phương thức này khi Service được khởi tạo,
        và nó chỉ chạy một lần trước khi onStartCommand() hoặc onBind() được gọi.
        Nếu Service đã chạy thì phương thức này không được gọi lại lần nào nữa.
        */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    /*Hệ thống gọi phương thức này khi một thành phần khác (Activity chẳng hạn) gọi đến Service bằng câu lệnh startService().
     Khi phương thức này được thực hiện, dịch vụ được khởi động và có thể chạy trong background vô thời hạn.
     Khi công việc hoàn thành bạn nên stop bằng cách gọi stopService() từ một thành phần khác, hoặc cho chính Service gọi stopSelf().
     Nếu bạn chỉ muốn ràng buộc buộc với Service thì không nên sử dụng onStartCommand().
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);

        Bundle bundle=intent.getExtras();
        if(bundle!=null){
            Song song = (Song) bundle.get("1Song");
            mSong = song;
            startMusic(song);
            sendNotification(song);
        }

        return START_NOT_STICKY;
        /*Nếu hệ thống kill service khi giá trị này được trả về thì
        service này không được khởi động lại trừ khi có một Intent đang được chờ ở onStartCommand().*/
     }

     public Song getmSong(){
        return mSong;
     }

     public boolean isPlaying(){
        return isPlaying;
     }

    private void startMusic(Song song) {
        if(mediaPlayer==null){
            mediaPlayer = MediaPlayer.create(getApplicationContext(), song.getResoure());
        }
        mediaPlayer.start();
        isPlaying =true;
    }

    public void pauseMusic (){
        if (mediaPlayer!=null && isPlaying){
            mediaPlayer.pause();
            isPlaying=false;
        }
    }

    public void resumeMusic (){
        if (mediaPlayer!=null && !isPlaying){
            mediaPlayer.start();
            isPlaying=true;
        }
    }


    private void sendNotification(Song song) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Nhạc nền");
        builder.setContentText(song.getName());
        builder.setSmallIcon(R.drawable.icon_music);
        Notification notification = builder.build();
        startForeground(1, notification);
    }

    //Tháo bỏ gàn buộc onBind().
    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    //Khi Service bị hủy bỏ.
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
