package com.zoho.deskportalsdk.demo.stats.events;

import android.app.Application;
import android.util.Log;

import com.zoho.desk.asap.api.ZohoDeskPortalSDK;
import com.zoho.desk.asap.common.ZDPortalConfiguration;
import com.zoho.desk.asap.common.utils.ZDPortalEventsCallback;
import com.zoho.desk.asap.common.utils.ZDeskEvents;


public class MyApplication extends Application {

    public static ZohoDeskPortalSDK zohoDeskPortalSDKInstnace;

    @Override
    public void onCreate() {
        super.onCreate();

        ZohoDeskPortalSDK.Logger.enableLogs();
        zohoDeskPortalSDKInstnace = ZohoDeskPortalSDK.getInstance(this);
        zohoDeskPortalSDKInstnace.initDesk(0 /*YOUR ORG ID*/,
                "YOUR APP ID", ZohoDeskPortalSDK.DataCenter.US /*YOUR DATA CENTER*/);

        /*
         *  You would find the org Id, app Id and the Datacenter information from your Zoho Desk Portal -> ASAP -> Mobile section
         * */


        ZDPortalConfiguration.setEventsCallback(zohoDeskEventsCallback);
    }

    private ZDPortalEventsCallback zohoDeskEventsCallback = new ZDPortalEventsCallback() {
        @Override
        public void onDeskEvent(ZDeskEvents.ScreenName screenName, ZDeskEvents.Event event, ZDeskEvents.SourceOfTheEvent sourceOfTheEvent, ZDeskEvents.ActionName actionName, String s, String s1) {
            if(actionName == ZDeskEvents.ActionName.KB_ARTICLE_CLICK) {
                Log.i("EVENT","An Article is clicked.");
                //An Article is clicked. You can Log or Push this to any of the Analytics tools.
            } else if(actionName == ZDeskEvents.ActionName.COMMUNITY_TOPIC_LIST_CLICK) {
                Log.i("EVENT","A Topic is clicked.");
                //A topic is clicked. You can Log or Push this to any of the Analytics tools.
            }
        }
    };
}
