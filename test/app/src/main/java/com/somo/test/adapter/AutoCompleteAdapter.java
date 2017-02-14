package com.somo.test.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Filter;

import com.somo.test.R;
import com.somo.test.model.Data;
import com.somo.test.server.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yebonkim on 2016. 12. 1..
 */

public class AutoCompleteAdapter extends ArrayAdapter<Data> implements Filterable {

    Context context;
    int resource;
    int textViewResourceId;
    List<Data> mList, filteredPeople, mListAll;

    public AutoCompleteAdapter(Context context, int resource, int textViewResourceId,
                         List<Data> mList) {
        super(context, resource, textViewResourceId, mList);
        this.context = context;
        this.resource = resource;
        this.textViewResourceId = textViewResourceId;
        this.mList = mList;
        this.mListAll = mList;
        filteredPeople = new ArrayList<Data>();
    }

    @Override
    public Data getItem(int position) {

        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.viewholder_item, parent, false);
            TextView textView = (TextView) view.findViewById(R.id.nameTV);
            textView.setText(mList.get(position).name);
        }
        Data people = mList.get(position);
        if (people != null) {
            TextView textView = (TextView) view.findViewById(R.id.nameTV);
            if (textView != null) {
                textView.setText(people.name);
            }

        }
        return view;
    }

    @Override
    public Filter getFilter() {
        return nameFilter;
    }

    Filter nameFilter = new Filter() {

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            List<Data> filteredList = (List<Data>) results.values;

            if (results != null && results.count > 0) {
                clear();
                for (Data people : filteredList) {
                    add(people);
                }
                notifyDataSetChanged();
                Log.d("Yebon", "why");
            } else {
                notifyDataSetInvalidated();
            }
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint != null) {
                filteredPeople.clear();
                for (int i=0; i<mListAll.size(); i++) {
                    Log.d("Yebon", "Yeah"+mListAll.size());
                    Log.d("Yebon", mListAll.get(i).name+"shshshsh");
                    if (mListAll.get(i).name.contains(constraint)) {
                        Log.d("Yebon", "Yeah2");
                        filteredPeople.add(mListAll.get(i));
                    }
                }
                filterResults.values = filteredPeople;
                filterResults.count = filteredPeople.size();
                Log.d("Yebon", "test"+filterResults.count+"fa2");
            }
            Log.d("Yebon", "test"+filterResults.count+"fa");
            return filterResults;
        }
    };

}