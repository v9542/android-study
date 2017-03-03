package com.somo.test.activity;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.somo.test.R;
import com.somo.test.adapter.MyRecyclerViewAdapter;
import com.somo.test.model.Data;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShareActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar);
        ButterKnife.bind(this);


        String subject = "메시지 제목";
        String text = "메시지 내용은\n다음줄에서..";

        List targetedShareIntents = new ArrayList<>();

        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");

        // 페이스북
        Intent facebookIntent = getShareIntent("facebook", subject, text);
        if (facebookIntent != null)
            targetedShareIntents.add(facebookIntent);

        // 트위터
        Intent twitterIntent = getShareIntent("twitter", subject, text);
        if (twitterIntent != null)
            targetedShareIntents.add(twitterIntent);

        // 구글 플러스
        Intent googlePlusIntent = getShareIntent("com.google.android.apps.plus", subject, text);
        if (googlePlusIntent != null)
            targetedShareIntents.add(googlePlusIntent);

        // Gmail
        Intent gmailIntent = getShareIntent("gmail", subject, text);
        if (gmailIntent != null)
            targetedShareIntents.add(gmailIntent);

        Intent chooser = Intent.createChooser(intent, "SNS");
        chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetedShareIntents.toArray(new Parcelable[]{}));
        startActivity(chooser);


    }

    private Intent getShareIntent(String name, String subject, String text) {
        boolean found = false;

        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");

        // gets the list of intents that can be loaded.
        List<ResolveInfo> resInfos = getPackageManager().queryIntentActivities(intent, 0);

        if (resInfos == null || resInfos.size() == 0)
            return null;

        for (ResolveInfo info : resInfos) {
            if (info.activityInfo.packageName.toLowerCase().contains(name) ||
                    info.activityInfo.name.toLowerCase().contains(name)) {
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, text);
                intent.setPackage(info.activityInfo.packageName);
                found = true;
                break;
            }
        }

        if (found)
            return intent;

        return null;
    }

}
