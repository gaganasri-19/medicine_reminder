package com.example.medigo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
         Uri alarmSound= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
         long[] pattern={100,300,300,300};
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"notifyLemubit")
                .setSmallIcon(R.drawable.pill)
                .setContentTitle("MediGo")
                .setContentText("Reminder to take your Medicine")
                .setSound(alarmSound)
                .setVibrate(pattern)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager=NotificationManagerCompat.from(context);

        notificationManager.notify(200,builder.build());

    }
}
