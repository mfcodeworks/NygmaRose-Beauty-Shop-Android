package com.nygmarose.nygmarosebeautyshop;

import android.app.NotificationManager;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import static com.google.android.gms.internal.zzs.TAG;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        // Log Message Received
        Log.d(TAG, "onMessageReceived: " + remoteMessage.getData().toString());
        Log.d(TAG, "From " + remoteMessage.getFrom());
        Log.d(TAG, "Body " + remoteMessage.getNotification().getBody());
        // Build foreground notification
        NotificationCompat.Builder mBuilder = new  NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.ic_notification);
        if (remoteMessage.getNotification().getTitle().isEmpty()) mBuilder.setContentTitle("NygmaRose Beauty Shop");
        else mBuilder.setContentTitle(remoteMessage.getNotification().getTitle());
        mBuilder.setContentText(remoteMessage.getNotification().getBody());
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0, mBuilder.build());
    }
}
