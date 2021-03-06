package com.zoho.deskportalsdk.demo.update_profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;


import com.zoho.desk.asap.api.ZDPortalAPI;
import com.zoho.desk.asap.api.ZDPortalCallback;
import com.zoho.desk.asap.api.ZDPortalException;
import com.zoho.desk.asap.api.response.DeskUserProfile;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!MyApplicaiton.zohoDeskPortalSDKInstnace.isUserSignedIn()) {
            MyApplicaiton.zohoDeskPortalSDKInstnace.setUserToken("userToken", new ZDPortalCallback.SetUserCallback() {
                @Override
                public void onUserSetSuccess() {
                }

                @Override
                public void onException(ZDPortalException e) {

                }
            });
        }
    }

    public void updateProfile(View view) {

        /*
        *  Before updating a profile, the end-user should have authenticated.
        *
        *  For Updating a profile, Hash map of key, value pair needs to be sent.
        *
        * The possible Keys are,
        * 1. twitter
        * 2. phone
        * 3. facebook
        * 4. name
        * 5. displayName
        * 6. mobile
        * 7. countryLocale
        * 8. timeZone
        *
        * */


        HashMap<String, String> profileData = new HashMap<>();
        profileData.put("displayName", "displayName");
        profileData.put("mobile", "123456");

        ZDPortalAPI.updateProfileDetails(new ZDPortalCallback.UserDetailsCallback() {
            @Override
            public void onUserDetailsSuccess(DeskUserProfile deskUserProfile) {
                Log.i("UpdateProfile", "Success");
            }

            @Override
            public void onException(ZDPortalException e) {
                Log.i("UpdateProfile", "Exception");
            }
        }, profileData);
    }
}
