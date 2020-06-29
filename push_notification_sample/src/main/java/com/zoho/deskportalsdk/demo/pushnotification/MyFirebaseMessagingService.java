package com.zoho.deskportalsdk.demo.pushnotification;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.zoho.desk.asap.common.ZDPortalConfiguration;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        ZDPortalConfiguration.handleNotification(getApplicationContext(), remoteMessage.getData(), R.mipmap.ic_launcher);
    }

}
