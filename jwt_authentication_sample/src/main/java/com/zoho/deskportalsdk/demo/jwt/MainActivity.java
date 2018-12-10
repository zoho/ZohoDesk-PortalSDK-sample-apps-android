package com.zoho.deskportalsdk.demo.jwt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zoho.deskportalsdk.android.network.DeskCallback;

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
        progrssBar.setVisibility(View.VISIBLE);
        MyApplication.zohoDeskPortalSDKInstnace.setUserToken(userTokenView.getText().toString(), new DeskCallback.DeskSetUserCallback() {
            @Override
            public void onUserSetSuccess() {
                Toast.makeText(getApplicationContext(), "User set success", Toast.LENGTH_SHORT).show();
                progrssBar.setVisibility(View.GONE);
                MyApplication.zohoDeskPortalSDKInstnace.startDeskHomeScreen(MainActivity.this);
            }

            @Override
            public void onException(DeskException e) {
                Toast.makeText(getApplicationContext(), "User set failure", Toast.LENGTH_SHORT).show();
                progrssBar.setVisibility(View.GONE);
            }
        });

    }

    public void logoutFromSDK(View view) {
        MyApplication.zohoDeskPortalSDKInstnace.removeUser(new DeskCallback.DeskRemoveUserCallback() {
            @Override
            public void onUserRemoveSuccess() {
                //user removed from SDK.
            }

            @Override
            public void onException(DeskException exception) {
            }
        });
    }
}
