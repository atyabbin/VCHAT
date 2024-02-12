package com.example.vchatapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static final long SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app's main activity
                Intent i = new Intent(MainActivity.this, Signup_activity.class);
                startActivity(i);

                // Close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}