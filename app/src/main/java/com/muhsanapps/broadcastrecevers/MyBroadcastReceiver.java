package com.muhsanapps.broadcastrecevers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        int initialCode = getResultCode();
        String initialData = getResultData();
        Bundle bundle = getResultExtras(true);
        String stringExtra = bundle.getString("message_key");

        initialCode++;
        stringExtra += "->BR: Sender ";

        String output = "initial Code: " + initialCode + "\n" +
                "initial Data: " + initialData + "\n" +
                "string extra: " + stringExtra;

        Toast.makeText(context, output, Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onReceiver: "+ output);

        initialData = "BR: Sender";
        bundle.putString("message_key", stringExtra);

        setResult(initialCode, initialData, bundle);


        // Toast.makeText(context, "My BR Called: Sender app  ", Toast.LENGTH_SHORT).show();

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
