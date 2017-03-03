package com.somo.test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.somo.test.R;
import com.somo.test.model.Data;
import com.somo.test.model.expandable.AppParent;
import com.somo.test.model.expandable.Child;
import com.somo.test.view.expandable.AppChildViewHolder;
import com.somo.test.view.expandable.AppParentViewHolder;

import java.util.List;

/**
 * Created by yebonkim on 2016. 11. 17..
 */

public class ExpandableAdapter extends ExpandableRecyclerAdapter<AppParent, Child, AppParentViewHolder, AppChildViewHolder> {

    private LayoutInflater mInflater;

    List<AppParent> parentItemList;

    public ExpandableAdapter(Context context, @NonNull List<AppParent> data) {
        super(data);
        this.parentItemList = data;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AppParentViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View parentView = mInflater.inflate(R.layout.viewholder_text, parentViewGroup, false);
        return new AppParentViewHolder(parentView);
    }

    @NonNull
    @Override
    public AppChildViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View childView = mInflater.inflate(R.layout.viewholder_text, childViewGroup, false);
        return new AppChildViewHolder(childView);
    }

    @Override
    public void onBindParentViewHolder(@NonNull AppParentViewHolder parentViewHolder, int parentPosition, @NonNull AppParent parent) {
        parentViewHolder.bind(parent);
    }

    @Override
    public void onBindChildViewHolder(@NonNull AppChildViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull Child child) {
        childViewHolder.bind(child);
    }
}