package com.nygmarose.nygmarosebeautyshop;

import android.app.Notification;
import android.app.NotificationManager;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import static android.content.ContentValues.TAG;

@SuppressWarnings("ConstantConditions")
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        // Log Message Received
        Log.d(TAG, "onMessageReceived: " + remoteMessage.getData().toString());
        Log.d(TAG, "From " + remoteMessage.getFrom());
        Log.d(TAG, "Body " + remoteMessage.getNotification().getBody());

        // Build foreground notification
        Notification.Builder mBuilder = new Notification.Builder(this);
        mBuilder.setSmallIcon(R.drawable.ic_notification);
        if (remoteMessage.getNotification().getTitle().isEmpty()) mBuilder.setContentTitle("@string/app_name");
        else mBuilder.setContentTitle(remoteMessage.getNotification().getTitle());
        mBuilder.setContentText(remoteMessage.getNotification().getBody());
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0, mBuilder.build());
    }
}
