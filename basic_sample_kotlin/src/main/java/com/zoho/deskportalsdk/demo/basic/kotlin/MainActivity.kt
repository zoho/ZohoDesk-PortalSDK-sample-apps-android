package com.zoho.deskportalsdk.demo.basic.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zoho.desk.asap.ZDPortalHome

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchSDK(view: View) {
        ZDPortalHome.show(this)
    }
}
