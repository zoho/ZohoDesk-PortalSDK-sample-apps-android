package com.zoho.deskportalsdk.demo.basic.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchSDK(view: View) {
        MyApplication.zohoDeskPortalSDKInstnace.startDeskHomeScreen(this)
    }
}
