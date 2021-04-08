package com.example.kliker;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThreeActivity extends AppCompatActivity {
    private int couter = 1000;
    private int switchVariable = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_main);
        TextView counterview = findViewById(R.id.text);
        ImageView glas = findViewById(R.id.glas);
        glas.setImageResource(R.drawable.glas00);
        Button threscreen = findViewById(R.id.button);
        Button minusTen = findViewById(R.id.button_minus);
        Button minushundred = findViewById(R.id.button_minus_hundred);
        Button plusfifty = findViewById(R.id.button_plus_fifty);
        counterview.setText(couter + "");


        glas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                couter--;
                if (couter < 0) {
                    couter = 0;
                    return;
                }

                counterview.setText(couter + "");
                updateImage(glas);
            }
        });
        threscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        minusTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                couter = couter - 10;
                if (couter < 0){
                    couter = 0;
                }
                counterview.setText(couter + "");
                updateImage(glas);
            }
        });

        minushundred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                couter = couter - 100;
                if (couter < 0){
                    couter = 0;
                }
                counterview.setText(couter + "");
                updateImage(glas);
            }
        });

        plusfifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                couter = couter + 50;
                if (couter > 1000) {
                    couter = 1000;
                }
                counterview.setText(couter + "");
                updateImage(glas);
            }
        });
    }

    protected void updateImage(ImageView glas) {
        if (couter > 0 && couter <= 350) switchVariable = 0;
        else if (couter > 350 && couter <= 520) switchVariable = 1;
        else if (couter > 520 && couter <= 910) switchVariable = 2;
        else if (couter == 1000) switchVariable = 3;
        switch (switchVariable) {
            case 0:
                glas.setImageResource(R.drawable.glas2);
                break;
            case 1:
                glas.setImageResource(R.drawable.glas3);
                break;
            case 2:
                glas.setImageResource(R.drawable.glas4);
                break;
            case 3:
                glas.setImageResource(R.drawable.glas00);
                break;

        }
    }
}
