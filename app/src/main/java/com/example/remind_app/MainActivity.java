package com.example.remind_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    Fragment fragment=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new Fragment_Remind();
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
        bottomNavigationView=findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_remind:
                        fragment = new Fragment_Remind();
                        break;
                    case R.id.navigation_note:
                        fragment = new Fragment_Note();
                        break;
                    case R.id.navigation_setting:
                        fragment = new Fragment_Setting_Kotlin();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
                return true;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity 1", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity 1", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity 1", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity 1", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity 1", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity 1", "onDestroy");
    }


}