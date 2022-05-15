package com.bluehomestudio.luckywheeldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.shurajcodx.appratingdialog.AppRatingDialog;

public class Start extends AppCompatActivity {
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        setupWindowAnimations();
        LinearLayout startbtn = findViewById(R.id.startbtn);
        LinearLayout about = findViewById(R.id.about);
        LinearLayout onlinebtn = findViewById(R.id.onlinebtn);
        LinearLayout settings = findViewById(R.id.settings);
        LinearLayout score = findViewById(R.id.score);
        LinearLayout share = findViewById(R.id.share);
        startbtn.setAlpha(0f);
        share.setAlpha(0f);
        score.setAlpha(0f);
        about.setAlpha(0f);
        onlinebtn.setAlpha(0f);
        settings.setAlpha(0f);
        share.animate().alpha(1f).setDuration(1200);
        settings.animate().alpha(1f).setDuration(1200);
        score.animate().alpha(1f).setDuration(1200);
        onlinebtn.animate().alpha(1f).setDuration(1200);
        about.animate().alpha(1f).setDuration(1200);
        startbtn.animate().alpha(1f).setDuration(1200);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(intent);
                finish();
            }
        });
        dialog=new Dialog(this);
        onlinebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setContentView(R.layout.updateactivity);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setContentView(R.layout.updateactivity);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AppRatingDialog appRatingDialog = new AppRatingDialog.Builder(Start.this)
                        .setTriggerCount(2)
                        .setRepeatCount(5)
                        .build();
                appRatingDialog.show();
            }
        });
    }
    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setDuration(2000);
        getWindow().setExitTransition(slide);
    }
}