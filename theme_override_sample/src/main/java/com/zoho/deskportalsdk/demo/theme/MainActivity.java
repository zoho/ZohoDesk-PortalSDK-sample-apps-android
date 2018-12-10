package com.zoho.deskportalsdk.demo.theme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setLightTheme(View view) {
        MyApplication.zohoDeskPortalSDKInstnace.setThemeResource(R.style.zohoDeskCustomTheme);
        MyApplication.zohoDeskPortalSDKInstnace.startDeskHomeScreen(this);
    }

    public void setDarkTheme(View view) {
        MyApplication.zohoDeskPortalSDKInstnace.setThemeResource(R.style.deskTheme_Dark);
        MyApplication.zohoDeskPortalSDKInstnace.startDeskHomeScreen(this);
    }
}
