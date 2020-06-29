package com.zoho.deskportalsdk.demo.jwt;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zoho.desk.asap.ZDPortalHome;
import com.zoho.desk.asap.api.ZDPortalCallback;
import com.zoho.desk.asap.api.ZDPortalException;


public class MainActivity extends AppCompatActivity {

    private View progrssBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progrssBar = findViewById(R.id.progressbar);
    }

    public void setUserToken(View view) {
        EditText userTokenView = (EditText) findViewById(R.id.user_token);
        if(!MyApplication.zohoDeskPortalSDKInstnace.isUserSignedIn()) {
            progrssBar.setVisibility(View.VISIBLE);
            MyApplication.zohoDeskPortalSDKInstnace.setUserToken(userTokenView.getText().toString(), new ZDPortalCallback.SetUserCallback() {
                @Override
                public void onUserSetSuccess() {
                    Toast.makeText(getApplicationContext(), "User set success", Toast.LENGTH_SHORT).show();
                    progrssBar.setVisibility(View.GONE);
                    ZDPortalHome.show(MainActivity.this);
                }

                @Override
                public void onException(ZDPortalException e) {
                    Toast.makeText(getApplicationContext(), "User set failure", Toast.LENGTH_SHORT).show();
                    progrssBar.setVisibility(View.GONE);
                }
            });
        }
        else {
            Toast.makeText(this, "User Token already set.", Toast.LENGTH_SHORT).show();
        }
    }

    public void logoutFromSDK(View view) {
        MyApplication.zohoDeskPortalSDKInstnace.logout(new ZDPortalCallback.LogoutCallback() {
            @Override
            public void onLogoutSuccess() {
                //user removed from SDK.
            }

            @Override
            public void onException(ZDPortalException e) {

            }
        });
    }
}
