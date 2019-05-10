package com.example.annoyingapp;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DragonActivity extends AppCompatActivity {

    private String CHANNEL_ID = "Messages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragon);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.roar);
        mp.setLooping(true);
        mp.start();

        ((Button) findViewById(R.id.DragonDismissBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();




                createNotificationChannel();

                Intent intent = new Intent(DragonActivity.this, PrizeIntentService.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                PendingIntent pendingIntent = PendingIntent.getService(DragonActivity.this, 0, intent, 0);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(DragonActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.success)
                        .setContentTitle("CONGRATULATIONS !!!!!")
                        .setContentText("You have recieved 10,0000 from 03229708008")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        // Set the intent that will fire when the user taps the notification
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(DragonActivity.this);

                    // notificationId is a unique int for each notification that you must define
                notificationManager.notify(1, builder.build());


               finish();
            }
        });

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Messages";
            String description = "Past messages";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
