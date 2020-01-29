package com.mina.special.agappy;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import java.util.Random;

/**
 * Created by dell on 2/12/2019.
 */

public class AlertReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
       String[] arr = context.getResources().getStringArray(R.array.ayat);
        Random rnd = new Random();
       int i = rnd.nextInt(arr.length);
        String txt = arr[i];
        Intent readaya = new Intent(context, DailyAyaActivity.class).putExtra("aya", txt);
        PendingIntent pendingIntent1 = PendingIntent.getActivity(context, 0, readaya, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "1");
        builder.setContentTitle("اية كل يوم:").setContentText(txt).setSmallIcon(R.drawable.noti_icon).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.app_icon))
                .setPriority(NotificationManager.IMPORTANCE_DEFAULT).setContentIntent(pendingIntent1).setDefaults(Notification.DEFAULT_SOUND).setAutoCancel(true);


        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(1, builder.build());



    }

}
