package com.muhsanapps.broadcastrecevers;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyIntentService extends IntentService {
    public static final String MY_SERVICE_INTENT = "MyServiceIntent";
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent resultIntent = new Intent(MY_SERVICE_INTENT);
        resultIntent.putExtra("key", "Download has been completed");

        LocalBroadcastManager.getInstance(getApplicationContext())
                .sendBroadcast(resultIntent);

    }

}