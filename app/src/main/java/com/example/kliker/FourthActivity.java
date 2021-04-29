package com.example.kliker;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class FourthActivity extends AppCompatActivity {
    public static final Random sRandom = new Random();
    private ImageView mBottleImageView;
    private int lastAngle = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_main);

        mBottleImageView = (ImageView) findViewById(R.id.image);
        mBottleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinBottle();
            }
        });
    }
    private void spinBottle() {
        int angle = sRandom.nextInt(3600 - 360) + 360;
        //центр вращения
        float pivotX = mBottleImageView.getWidth() / 2;
        float pivotY = mBottleImageView.getHeight() / 2;

        final Animation animation = new RotateAnimation(lastAngle == -1 ? 0 : lastAngle, angle, pivotX, pivotY);
        lastAngle = angle;
        animation.setDuration(2500);
        animation.setFillAfter(true);
        //Отслеживание состояния анимации
        animation.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationStart(Animation animation) {
                mBottleImageView.setClickable(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mBottleImageView.setClickable(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mBottleImageView.startAnimation(animation);

    }
}
