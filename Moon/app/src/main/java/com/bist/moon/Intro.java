package com.bist.moon;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Intro extends AppCompatActivity {

    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Intro.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },2000);
    }
}
