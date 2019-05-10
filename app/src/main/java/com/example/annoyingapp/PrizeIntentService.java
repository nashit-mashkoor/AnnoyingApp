package com.example.annoyingapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class PrizeIntentService extends IntentService {

    public PrizeIntentService() {
        super("PrizeIntentService");
        Log.d("Nashit", "Working");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Thread.sleep(5000);
            Intent i = new Intent("Prize");
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            Log.d("Nashit", "Working");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }



    }
}
