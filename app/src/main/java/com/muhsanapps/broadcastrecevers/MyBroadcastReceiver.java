package com.muhsanapps.broadcastrecevers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        Toast.makeText(context, "My BR Called", Toast.LENGTH_SHORT).show();

       /* if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {

            boolean booleanExtra = intent.getBooleanExtra
                    (ConnectivityManager.CONNECTIVITY_ACTION, false);

            if (!booleanExtra) {
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Disconnect", Toast.LENGTH_SHORT).show();
            }
        } else if (Intent.ACTION_TIME_TICK.equals(intent.getAction())) {
            Toast.makeText(context, "Time incremented", Toast.LENGTH_SHORT).show();
        }*/


     /*   if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
            Toast.makeText(context, "Boot Completed", Toast.LENGTH_SHORT).show();
        }else if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            Toast.makeText(context, "Connectivity Status Changed", Toast.LENGTH_SHORT).show();
        }*/
    }
}
