package com.zoho.deskportalsdk.demo.basic.kotlin

import android.app.Application
import com.zoho.desk.asap.api.ZohoDeskPortalSDK

class MyApplication : Application() {

    companion object {
        lateinit var zohoDeskPortalSDKInstnace : ZohoDeskPortalSDK;
    }

    override fun onCreate() {
        super.onCreate()
        ZohoDeskPortalSDK.Logger.enableLogs()
        zohoDeskPortalSDKInstnace = ZohoDeskPortalSDK.getInstance(this)
        zohoDeskPortalSDKInstnace.initDesk(0 /*YOUR ORG ID*/,
                "YOUR APP ID", ZohoDeskPortalSDK.DataCenter.US /*YOUR DATA CENTER*/)

        /*
        *  You would find the org Id, app Id and the Datacenter information from your Zoho Desk Portal -> ASAP -> Mobile section
        * */
    }
}