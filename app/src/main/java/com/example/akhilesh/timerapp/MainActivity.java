package com.example.akhilesh.timerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    Timer timer;
   // int time = 100000;
    //private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        textView = findViewById (R.id.textView);
        button = findViewById (R.id.button);
        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                new timer (100000) {
                    public void onTick(long millisUntilFinished) {
                        int counter=0;
                        textView.setText (String.valueOf (counter));
                        counter++;
                    }

                    public void onFinish() {
                        textView.setText ("finish!!!!!");
                    }
                };

            }
        });
    }}