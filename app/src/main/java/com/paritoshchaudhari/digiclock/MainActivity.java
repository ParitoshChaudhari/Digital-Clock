package com.paritoshchaudhari.digiclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextClock;

public class MainActivity extends AppCompatActivity {

    public Button stopWatch,pomodoroTimer;

    TextClock textClock,textAmPm ,textDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Prevent screen off and remove (wifi,signal strength)bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        textClock = findViewById(R.id.textClockID);
        textAmPm = findViewById(R.id.textAmPmID);
        textDate = findViewById(R.id.textDateID);

        //button for Switching screen
        stopWatch = findViewById(R.id.StopWatchId);
        pomodoroTimer = findViewById(R.id.PomodoroTimerId);

        //font location in explorer
        Typeface myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/digital_font.ttf");

        //setting font for Clock (Timer)
        textClock.setTypeface(myFont);
        textDate.setTypeface(myFont);
        textAmPm.setTypeface(myFont);

        //setting font for button
        stopWatch.setTypeface(myFont);
        pomodoroTimer.setTypeface(myFont);


        //setting on click listener for Stop watch screen (For screen "Activity" switching )
        stopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStopWatchAct();
            }
        });


        //setting on click listener for pomodoroTimer screen (For screen "Activity" switching )
        pomodoroTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPomodoroTimerAct();
            }
        });

    }

    //function for opening stopwatch activity
    public void openStopWatchAct(){
        Intent stopWatchAct = new Intent(this , StopWatch.class);
        stopWatchAct.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION); //extra added
        startActivity(stopWatchAct);
    }

    //function for opening Pomodoro Timer Activity
    public void openPomodoroTimerAct(){
        Intent pomodoroTimerAct = new Intent(this,PomodoroTimer.class);
    }
}