package com.somo.test.view.expandable;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.somo.test.R;
import com.somo.test.model.expandable.AppParent;
import com.somo.test.model.expandable.Child;

/**
 * Created by K on 2016-11-12.
 */

public class AppChildViewHolder extends ChildViewHolder {
    public String name;

    TextView nameTV;
    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this ViewHolder
     */
    public AppChildViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTV = (TextView) itemView.findViewById(R.id.nameTV);
    }

    public void bind(Child child) {
        nameTV.setText(child.name);
    }
}