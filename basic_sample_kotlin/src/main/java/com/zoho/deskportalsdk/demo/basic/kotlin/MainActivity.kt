package com.zoho.deskportalsdk.demo.basic.kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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
