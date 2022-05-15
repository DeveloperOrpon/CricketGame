package com.bluehomestudio.luckywheeldemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView backbtn;
    private LuckyWheel lw;
    List<WheelItem> wheelItems ;
    TextView details,marks,over;
    int total=0;
    int wicket=5;
    int random;
    int over1=0,over2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWindowAnimations();
        generateWheelItems();
        lw = findViewById(R.id.lwv);
        lw.addWheelItems(wheelItems);
        lw.setTarget(1);
        over=findViewById(R.id.over);
        marks=findViewById(R.id.marks);
        details=findViewById(R.id.details);
        backbtn=findViewById(R.id.backbtn);
        final Button start = findViewById(R.id.start);
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    random=new Random().nextInt(7);
                    random=random+1;
                    over2=over2+1;
                    if(wicket>=1 && over1<2){
                        lw.rotateWheelTo(random);
                        start.setEnabled(false);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                if(random==1){
                                    total=total+6;
                                }
                                if(random==3){
                                    total=total+4;
                                }
                                if(random==5){
                                    total=total+2;
                                }
                                if(random==7){
                                    total=total+1;
                                }
                                if(random==2 | random==4 | random==6) {
                                    wicket=wicket-1;
                                }
                                if(wicket<=0){
                                    Toast toast = Toast.makeText(getApplicationContext(),"All Out", Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                                if (over2==6){
                                    over2=0;
                                    over1=over1+1;
                                }
                                over.setText("Over :"+over1+"."+over2);
                                marks.setText("Run :"+total);
                                details.setText("Wicket "+wicket);
                                start.setEnabled(true);
                            }
                        }, 1600);
                    }
                }
            });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Start.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, options.toBundle());
                startActivity(intent);
                finish();
            }
        });

    }

    private void generateWheelItems() {
        wheelItems = new ArrayList<>();
        wheelItems.add(new WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(getResources(),
                R.drawable.chat) , "6 RUN"));
        wheelItems.add(new WheelItem(Color.parseColor("#F00E6F"), BitmapFactory.decodeResource(getResources(),
                R.drawable.out) , "RUN OUT"));
        wheelItems.add(new WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(getResources(),
                R.drawable.four) , "4 RUN"));
        wheelItems.add(new WheelItem(Color.parseColor("#F00E6F"), BitmapFactory.decodeResource(getResources(),
                R.drawable.out), "CATCH-OUT"));
        wheelItems.add(new WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(getResources(),
                R.drawable.two), "2-RUN"));
        wheelItems.add(new WheelItem(Color.parseColor("#F00E6F"), BitmapFactory.decodeResource(getResources(),
                R.drawable.out), "BOWLED-OUT"));
        wheelItems.add(new WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(getResources(),
                R.drawable.one), "One Run"));
        wheelItems.add(new WheelItem(Color.parseColor("#F00E6F"), BitmapFactory.decodeResource(getResources(),
                R.drawable.noball), "NO BALL"));
    }

    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(2000);
        getWindow().setEnterTransition(fade);
    }

}
