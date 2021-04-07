package com.example.kliker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int couter = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView egg = findViewById(R.id.image);
        TextView counterview = findViewById(R.id.text);
        Button reset = findViewById(R.id.button);
        Button secondLvl = findViewById(R.id.buttonLvL);
        Button threLvL = findViewById(R.id.buttonLvLThre);
        counterview.setText(couter + "");
        egg.setImageResource(R.drawable.stadia1);

        egg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (couter == 0) {
                    return;
                }
                couter--;
                counterview.setText(couter + "");
                switch (couter) {
                    case 20:
                        egg.setImageResource(R.drawable.stadia2);
                        break;
                    case 10:
                        egg.setImageResource(R.drawable.stadia3);
                        break;
                    case 0:
                        egg.setImageResource(R.drawable.stadia4);
                        break;
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                couter = 25;
                egg.setImageResource(R.drawable.stadia1);
                counterview.setText(couter + "");
            }
        });

        secondLvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondLvlActivity.class));
            }
        });
        threLvL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThreeActivity.class));
            }
        });


    }
}
