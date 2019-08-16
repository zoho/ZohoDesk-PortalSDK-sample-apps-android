package com.zoho.deskportalsdk.demo.update_profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.zoho.deskportalsdk.android.network.DeskCallback;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!MyApplicaiton.zohoDeskPortalSDKInstnace.isUserSignedIn()) {
            MyApplicaiton.zohoDeskPortalSDKInstnace.setUserToken(userToken, new DeskCallback.DeskSetUserCallback() {
                @Override
                public void onUserSetSuccess() {

                }

                @Override
                public void onException(DeskException e) {

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
        * 1. emailAddress
        * 2. twitter
        * 3. phone
        * 4. facebook
        * 5. name
        * 6. displayName
        * 7. mobile
        * 8. countryLocale
        * 9. timeZone
        *
        * */


        HashMap<String, String> profileData = new HashMap<>();
        profileData.put("displayName", "displayName");
        profileData.put("mobile", "123456");
        MyApplicaiton.zohoDeskPortalSDKInstnace.updateProfile(profileData, new DeskCallback.DeskUpdateProfileCallback() {
            @Override
            public void onProfileUpdated(JSONObject jsonObject) {
                Log.i("UpdateProfile", "Success");
            }

            @Override
            public void onException(final DeskCallback.DeskException exception) {
                Log.i("UpdateProfile", "Exception");
            }
        });
    }
}
