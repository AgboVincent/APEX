package com.mobile.apex.Screens;

import android.content.Intent;
import android.os.Bundle;

import com.mobile.apex.R;

import androidx.appcompat.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        // creating a thread to run the window
        Thread myThread = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    // intent to start the next activity
                    Intent intent = new Intent(getApplicationContext(), IntroScreen.class);
                    startActivity(intent);
                    // calling finishAffinity of this activity
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
