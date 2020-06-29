package com.zoho.deskportalsdk.demo.theme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zoho.desk.asap.ZDPortalHome;
import com.zoho.desk.asap.common.ZDPortalConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setLightTheme(View view) {
        ZDPortalConfiguration.setThemeResource(R.style.zohoDeskCustomTheme);
        ZDPortalHome.show(this);
    }

    public void setDarkTheme(View view) {
        ZDPortalConfiguration.setThemeResource(R.style.deskTheme_Dark);
        ZDPortalHome.show(this);
    }
}
