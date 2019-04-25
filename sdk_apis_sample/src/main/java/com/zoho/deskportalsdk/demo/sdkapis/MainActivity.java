package com.zoho.deskportalsdk.demo.sdkapis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zoho.deskportalsdk.android.network.DeskCallback;
import com.zoho.deskportalsdk.android.network.DeskForumResponse;
import com.zoho.deskportalsdk.android.network.DeskTopicsList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private long categoryId = -1;
    private LinearLayout topicsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topicsLayout = (LinearLayout) findViewById(R.id.topics_layout);
    }


    public void getMostPopularTopics(View view) {
        MyApplication.zohoDeskPortalSDKInstnace.getMostPopularTopics(new DeskCallback.DeskCommunityTopicsListCallback() {
            @Override
            public void onTopicsListCompleted(DeskTopicsList response) {
                if(response != null && response.getData() != null && response.getData().size() > 0) {
                    renderTopics(response.getData());
                }
            }

            @Override
            public void onException(DeskException exception) {
                Log.i("APITEST", exception.getErrorMsg());
            }
        }, categoryId, null, 0, 10, false);
    }

    public void getMostDiscussedTopics(View view) {
        MyApplication.zohoDeskPortalSDKInstnace.getMostDiscussedTopics(new DeskCallback.DeskCommunityTopicsListCallback() {
            @Override
            public void onTopicsListCompleted(DeskTopicsList response) {
                if(response != null && response.getData() != null && response.getData().size() > 0) {
                    renderTopics(response.getData());
                }
            }

            @Override
            public void onException(DeskException exception) {
                Log.i("APITEST", exception.getErrorMsg());
            }
        }, categoryId, null, 0, 10, false);
    }

    private void renderTopics(ArrayList<DeskForumResponse> forumResponses) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT );
        params.setMargins(20, 20, 20, 20);
        topicsLayout.removeAllViews();
        for(DeskForumResponse forumResponse:forumResponses) {
            TextView textView = new TextView(this);
            textView.setLayoutParams(params);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setText(forumResponse.getSubject());
            textView.setTag(forumResponse.getId());
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyApplication.zohoDeskPortalSDKInstnace.startTopicDetails(MainActivity.this,Long.valueOf(v.getTag().toString()));
                }
            });
            topicsLayout.addView(textView);
        }
    }
}
