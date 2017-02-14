package com.somo.test.activity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.handstudio.android.hzgrapherlib.animation.GraphAnimation;
import com.handstudio.android.hzgrapherlib.graphview.LineGraphView;
import com.handstudio.android.hzgrapherlib.vo.GraphNameBox;
import com.handstudio.android.hzgrapherlib.vo.linegraph.LineGraph;
import com.handstudio.android.hzgrapherlib.vo.linegraph.LineGraphVO;
import com.somo.test.R;
import com.somo.test.receiver.MessageReceiver;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChartActivity extends AppCompatActivity {
    @Bind(R.id.viewGroup)
    RelativeLayout viewGroup;

    final static int PICK_PICTURE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        ButterKnife.bind(this);

        viewGroup.addView(new LineGraphView(this , makeLineGraphAllSetting()));


        Intent i = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, PICK_PICTURE);
    }

    /**
     * make line graph using options
     * @return
     */
    private LineGraphVO makeLineGraphAllSetting() {
        //BASIC LAYOUT SETTING
        //padding
        int paddingBottom 	= LineGraphVO.DEFAULT_PADDING;
        int paddingTop 		= LineGraphVO.DEFAULT_PADDING;
        int paddingLeft 	= LineGraphVO.DEFAULT_PADDING;
        int paddingRight 	= LineGraphVO.DEFAULT_PADDING;

        //graph margin
        int marginTop 		= LineGraphVO.DEFAULT_MARGIN_TOP;
        int marginRight 	= LineGraphVO.DEFAULT_MARGIN_RIGHT;

        //max value
        int maxValue 		= LineGraphVO.DEFAULT_MAX_VALUE;

        //increment
        int increment 		= LineGraphVO.DEFAULT_INCREMENT;

        //GRAPH SETTING
        String[] legendArr 	= {"1","2","3","4","5"};
        float[] graph1 		= {500,100,300,200,100};
        float[] graph2 		= {000,100,200,100,200};
        float[] graph3 		= {200,500,300,400,000};

        List<LineGraph> arrGraph 		= new ArrayList<LineGraph>();

        arrGraph.add(new LineGraph("android", 0xaa66ff33, graph1, R.drawable.ic_map_start));
        arrGraph.add(new LineGraph("ios", 0xaa00ffff, graph2));
        arrGraph.add(new LineGraph("tizen", 0xaaff0066, graph3));

        LineGraphVO vo = new LineGraphVO(
                paddingBottom, paddingTop, paddingLeft, paddingRight,
                marginTop, marginRight, maxValue, increment, legendArr, arrGraph);

        //set animation
        vo.setAnimation(new GraphAnimation(GraphAnimation.LINEAR_ANIMATION, GraphAnimation.DEFAULT_DURATION));
        //set graph name box
        vo.setGraphNameBox(new GraphNameBox());
        //set draw graph region
//		vo.setDrawRegion(true);

        //use icon
//		arrGraph.add(new Graph(0xaa66ff33, graph1, R.drawable.icon1));
//		arrGraph.add(new Graph(0xaa00ffff, graph2, R.drawable.icon2));
//		arrGraph.add(new Graph(0xaaff0066, graph3, R.drawable.icon3));

//		LineGraphVO vo = new LineGraphVO(
//				paddingBottom, paddingTop, paddingLeft, paddingRight,
//				marginTop, marginRight, maxValue, increment, legendArr, arrGraph, R.drawable.bg);
        return vo;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_PICTURE && resultCode == RESULT_OK
                && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            Bitmap bitmap = BitmapFactory.decodeFile(picturePath);
            Log.d("Yebon", picturePath+"test");
            ImageView imageView = new ImageView(this);

            imageView.setImageBitmap(bitmap);
            viewGroup.addView(imageView);

        } else {
        }
    }
}
