package com.example.annoyingapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class DragonIntentService extends IntentService {

    public DragonIntentService() {
        super("DragonIntentService");
        Log.d("Nashit", "Working");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Thread.sleep(10000);
            Intent i = new Intent("Dragon");
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            Log.d("Nashit", "Working");
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }



    }
}
