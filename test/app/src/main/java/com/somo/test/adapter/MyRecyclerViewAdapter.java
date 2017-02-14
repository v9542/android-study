package com.somo.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.somo.test.R;
import com.somo.test.model.Data;

import java.util.List;

/**
 * Created by yebonkim on 2016. 11. 17..
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.CustomViewHolder> {

    private Context mContext;
    List<Data> data;

    public MyRecyclerViewAdapter(Context context, List<Data> data) {
        this.data = data;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_item, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Data item = data.get(i);

        customViewHolder.imageView.setBackgroundResource(R.drawable.main_activities);
        customViewHolder.name.setText("asdf"+i);
        customViewHolder.address.setText("address"+i);
        customViewHolder.position.setText("position"+i);

        customViewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (data != null ? data.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView name, address, position;
        protected View view;

        public CustomViewHolder(View view) {
            super(view);
            this.view = view;
            this.imageView = (ImageView) view.findViewById(R.id.profile);
            this.name = (TextView) view.findViewById(R.id.nameTV);
            this.address = (TextView) view.findViewById(R.id.addressTV);
            this.position = (TextView) view.findViewById(R.id.positionTV);
        }
    }
}