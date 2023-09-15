package com.kirextr.foursoulshelper;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class dice_activity extends AppCompatActivity {

    int delay_time = 20;
    int roll_animations = 40;
    int[] dice_images = new int[]{R.drawable.d1, R.drawable.d2, R.drawable.d3,
            R.drawable.d4, R.drawable.d5, R.drawable.d6};
    Random random = new Random();
    TextView tv_help;
    ImageView die1;
    ImageView die2;
    LinearLayout dice_container;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dice);
        tv_help = findViewById(R.id.tvHelp);
        dice_container = findViewById(R.id.diceContainer);
        die1 = findViewById(R.id.die1);
        die2 = findViewById(R.id.die2);
        mp = MediaPlayer.create(this,R.raw.roll);
        dice_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    rollDice();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    private void rollDice() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < roll_animations; i++){
                    int dice1 = random.nextInt(6)+1;
                    int dice2 = random.nextInt(6)+1;


                    die1.setImageResource(dice_images[dice1 - 1]);
                    die2.setImageResource(dice_images[dice2 - 1]);
                    try{
                        Thread.sleep(delay_time);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        if(mp != null){
            mp.start();
        }
    }
}