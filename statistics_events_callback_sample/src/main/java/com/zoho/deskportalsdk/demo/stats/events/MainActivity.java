package com.zoho.deskportalsdk.demo.stats.events;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zoho.desk.asap.ZDPortalHome;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchSDK(View view) {
        ZDPortalHome.show(this);
    }
}
