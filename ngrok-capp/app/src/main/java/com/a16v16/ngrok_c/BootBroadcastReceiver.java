package com.a16v16.ngrok_c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

public class BootBroadcastReceiver extends BroadcastReceiver {
    static final String action_boot="android.intent.action.BOOT_COMPLETED";
 
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(action_boot)){
            Log.i("tag","autostart....");
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE); //私有数据
            boolean autostart=sharedPreferences.getBoolean(MainActivity.AUTOSTART,false);
            if(autostart) {
                Intent intent1 = new Intent(context, MainActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //为intent添加额外的信息
                intent1.putExtra("autostart",true);
                //启动Activity
                context.startActivity(intent1);
            }
           // Toast.makeText(context,"ngrokc已自动启动。。。cmdstr:"+cmdstr+"exec_path:"+exec_path, Toast.LENGTH_LONG).show();
        }
 
    }




}