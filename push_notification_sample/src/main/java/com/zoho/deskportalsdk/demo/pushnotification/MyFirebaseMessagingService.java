package com.zoho.deskportalsdk.demo.pushnotification;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        MyApplication.zohoDeskPortalSDKInstnace.handleNotification(getApplicationContext(), remoteMessage.getData(), R.mipmap.ic_launcher);
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
    }
}
