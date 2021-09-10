package com.paritoshchaudhari.digiclock;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatch extends AppCompatActivity {

    Button startBtn , stopBtn , resetBtn;
    ImageView arrowClock;
    Animation roundAngAlone;
    Chronometer timerChronometer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);


        //Prevent screen off and remove (wifi,signal strength)bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        //finding views by id
        startBtn = findViewById(R.id.startBtnID);
        stopBtn = findViewById(R.id.stopBtnID);
        resetBtn = findViewById(R.id.resetBtnID);
        arrowClock = findViewById(R.id.bgArrowClockId);
        timerChronometer = findViewById(R.id.timerID);



        //font location in explorer
        Typeface myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/digital_font.ttf");


        //setting font for button
        startBtn.setTypeface(myFont);
        stopBtn.setTypeface(myFont);
        resetBtn.setTypeface(myFont);

        //setting font for timer display
        timerChronometer.setTypeface(myFont);

        //create optional animation
        stopBtn.setAlpha(0);

        //load animation
        roundAngAlone = AnimationUtils.loadAnimation(this,R.anim.roundangalone);



        //button function
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing animation
                arrowClock.startAnimation(roundAngAlone);

                //hiding animation
                stopBtn.animate().alpha(1).translationY(-20).setDuration(300).start();
                startBtn.animate().alpha(0).setDuration(300).start(); //button visibility GONE
                resetBtn.animate().alpha(0).setDuration(300).start(); //button visibility enable

                //start timer
                timerChronometer.setBase(SystemClock.elapsedRealtime());
                timerChronometer.start();
            }
        });




        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stop timer
                timerChronometer.stop();

                //Stop animation
                arrowClock.clearAnimation();

                //hiding button animation
                startBtn.animate().alpha(1).translationY(-20).setDuration(300).start(); //button visibility enable
                resetBtn.animate().alpha(1).translationY(-20).setDuration(300).start(); //button visibility enable
                stopBtn.animate().alpha(0).setDuration(300).start(); //button visibility GONE

            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset timer
                timerChronometer.setBase(SystemClock.elapsedRealtime());

                //stop timer animation after click on reset button
                arrowClock.clearAnimation();

                //Stopping timer after clicking on reset button
                timerChronometer.stop();
            }
        });
    }
}