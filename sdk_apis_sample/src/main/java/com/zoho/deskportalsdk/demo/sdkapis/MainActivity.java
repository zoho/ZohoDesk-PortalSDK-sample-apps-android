package com.zoho.deskportalsdk.demo.sdkapis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zoho.desk.asap.api.ZDPortalCallback;
import com.zoho.desk.asap.api.ZDPortalCommunityAPI;
import com.zoho.desk.asap.api.ZDPortalException;
import com.zoho.desk.asap.api.response.CommunityCategoriesList;
import com.zoho.desk.asap.api.response.CommunityTopic;
import com.zoho.desk.asap.api.response.DeskTopicsList;
import com.zoho.desk.asap.asap_community.ZDPortalCommunity;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private String categoryId;
    private LinearLayout topicsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topicsLayout = (LinearLayout) findViewById(R.id.topics_layout);
        getCommunityCategories();
    }

    private void getCommunityCategories() {
        ZDPortalCommunityAPI.getCommunityCategories(new ZDPortalCallback.CommunityCategoriesCallback() {
            @Override
            public void onCommunityCategoriesDownloaded(CommunityCategoriesList communityCategoriesList) {
                if(communityCategoriesList != null && communityCategoriesList.getData() != null && communityCategoriesList.getData().size() > 0) {
                    categoryId = communityCategoriesList.getData().get(0).getId();
                }
            }

            @Override
            public void onException(ZDPortalException e) {
                Log.i("APITEST", e.getErrorMsg());
            }
        }, null);
    }


    public void getMostPopularTopics(View view) {

        HashMap<String, String> params = new HashMap<>();
        params.put("categoryId", categoryId);//categoryId is the id of a Category for which the topics needs to be fetched. If the categoryId is -1, then it will be considered as org level
        params.put("from", "1");
        params.put("limit", "20");
        ZDPortalCommunityAPI.getMostPopularTopics(new ZDPortalCallback.CommunityTopicsCallback() {
            @Override
            public void onCommunityTopicsDownloaded(DeskTopicsList deskTopicsList) {
                if(deskTopicsList != null && deskTopicsList.getData() != null && deskTopicsList.getData().size() > 0) {
                    renderTopics(deskTopicsList.getData());
                }
            }

            @Override
            public void onException(ZDPortalException e) {

            }
        }, params);

    }

    public void getMostDiscussedTopics(View view) {

        HashMap<String, String> params = new HashMap<>();
        params.put("categoryId", categoryId);//categoryId is the id of a Category for which the topics needs to be fetched. If the categoryId is -1, then it will be considered as org level
        params.put("from", "1");
        params.put("limit", "20");
        ZDPortalCommunityAPI.getMostDiscussedTopics(new ZDPortalCallback.CommunityTopicsCallback() {
            @Override
            public void onCommunityTopicsDownloaded(DeskTopicsList deskTopicsList) {
                if(deskTopicsList != null && deskTopicsList.getData() != null && deskTopicsList.getData().size() > 0) {
                    renderTopics(deskTopicsList.getData());
                }
            }

            @Override
            public void onException(ZDPortalException e) {

            }
        }, params);
    }

    private void renderTopics(ArrayList<CommunityTopic> forumResponses) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT );
        params.setMargins(20, 20, 20, 20);
        topicsLayout.removeAllViews();
        for(CommunityTopic forumResponse:forumResponses) {
            TextView textView = new TextView(this);
            textView.setLayoutParams(params);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setText(forumResponse.getSubject());
            textView.setTag(forumResponse.getId());
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ZDPortalCommunity.showTopicWithId(MainActivity.this, v.getTag().toString());
                }
            });
            topicsLayout.addView(textView);
        }
    }
}
