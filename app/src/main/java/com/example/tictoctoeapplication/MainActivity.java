package com.example.tictoctoeapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ImageView i1,info;
    ProgressBar p1;
    Button b1;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConstraintLayout constraintLayout = findViewById(R.id.root_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();


        i1 = (ImageView) findViewById(R.id.logo);
        info = (ImageView) findViewById(R.id.info);
        p1 = (ProgressBar) findViewById(R.id.progressBar);
        b1 = (Button) findViewById(R.id.play_btn);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                p1.setVisibility(View.GONE);
            }
        },6000);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,InfoActivity.class));
                finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setText(R.string.please_wait);
                p1.setVisibility(View.VISIBLE);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b1.setText(R.string.game_started);
                        p1.setVisibility(View.INVISIBLE);
                        b1.setTextColor(Color.parseColor("#3DDC84"));

                        startActivity(new Intent(MainActivity.this,TwoNameActivity.class));
                        finish();

                    }
                },4000);
            }
        });
    }
}