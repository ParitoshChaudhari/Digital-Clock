package com.paritoshchaudhari.digiclock;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextClock;

public class MainActivity extends AppCompatActivity {


    TextClock textClock,textAmPm ,textDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        textClock = findViewById(R.id.textClockID);
        textAmPm = findViewById(R.id.textAmPmID);
        textDate = findViewById(R.id.textDateID);

        Typeface myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/digital_font.ttf");

        textClock.setTypeface(myFont);
        textDate.setTypeface(myFont);
        textAmPm.setTypeface(myFont);

    }
}