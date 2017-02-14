package com.somo.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.somo.test.R;
import com.somo.test.model.Data;

import java.util.List;

/**
 * Created by K on 2016-11-12.
 */

public class ListAdapter extends BaseAdapter {
    List<Data> data;
    Context context;
    ImageView profile;
    TextView nameTV, addressTV, positionTV;

    public ListAdapter(Context context, List<Data> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).id;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.viewholder_item, viewGroup, false);
        }

        profile = (ImageView) view.findViewById(R.id.profile);
        nameTV = (TextView)view.findViewById(R.id.nameTV);
        addressTV = (TextView)view.findViewById(R.id.addressTV);
        positionTV = (TextView)view.findViewById(R.id.positionTV);

        profile.setBackgroundResource(data.get(i).profile);
        nameTV.setText(data.get(i).name);
        addressTV.setText(data.get(i).address);
        positionTV.setText(data.get(i).position);

        if(i%2==0) {
            nameTV.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        }

        return view;
    }
}
