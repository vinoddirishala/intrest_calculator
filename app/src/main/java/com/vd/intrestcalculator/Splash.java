package com.vd.intrestcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.vd.intrestcalculator.ui.activity.Dashboard;

import static com.vd.intrestcalculator.utils.Constants.SPLASH_TIMEOUT;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        runApp();
    }

    private void runApp(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this, Dashboard.class));
                onBackPressed();
            }
        },SPLASH_TIMEOUT);
    }

}