package com.bluehomestudio.luckywheeldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity2 extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        handlerSplash();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    public void handlerSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(MainActivity2.this, Start.class));
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}