package com.zoho.deskportalsdk.demo.theme;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zoho.desk.asap.ZDPortalHome;
import com.zoho.desk.asap.common.ZDPortalConfiguration;
import com.zoho.desk.asap.common.utils.ZDPTheme;
import com.zoho.desk.asap.common.utils.ZDPThemeType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setLightTheme(View view) {
        ZDPortalConfiguration.setThemeType(ZDPThemeType.LIGHT);
        ZDPortalConfiguration.setThemeBuilder(new ZDPTheme.Builder(false)
                .setColorPrimary(getResources().getColor(R.color.colorPrimary))
                .setColorPrimaryDark(getResources().getColor(R.color.colorPrimaryDark))
                .build());
        ZDPortalHome.show(this);
    }

    public void setDarkTheme(View view) {
        ZDPortalConfiguration.setThemeType(ZDPThemeType.DARK);
        ZDPortalHome.show(this);
    }
}
