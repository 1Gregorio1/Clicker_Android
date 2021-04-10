package com.example.kliker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondLvlActivity extends AppCompatActivity {
    private int faza = 0;
    private int switchVariable = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        ImageView window = findViewById(R.id.window);
        ImageView shtora = findViewById(R.id.shtora);
        ImageView shtora1 = findViewById(R.id.shtora1);
        window.setImageResource(R.drawable.window);
        shtora.setImageResource(R.drawable.shtora);
        shtora1.setImageResource(R.drawable.shtora1);
        Button mainScreen = findViewById(R.id.button);
        Button open = findViewById(R.id.left);
        Button close = findViewById(R.id.right);

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

                updateImage(shtora,-100, 100, shtora1);

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                faza = faza + 1;
                if (faza > 2) {
                    faza = 2;
                    return;
                }

                updateImage(shtora,100, -100, shtora1);

            }
        });
    }

    protected void updateImage(ImageView shtora, int pixelShtora, int pixelShtora1,  ImageView shtora1) {


        shtora.animate()
                .xBy(pixelShtora)
                .start();
        shtora1.animate()
                .xBy(pixelShtora1)
                .start();


    }
}



