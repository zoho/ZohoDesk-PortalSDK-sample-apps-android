package com.zoho.deskportalsdk.demo.stats.events;

import android.app.Application;
import android.util.Log;
import com.zoho.desk.asap.api.ZohoDeskPortalSDK;
import com.zoho.desk.asap.common.ZDPortalConfiguration;
import com.zoho.desk.asap.common.utils.ZDPEvents;
import com.zoho.desk.asap.common.utils.ZDPEventsCallback;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;


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

    private ZDPEventsCallback zohoDeskEventsCallback = new ZDPEventsCallback() {
        @Override
        public void onEvent(@NotNull String eventName, @NotNull HashMap<String, String> eventData) {
            //The screen where the event occurred (e.g., Home, Articles_List)
            String eventsScreen = eventData.getOrDefault(ZDPEvents.EventScreen, null);
            //The UI element related to the event (e.g., Recent_Articles)
            String eventsSource = eventData.getOrDefault(ZDPEvents.EventSource, null);
            //Extra data about the event, like the permalink of a clicked article or a selected filter
            String eventsData = eventData.getOrDefault(ZDPEvents.EventData, null);
            if(eventName.equals(ZDPEvents.EventName.KB_ARTICLE_CLICK.getValue())) {
                Log.i("EVENT","An Article is clicked.");
                //An Article is clicked. You can Log or Push this to any of the Analytics tools.
            } else if(eventName.equals(ZDPEvents.EventName.KB_ARTICLE_LIKE.getValue())) {
                Log.i("EVENT","An Article is liked.");
                //A topic is clicked. You can Log or Push this to any of the Analytics tools.
            }
        }
    };
}
