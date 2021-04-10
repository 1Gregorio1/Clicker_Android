package com.example.kliker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondLvlActivity extends AppCompatActivity{
    private int faza = 1;
    private int switchVariable = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        ImageView window = findViewById(R.id.window);
        ImageView shtora = findViewById(R.id.shtora);
        ImageView shtora2 = findViewById(R.id.shtora);
        window.setImageResource(R.drawable.window);
        shtora.setImageResource(R.drawable.shtora);
        shtora2.setImageResource(R.drawable.shtora2);
        Button mainScreen = findViewById(R.id.button);
        Button left = findViewById(R.id.left);
        Button right = findViewById(R.id.right);

        mainScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    left.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            faza = faza - 1;
            if (faza < 0) {
                faza = 0;
            }

            updateImage(shtora);
        }
    });

        right.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            faza = faza + 1;
            if (faza > 2) {
                faza = 2;
            }

            updateImage(shtora);
        }
    });
    }
        protected void updateImage(ImageView shtora) {


            switch (faza) {
                case 0:
                    shtora.setImageResource(R.drawable.shtora);
                    shtora.setImageResource(R.drawable.shtora2);
                    break;
                case 1:
                    shtora.setImageResource(R.drawable.shtora);
                    shtora.setImageResource(R.drawable.shtora2);
                    break;
                case 2:
                    shtora.setImageResource(R.drawable.shtora);
                    break;



        }
    }
}


