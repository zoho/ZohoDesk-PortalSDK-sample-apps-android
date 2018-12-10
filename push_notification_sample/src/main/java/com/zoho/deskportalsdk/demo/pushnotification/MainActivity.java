package com.zoho.deskportalsdk.demo.pushnotification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.zoho.deskportalsdk.android.network.DeskCallback;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchSDK(View view) {
        MyApplication.zohoDeskPortalSDKInstnace.startDeskHomeScreen(MainActivity.this);
    }

    public void enablePush(View view) {
        MyApplication.zohoDeskPortalSDKInstnace.enablePush(FirebaseInstanceId.getInstance().getToken());
    }

    public void disablePush(View view) {
        MyApplication.zohoDeskPortalSDKInstnace.disablePush(FirebaseInstanceId.getInstance().getToken());
    }
}
