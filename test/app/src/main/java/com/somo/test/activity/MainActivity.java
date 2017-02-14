package com.somo.test.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.somo.test.LoadingDialog;
import com.somo.test.LoadingTask;
import com.somo.test.R;
import com.somo.test.UserDBDAO;
import com.somo.test.Util;
import com.somo.test.adapter.AutoCompleteAdapter;
import com.somo.test.adapter.ListAdapter;
import com.somo.test.adapter.MyRecyclerViewAdapter;
import com.somo.test.model.Data;
import com.somo.test.server.ArticleClass;
import com.somo.test.server.ArticleListClassResponse;
import com.somo.test.server.BasicResponse;
import com.somo.test.server.ClearTimeRequest;
import com.somo.test.server.RequirementRequest;
import com.somo.test.server.ServerQuery;
import com.somo.test.server.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.listView)
    RecyclerView listView;
    @Bind(R.id.img)
    ImageView imageView;
    @Bind(R.id.auto)
    AutoCompleteTextView textView;

    MyRecyclerViewAdapter adapter;

    ArrayList<Data> data;
    UserDBDAO userDB;

    AutoCompleteAdapter autoAdapter;
    LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        loadingDialog = new LoadingDialog(MainActivity.this, task);
        loadingDialog.execute();

        data = new ArrayList<Data>();
        setData();

        Intent i;

        listView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new MyRecyclerViewAdapter(MainActivity.this, data);
        listView.setAdapter(adapter);


        User user = new User();
        user.setId(1);
        user.setUser_id("asdf");
        userDB = new UserDBDAO(this);
        userDB.insert(user);
        Toast.makeText(this, userDB.selectById(1).getUser_id(), Toast.LENGTH_LONG).show();

        autoAdapter = new AutoCompleteAdapter(this, R.layout.activity_main, R.id.auto, data);
        textView.setAdapter(autoAdapter);

    }



    LoadingTask task = new LoadingTask() {
        @Override
        public void task() {
            Glide.with(MainActivity.this)
                    .load("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTVqAbX10kUmA3tsot2KMLr-Z8wecnulAwADgRR_euzhWJgrunvng")
                    .into(imageView);
        }
    };

    private void setData() {
        Data temp = new Data();
        temp.profile = R.mipmap.ic_launcher;
        temp.address = "주소";
        temp.name = "text test";
        temp.position = "직업";
        Data temp2 = new Data();
        temp.profile = R.mipmap.ic_launcher;
        temp.address = "주소2";
        temp.name = "text2 test2";
        temp.position = "직업2";
        data.add(temp);
        data.add(temp2);
//        for(int i=0; i<3; i++) {
//            data.add(temp);
//            data.add(temp2);
//        }
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("object", data.get(i));
            startActivity(intent);

            Toast.makeText(MainActivity.this, data.get(i).name, Toast.LENGTH_SHORT).show();
        }
    };

    void submit() {

    }

    @OnClick(R.id.btn)
    public void showToast() {
        String userid = textView.getText().toString();
        if(userid.length()>=10) {
            Util.showDialog(MainActivity.this, "long", "titile", "ok");
        }else {
            submit();
        }
//        RequirementRequest request = new RequirementRequest("asdfa", "102");
//        ClearTimeRequest request1 = new ClearTimeRequest("12:00");
//        ServerQuery.getServiceArticleClass(new Callback() {
//            @Override
//            public void onResponse(Response response, Retrofit retrofit) {
//                ArticleListClassResponse response1 = (ArticleListClassResponse)response.body();
//                List<ArticleClass> result = response1.getArticleClass();
//
//                Toast.makeText(MainActivity.this, result.get(0).getTitle(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
    }
}