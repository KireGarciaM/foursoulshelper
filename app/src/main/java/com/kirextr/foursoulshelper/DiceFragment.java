package com.kirextr.foursoulshelper;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiceFragment extends Fragment {
    /*int delay_time = 20;
    int roll_animations = 40;
    int[] dice_images = new int[]{R.drawable.d1, R.drawable.d2, R.drawable.d3,
            R.drawable.d4, R.drawable.d5, R.drawable.d6};
    Random random = new Random();
    TextView tv_help;
    ImageView die1;
    ImageView die2;
    LinearLayout dice_container;
    MediaPlayer mp;*/

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiceFragment newInstance(String param1, String param2) {
        DiceFragment fragment = new DiceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getActivity(), dice_activity.class);
        startActivity(intent);
        //setContentView(R.layout.fragment_dice);
        //tv_help = findViewById(R.id.tvHelp);
        //dice_container = findViewById(R.id.diceContainer);
        //die1 = findViewById(R.id.die1);
        //die2 = findViewById(R.id.die2);
        //mp = MediaPlayer.create(this,R.raw.roll);
        /*dice_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    rollDice();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
*/
    }

    /*private void rollDice() {
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
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dice, container, false);
    }
}