package com.example.kliker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondLvlActivity extends AppCompatActivity {
    private int faza = 0;
    private int switchVariable = 1;
    private ImageView shtora;
    private ImageView shtora1;
    private Button open;
    private Button close;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        ImageView window = findViewById(R.id.window);
        shtora = findViewById(R.id.shtora);
        shtora1 = findViewById(R.id.shtora1);
        window.setImageResource(R.drawable.window);
        shtora.setImageResource(R.drawable.shtora);
        shtora1.setImageResource(R.drawable.shtora1);
        Button mainScreen = findViewById(R.id.button);
        Button fourthmain = findViewById(R.id.bottleLVL);
        open = findViewById(R.id.left);
        close = findViewById(R.id.right);

        mainScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                faza = faza - 1;
                if (faza < 0) {
                    faza = 0;
                    return;
                }

                updateImage(-50, 50);

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                faza = faza + 1;
                if (faza > 5) {
                    faza = 5;
                    return;
                }

                updateImage(50, -50);

            }
        });
        fourthmain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                startActivity(new Intent(SecondLvlActivity.this, FourthActivity.class));
            }
        });

 }
    protected void updateImage(int pixelShtora, int pixelShtora1) {


        shtora.animate()
                .xBy(pixelShtora)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        open.setEnabled(true);
                        close.setEnabled(true);
                    }
                })
                .withStartAction(new Runnable() {
                    @Override
                    public void run() {
                        open.setEnabled(false);
                        close.setEnabled(false);
                    }
                })
                .start();

        shtora1.animate()
                .xBy(pixelShtora1)
                .start();


    }
}





