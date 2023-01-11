package com.ticketfield.ticket_field_configuration_sample;

import android.app.Application;

import com.zoho.desk.asap.api.ZohoDeskPortalSDK;


public class MyApplication extends Application {

    public static ZohoDeskPortalSDK zohoDeskPortalSDKInstnace;

    @Override
    public void onCreate() {
        super.onCreate();
        ZohoDeskPortalSDK.Logger.enableLogs();
        zohoDeskPortalSDKInstnace = ZohoDeskPortalSDK.getInstance(this);
        zohoDeskPortalSDKInstnace.initDesk(648638721 /*YOUR ORG ID*/,
                "edbsnc1c97d0c44b3cb69e65a076b2da45d92929a47446206ff34ea980712901451a3", ZohoDeskPortalSDK.DataCenter.US /*YOUR DATA CENTER*/);
        /*
         *  You would find the org Id, app Id and the Datacenter information from your Zoho Desk Portal -> ASAP -> Mobile section
         * */
    }
}
