package com.example.remind_app;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.example.remind_app.Service.MyService;

import static com.example.remind_app.Service.MyApplication.CHANNEL_ID;

public class Fragment_Remind extends Fragment {
    MediaPlayer mp;
    TextView text_remind, txtMusicName;
    Button btnPlay, btnStop;
    RelativeLayout layoutMusic;
    ImageView imgPlayMusic;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remind, container, false);
        anhxa(view);//Ánh xạ các thành phần của layout.
        BUTTON_PLAY();
        BUTTON_STOP();
        BUTTON_MUSIC();
        String string = getResources().getString(R.string.title_remind);
        text_remind.setText(string);
        return view;
    }

    void anhxa(View view){
        text_remind = view.findViewById(R.id.text_remind);
        btnPlay = view.findViewById(R.id.btnPlay);
        btnStop = view.findViewById(R.id.btnStop);
        layoutMusic = view.findViewById(R.id.layoutMusic);
        txtMusicName = view.findViewById(R.id.txtMusicName);
        imgPlayMusic = view.findViewById(R.id.imgPlayMusic);
    }

    void BUTTON_PLAY(){
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                sendNotificationMedia();
                    appStartService();
                    layoutMusic.setVisibility(View.VISIBLE);
                    btnStop.setVisibility(View.VISIBLE);
                    btnPlay.setVisibility(View.INVISIBLE);
                }
        });
    }

    void BUTTON_STOP(){
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myService.pauseMusic();
                appStopService();
                layoutMusic.setVisibility(View.INVISIBLE);
                btnStop.setVisibility(View.INVISIBLE);
                btnPlay.setVisibility(View.VISIBLE);
            }
        });
    }

    void BUTTON_MUSIC(){
        imgPlayMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myService.isPlaying()){
                    imgPlayMusic.setImageResource(R.drawable.icon_play);
                    myService.pauseMusic();
                }
                else {
                    imgPlayMusic.setImageResource(R.drawable.icon_pause);
                    myService.resumeMusic();
                }
            }
        });
    }

   /* private void sendNotificationMedia() {
        MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(getActivity(), "tag");

        Notification notification = new NotificationCompat.Builder(getActivity(), CHANNEL_ID)
                .setSmallIcon(R.drawable.icon_music)
                .setSubText("Hải Long")
                .setContentTitle("Title")
                .setContentText("Single")
                .addAction(R.drawable.icon_play, "Play", null)
                .addAction(R.drawable.icon_pause, "Pause", null)
                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(1)
                        .setMediaSession(mediaSessionCompat.getSessionToken())
                ).build();

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getActivity());
        managerCompat.notify(1, notification);
    }*/


    public static final String CHANNEL_ID = "CHANNEL_MUSIC" ;
    private MyService myService;
    private Boolean isServiceConnected;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.MyBinder myBinder = (MyService.MyBinder) iBinder;
            myService = myBinder.getMyService();
            isServiceConnected = true;

            handleLayoutMusic();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            myService=null;
            isServiceConnected=false;
        }
    };

    private void appStartService(){
        Intent intent = new Intent(getActivity(), MyService.class);
        Song song = new Song("Music", R.raw.app);
        Bundle bundle = new Bundle();
        bundle.putSerializable("1Song",song);
        intent.putExtras(bundle);
        getActivity().startService(intent);

        getActivity().bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private void appStopService(){
        Intent intent = new Intent(getActivity(), MyService.class);
        getActivity().stopService(intent);
        if (isServiceConnected){
            getActivity().unbindService(mServiceConnection);
            isServiceConnected =false;
        }
    }


    private void handleLayoutMusic(){
        layoutMusic.setVisibility(View.VISIBLE);
        txtMusicName.setText(myService.getmSong().getName());
    }

    private void setStatusMusic(){
        if (myService==null){
            return;
        }

        if (myService.isPlaying()){

        }else {

        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment 1", "onCreate");
//        mp = MediaPlayer.create(getActivity(), R.raw.app);
//        mp.setLooping(true);
//        mp.setVolume(80, 80);
//        mp.start();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("Fragment 1", "Attach");
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Fragment 1", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Fragment 1", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Fragment 1", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Fragment 1", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragment 1", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragment 1", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment 1", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Fragment 1", "onDetach");
    }
}
