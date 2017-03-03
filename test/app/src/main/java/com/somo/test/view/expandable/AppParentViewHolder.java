package com.somo.test.view.expandable;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.somo.test.R;
import com.somo.test.model.expandable.AppParent;

import java.io.Serializable;

/**
 * Created by K on 2016-11-12.
 */

public class AppParentViewHolder extends ParentViewHolder{
    public String name;

    TextView nameTV;
    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this ViewHolder
     */
    public AppParentViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTV = (TextView) itemView.findViewById(R.id.nameTV);
    }

    public void bind(AppParent parent) {
        nameTV.setText(parent.name);
    }
}