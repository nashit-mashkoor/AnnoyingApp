package com.example.annoyingapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize);

        final MediaPlayer mp =  MediaPlayer.create(this,R.raw.chime);
        mp.setLooping(true);
        mp.start();

        ((Button)findViewById(R.id.prizeDismissBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                Intent i = new Intent(PrizeActivity.this, DragonIntentService.class);

                startService(i);
                finish();
            }
        });
    }
}
