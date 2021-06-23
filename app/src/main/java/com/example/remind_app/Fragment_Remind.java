package com.example.remind_app;

import android.app.Notification;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import static com.example.remind_app.Service.MyApplication.CHANNEL_ID;

public class Fragment_Remind extends Fragment {
    MediaPlayer mp;
    TextView text_remind;
    Button btnPlay;
    int i;
    int lenght;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remind, container, false);
        anhxa(view);//Ánh xạ các thành phần của layout.

        i=0;
        BUTTON_PLAY();
        String string = getResources().getString(R.string.title_remind);
        text_remind.setText(string);
        return view;
    }

    void anhxa(View view){
        text_remind = view.findViewById(R.id.text_remind);
        btnPlay = view.findViewById(R.id.btnPlay);
    }

    void BUTTON_PLAY(){
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotificationMedia();
                if (i==0){
                    mp.pause();
                    lenght=mp.getCurrentPosition();
                    i++;
                } else {
                    mp.seekTo(lenght);
                    mp.start();
                    i=0;
                }
            }
        });
    }

    private void sendNotificationMedia() {
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
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment 1", "onCreate");
        mp = MediaPlayer.create(getActivity(), R.raw.app);
        mp.setLooping(true);
        mp.setVolume(80, 80);
        mp.start();
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
