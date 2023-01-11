package com.zoho.deskportalsdk.demo.pushnotification;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.iid.FirebaseInstanceId;
import com.zoho.desk.asap.ZDPortalHome;
import com.zoho.desk.asap.api.ZDPortalCallback;
import com.zoho.desk.asap.api.ZDPortalException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchSDK(View view) {

        if(!MyApplication.zohoDeskPortalSDKInstnace.isUserSignedIn()) {
            MyApplication.zohoDeskPortalSDKInstnace.setUserToken("vigneshthillaichithambaram@gmail.com", new ZDPortalCallback.SetUserCallback() {
                @Override
                public void onUserSetSuccess() {
                }

                @Override
                public void onException(ZDPortalException e) {
                }
            });
        }

        ZDPortalHome.show(this);
    }

    public void enablePush(View view) {
        MyApplication.zohoDeskPortalSDKInstnace.enablePush(FirebaseInstanceId.getInstance().getToken());
    }

    public void disablePush(View view) {
        MyApplication.zohoDeskPortalSDKInstnace.disablePush(FirebaseInstanceId.getInstance().getToken());
    }
}
