package com.example.kliker;

import android.app.AppComponentFactory;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThreeActivity extends AppCompatActivity {
    private int couter = 1000;
    private int switchVariable = 0;
    private SharedPreferences sp;
    private final static String KEY_COUNTER = "counter";

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
        Button accept = findViewById(R.id.button_accept);
        EditText textAccept = findViewById(R.id.editText);
        counterview.setText(couter + "");
        sp = getPreferences(MODE_PRIVATE);
        couter = sp.getInt(KEY_COUNTER,1000);
        counterview.setText(couter + "");
        updateImage(glas);


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
                if (couter < 0) {
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
                if (couter < 0) {
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

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempString = textAccept.getText().toString();

                if (tempString.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Уважаемый, ну хоть что то чиркани!", Toast.LENGTH_SHORT);
                    toast.show();
                    textAccept.setText("");
                    return;

                }
                int length = tempString.length();
                if (length > 9) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Уважаемая, поменьше циферок пиши!", Toast.LENGTH_SHORT);
                    toast.show();
                    textAccept.setText("");
                    return;
                }
                // Есть ли точка в строке.
                /*if (tempString.contains(".")) {
                    return;
                }*/


                int temp = Integer.valueOf(tempString);


                if (temp > 1000) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Старина, введи чило меньше 1000!", Toast.LENGTH_SHORT);
                    toast.show();
                    textAccept.setText("");
                    return;
                }
                if (temp < 1) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Малютка, введи число больше нуля!", Toast.LENGTH_SHORT);
                    toast.show();
                    textAccept.setText("");
                    return;
                }
                couter = temp;
                counterview.setText(String.valueOf(couter));
                updateImage(glas);
                textAccept.setText("");
            }


        });
    }

    protected void updateImage(ImageView glas) {
        if (couter > 0 && couter <= 350) switchVariable = 0;
        else if (couter > 350 && couter <= 620) switchVariable = 1;
        else if (couter > 620 && couter <= 999) switchVariable = 2;
        else if (couter == 1000) switchVariable = 3;
        else if (couter == 0) switchVariable = 4;
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
            case 4:
                glas.setImageResource(R.drawable.glasfinal);
                break;

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sp.edit().putInt(KEY_COUNTER,couter).apply();
    }
}

