package com.somo.test.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.somo.test.R;
import com.somo.test.adapter.ViewPagerAdapter;
import com.somo.test.fragment.ImageFragment;
import com.somo.test.server.model.Person;
import com.somo.test.server.model.PersonResponse;
import com.somo.test.server.serverinterface.ServerQuery;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ServerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ButterKnife.bind(this);

        Person p = new Person(1, "asdf", 22, 12222222);

        ServerQuery.postPerson(p, new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                int code = response.code();

                if(code == 200) {
                    PersonResponse response1 = (PersonResponse)response.body();
                    Toast.makeText(getApplicationContext(), "aaaa"+response1.results.id, Toast.LENGTH_LONG).show();
                }else {
                    Log.d("Yebon", "asdfasdfa");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
