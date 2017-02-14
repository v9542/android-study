package com.somo.test.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.handstudio.android.hzgrapherlib.animation.GraphAnimation;
import com.handstudio.android.hzgrapherlib.graphview.LineGraphView;
import com.handstudio.android.hzgrapherlib.vo.GraphNameBox;
import com.handstudio.android.hzgrapherlib.vo.linegraph.LineGraph;
import com.handstudio.android.hzgrapherlib.vo.linegraph.LineGraphVO;
import com.somo.test.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RadioActivity extends AppCompatActivity {
    @Bind(R.id.radioGroup)
    RadioGroup viewGroup;

    final static int PICK_PICTURE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        ButterKnife.bind(this);

        viewGroup.setOnCheckedChangeListener(listenr);
    }

    RadioGroup.OnCheckedChangeListener listenr = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
//            RadioButton radioButton = (RadioButton)findViewById(checkedId);

            switch(checkedId) {
                case R.id.option1:
                    Toast.makeText(RadioActivity.this, "Option1", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.option2:
                    Toast.makeText(RadioActivity.this, "Option2", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        }
    };

}
