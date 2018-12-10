package com.zoho.deskportalsdk.demo.basic.kotlin

import android.app.Application
import com.zoho.deskportalsdk.DeskConfig
import com.zoho.deskportalsdk.ZohoDeskPortalSDK

class MyApplication : Application() {

    companion object {
        lateinit var zohoDeskPortalSDKInstnace : ZohoDeskPortalSDK;
    }

    override fun onCreate() {
        super.onCreate()
        val config = DeskConfig.Builder().build()
        zohoDeskPortalSDKInstnace = ZohoDeskPortalSDK.getInstance(this)
        zohoDeskPortalSDKInstnace.initDesk(0 /*YOUR ORG ID*/,
                "YOUR APP ID", ZohoDeskPortalSDK.DataCenter.US /*YOUR DATA CENTER*/, config)

        /*
        *  You would find the org Id, app Id and the Datacenter information from your Zoho Desk Portal -> ASAP -> Mobile section
        * */
    }
}