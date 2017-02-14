package com.somo.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.somo.test.R;
import com.somo.test.model.Data;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    int month, day;
    String[] monthStr = {"a","b","c","d","e","f","g","h","i","j","k","l"};
    String[] dayStr = {"a","b","c","d","e","f","g","h","i","j","k","l","a","b","c","d","e","f","g","h","i","j","k","l","a","b","c","d","e","f","g","h","i","j","k","l"};

    @Bind(R.id.resultTV)
    TextView resultTV;

    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getData();
        resultTV.setText("당신의 이름은 "+monthStr[month-1]+dayStr[day-1]+" 입니다.");
    }

    private void getData() {
        data = (Data)getIntent().getSerializableExtra("object");
        Log.d("test", data.name);
        month =1;
        day=1;
        Log.d("test", month+"");
        Log.d("test", day+"");
    }

}
