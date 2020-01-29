package com.mina.special.agappy;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent.getExtras().getString("sala").equals("baker")) {
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, new Intent(context, Elsawa3yText.class).putExtra("name", "baker"), PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "1");
            builder.setContentTitle("صلوات السواعي:").setContentText("صلاة باكر").setSmallIcon(R.drawable.noti_icon).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.baker))
                    .setContentIntent(pendingIntent).setAutoCancel(true).setDefaults(Notification.DEFAULT_SOUND);


            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
            notificationManagerCompat.notify(2, builder.build());
        } else if (intent.getExtras().getString("sala").equals("talta")) {

            PendingIntent pendingIntent2 = PendingIntent.getActivity(context, 2, new Intent(context, Elsawa3yText.class).putExtra("name", "talta"), PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder1 = new NotificationCompat.Builder(context, "2");
            builder1.setContentTitle("صلوات السواعي:").setContentText("صلاة الساعة الثالثة").setSmallIcon(R.drawable.noti_icon).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.talta))
                    .setContentIntent(pendingIntent2).setAutoCancel(true).setDefaults(Notification.DEFAULT_SOUND);

            NotificationManagerCompat notificationManagerCompat1 = NotificationManagerCompat.from(context);
            notificationManagerCompat1.notify(2, builder1.build());
        } else if (intent.getExtras().getString("sala").equals("sata")) {

            PendingIntent pendingIntent3 = PendingIntent.getActivity(context, 3, new Intent(context, Elsawa3yText.class).putExtra("name", "sata"), PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder2 = new NotificationCompat.Builder(context, "3");
            builder2.setContentTitle("صلوات السواعي:").setContentText("صلاة الساعة السادسة").setSmallIcon(R.drawable.noti_icon).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.sata))
                    .setContentIntent(pendingIntent3).setAutoCancel(true).setDefaults(Notification.DEFAULT_SOUND);

            NotificationManagerCompat notificationManagerCompat2 = NotificationManagerCompat.from(context);
            notificationManagerCompat2.notify(2, builder2.build());
        } else if (intent.getExtras().getString("sala").equals("tas3a")) {

            PendingIntent pendingIntent4 = PendingIntent.getActivity(context, 4, new Intent(context, Elsawa3yText.class).putExtra("name", "tas3a"), PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder3 = new NotificationCompat.Builder(context, "4");
            builder3.setContentTitle("صلوات السواعي:").setContentText("صلاة الساعة التاسعة").setSmallIcon(R.drawable.noti_icon).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.tas3a))
                    .setContentIntent(pendingIntent4).setAutoCancel(true).setDefaults(Notification.DEFAULT_SOUND);

            NotificationManagerCompat notificationManagerCompat3 = NotificationManagerCompat.from(context);
            notificationManagerCompat3.notify(2, builder3.build());
        } else if (intent.getExtras().getString("sala").equals("ghrob")) {

            PendingIntent pendingIntent5 = PendingIntent.getActivity(context, 5, new Intent(context, Elsawa3yText.class).putExtra("name", "ghrob"), PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder4 = new NotificationCompat.Builder(context, "5");
            builder4.setContentTitle("صلوات السواعي:").setContentText("صلاة الغروب").setSmallIcon(R.drawable.noti_icon).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ghrob))
                    .setContentIntent(pendingIntent5).setAutoCancel(true).setDefaults(Notification.DEFAULT_SOUND);

            NotificationManagerCompat notificationManagerCompat4 = NotificationManagerCompat.from(context);
            notificationManagerCompat4.notify(2, builder4.build());
        } else if (intent.getExtras().getString("sala").equals("nom")) {

            PendingIntent pendingIntent6 = PendingIntent.getActivity(context, 6, new Intent(context, Elsawa3yText.class).putExtra("name", "nom"), PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder5 = new NotificationCompat.Builder(context, "6");
            builder5.setContentTitle("صلوات السواعي:").setContentText("صلاة النوم").setSmallIcon(R.drawable.noti_icon).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.nom))
                    .setContentIntent(pendingIntent6).setAutoCancel(true).setDefaults(Notification.DEFAULT_SOUND);

            NotificationManagerCompat notificationManagerCompat5 = NotificationManagerCompat.from(context);
            notificationManagerCompat5.notify(2, builder5.build());
        }


    }
}
