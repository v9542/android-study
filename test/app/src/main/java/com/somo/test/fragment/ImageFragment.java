package com.somo.test.fragment;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.somo.test.R;

public class ImageFragment extends Fragment {

    Context context;
    ImageView image;
    int filepath;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_viewpager, container, false);
        ImageView image = (ImageView) v.findViewById(R.id.image);

        context = getActivity().getApplicationContext();
        filepath = getArguments().getInt("image");


        image.setBackground(context.getResources().getDrawable(filepath));

        image.post(mRunnable);
        return v;
    }

    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                Matrix matrix = new Matrix();
                matrix.reset();

                float wv = image.getWidth();
                float hv = image.getHeight();

                float wi = image.getDrawable().getIntrinsicWidth();
                float hi = image.getDrawable().getIntrinsicHeight();

                float width = wv;
                float height = hv;

                if (wi / wv > hi / hv) {
                    matrix.setScale(hv / hi, hv / hi);
                    width = wi * hv / hi;
                } else {
                    matrix.setScale(wv / wi, wv / wi);
                    height = hi * wv / wi;
                }

                matrix.preTranslate((wv - width) / 2, (hv - height) / 2);
                image.setScaleType(ImageView.ScaleType.CENTER_CROP);
                image.setImageMatrix(matrix);
            }catch (Exception e){

            }
        }
    };
}
