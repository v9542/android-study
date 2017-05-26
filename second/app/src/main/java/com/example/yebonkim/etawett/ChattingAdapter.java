package com.example.yebonkim.etawett;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * Created by yebonkim on 2016. 11. 17..
 */

public class ChattingAdapter extends RecyclerView.Adapter<ChattingAdapter.CustomViewHolder> {

    private Context mContext;
    List<Chat> data;

    public ChattingAdapter(Context context, List<Chat> data) {
        this.data = data;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_chat, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Chat item = data.get(i);

        customViewHolder.userIdTv.setText(data.get(i).getUserId()+" : ");
        customViewHolder.chatTv.setText(data.get(i).getData());

    }

    public void addData(Chat c) {
        this.data.add(c);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (data != null ? data.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView userIdTv, chatTv;
        protected View view;

        public CustomViewHolder(View view) {
            super(view);
            this.view = view;
            this.userIdTv = (TextView)view.findViewById(R.id.userIdTv);
            this.chatTv = (TextView)view.findViewById(R.id.textTv);
        }
    }
}