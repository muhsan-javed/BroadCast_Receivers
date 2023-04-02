package com.muhsanapps.broadcastrecevers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   /* // Dynamic Broadcast Receiver
    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();*/
    Button btnBroadCastReceiver;
    TextView textView;

    /*// Custom Broadcast Receiver
    private int counter =1;
    private BroadcastReceiver mInnerReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("com.muhsanapps.receiverapp.ACTION_SEND".equals(intent.getAction())){
                String intentExtra = intent.getStringExtra("com.muhsanapps.EXTRA_DATA");

                textView.setText("Inner Broadcast received: "+ intentExtra+counter);
                counter++;
            }
        }
    };*/


    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String data = intent.getStringExtra("key");
            textView.setText(data);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBroadCastReceiver = findViewById(R.id.button);
        textView = findViewById(R.id.tv);

       /* //Dynamic Broadcast Receiver
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(myBroadcastReceiver, intentFilter);*/

        btnBroadCastReceiver.setOnClickListener(view -> {

            /*
            // Custom Broadcast Receiver
            Intent intent = new Intent("com.muhsanapps.receiverapp.ACTION_SEND");
            intent.putExtra("com.muhsanapps.EXTRA_DATA", "Hello from Sender App");

            sendBroadcast(intent);*/

            /*
            // Calling Implicit Broadcast as Explicit Broadcast in Android Oreo- class 6
            Intent intent = new Intent("com.muhsanapps.receiverapp.ACTION_SEND");

            PackageManager packageManager = getPackageManager();

            List<ResolveInfo> resolveInfos = packageManager.queryBroadcastReceivers(intent,0);

            for (ResolveInfo info: resolveInfos){
                ComponentName componentName = new ComponentName(info.activityInfo.packageName,info.activityInfo.name);
                intent.setComponent(componentName);
                sendBroadcast(intent);
            }*/

             /*
             // Explicit Broadcast-Send Broadcast from One App to Other
            Intent intent = new Intent();
            // intent.setClass(MainActivity.this, MyBroadcastReceiver.class);
            // ComponentName componentName = new ComponentName(MainActivity.this, MyBroadcastReceiver.class);
            ComponentName componentName = new ComponentName("com.muhsanapps.broadcastrecevers",
                    "com.muhsanapps.receiverapp.MyDemoReciver");
            intent.setComponent(componentName);

             //Intent intent = new Intent(MainActivity.this, MyBroadcastReceiver.class);
            sendBroadcast(intent);*/

            /*//Ordered Broadcast Receiver -Send One Broadcast to Multiple Receivers class 7
            Intent intent = new Intent("com.muhsanapps.receiverapp.ACTION_SEND");
            intent.setPackage("com.muhsanapps.receiverapp");

            Bundle bundle = new Bundle();
            bundle.putString("message_key", "Start");
            sendOrderedBroadcast(intent,null,
                    new MyBroadcastReceiver(),null, RESULT_CANCELED, "Start", bundle);
            sendOrderedBroadcast(intent, null);
            //sendBroadcast(intent);*/

            // Using Local Broadcast Receiver -Send Broadcast with in Application class 8
            Intent serviceIntent = new Intent(MainActivity.this, MyIntentService.class);
            serviceIntent.putExtra("key", "initial value");
            startService(serviceIntent);

        });
    }

    //Using Local Broadcast Receiver -Send Broadcast with in Application
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter =new IntentFilter(MyIntentService.MY_SERVICE_INTENT);
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(mReceiver, intentFilter);
    }
    // Using Local Broadcast Receiver -Send Broadcast with in Application
    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(mReceiver);
    }

   /* // Custom Broadcast Receiver
      @Override
    protected void onStart() {
        super.onStart();
        IntentFilter  intentFilter = new IntentFilter("com.muhsanapps.receiverapp.ACTION_SEND");
        registerReceiver(mInnerReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mInnerReceiver);
    }*/

   /* //Dynamic Broadcast Receiver
        @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);
    }*/

  /*  public static class  MyInnerReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }*/
}