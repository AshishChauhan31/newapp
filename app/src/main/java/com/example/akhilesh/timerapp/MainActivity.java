package com.example.akhilesh.timerapp;


import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    public int counter;
    private MediaPlayer mediaPlayer;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        textView = findViewById (R.id.textView);
        button = findViewById (R.id.button);
        button2 = findViewById (R.id.button2);

//       mediaPlayer = MediaPlayer.create (this,R.raw.a);
        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                new CountDownTimer(1000,10) {
                    public void onTick(long millisUntilFinished) {

                        textView.setText (String.valueOf (counter));
                        counter++;
                        //Toast.makeText (MainActivity.this, "after time song starting", Toast.LENGTH_SHORT).show ();
                    }

                    public void onFinish() {
                        MediaPlayer mediaPlayer= MediaPlayer.create(MainActivity.this , R.raw.abc);
//                        mediaPlayer = MediaPlayer.create(null, R.raw.a);
                        try {
                            mediaPlayer.prepare();
                        } catch (IllegalStateException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                        textView.setText ("hi!");
                        mediaPlayer.start ();
                    }
                }.start ();
            }
            });

        button2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                //Toast.makeText (MainActivity.this, "after stop timer", Toast.LENGTH_SHORT).show ();
                mediaPlayer.stop ();
            }

        });
    }}