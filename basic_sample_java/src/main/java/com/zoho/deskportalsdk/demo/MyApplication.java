package com.zoho.deskportalsdk.demo;

import android.app.Application;

import com.zoho.deskportalsdk.DeskConfig;
import com.zoho.deskportalsdk.ZohoDeskPortalSDK;

public class MyApplication extends Application {

    public static ZohoDeskPortalSDK zohoDeskPortalSDKInstnace;

    @Override
    public void onCreate() {
        super.onCreate();
        DeskConfig config = new DeskConfig.Builder().build();
        zohoDeskPortalSDKInstnace = ZohoDeskPortalSDK.getInstance(this);
        zohoDeskPortalSDKInstnace.initDesk(0 /*YOUR ORG ID*/,
                "YOUR APP ID", ZohoDeskPortalSDK.DataCenter.US /*YOUR DATA CENTER*/, config);

        /*
        *  You would find the org Id, app Id and the Datacenter information from your Zoho Desk Portal -> ASAP -> Mobile section
        * */
    }
}
