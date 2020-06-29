package com.zoho.deskportalsdk.demo.jwt;

import android.app.Application;

import com.zoho.desk.asap.api.ZohoDeskPortalSDK;

public class MyApplication extends Application {

    public static ZohoDeskPortalSDK zohoDeskPortalSDKInstnace;

    @Override
    public void onCreate() {
        super.onCreate();
        ZohoDeskPortalSDK.Logger.enableLogs();
        zohoDeskPortalSDKInstnace = ZohoDeskPortalSDK.getInstance(this);
        zohoDeskPortalSDKInstnace.initDesk(0 /*YOUR ORG ID*/,
                "YOUR APP ID", ZohoDeskPortalSDK.DataCenter.US /*YOUR DATA CENTER*/);

        /*
         *  You would find the org Id, app Id and the Datacenter information from your Zoho Desk Portal -> ASAP -> Mobile section
         * */
    }
}
