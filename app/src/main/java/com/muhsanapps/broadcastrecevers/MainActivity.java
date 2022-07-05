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
import android.os.PatternMatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
    Button btnBroadCastReceiver;
    TextView textView;

    /*private int counter =1;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBroadCastReceiver = findViewById(R.id.button);
        textView = findViewById(R.id.tv);


      /*  IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(myBroadcastReceiver, intentFilter);*/


        btnBroadCastReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*  Intent intent = new Intent("com.muhsanapps.receiverapp.ACTION_SEND");
                intent.putExtra("com.muhsanapps.EXTRA_DATA", "Hello from Sender App");

                sendBroadcast(intent);*/

//                Intent intent = new Intent();
               // intent1.setClass(MainActivity.this, MyBroadcastReceiver.class);

//                ComponentName componentName = new
//                        ComponentName("com.muhsanapps.broadcastrecevers",
//                        "com.muhsanapps.receiverapp.MyDemoReciver");
//                intent.setComponent(componentName);

               // Intent intent = new Intent(MainActivity.this, MyBroadcastReceiver.class);


//                sendBroadcast(intent);

                Intent intent = new Intent("com.muhsanapps.receiverapp.ACTION_SEND");

                PackageManager packageManager = getPackageManager();

                List<ResolveInfo> resolveInfos = packageManager.queryBroadcastReceivers(intent,0);

                for (ResolveInfo info: resolveInfos){

                    ComponentName componentName = new
                            ComponentName(info.activityInfo.packageName,info.activityInfo.name);

                    intent.setComponent(componentName);

                    sendBroadcast(intent);
                }



            }
        });
    }

  /*  @Override
    protected void onStart() {
        super.onStart();
        IntentFilter  intentFilter = new IntentFilter("com.muhsanapps.receiverapp.ACTION_SEND");
        registerReceiver(mInnerReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mInnerReceiver);
    }
*/
    /*    @Override
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