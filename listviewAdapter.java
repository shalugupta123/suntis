package com.example.ankita.testapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ankita on 4/16/2018.
 */

public class listviewAdapter extends BaseAdapter {

    public ArrayList<Model> empDetails;
    Activity activity;

    public listviewAdapter(Activity activity, ArrayList<Model> empDetails) {

        this.activity = activity;
        this.empDetails = empDetails;
    }

    @Override
    public int getCount() {
        return empDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return empDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView mName;
        TextView mTel;
        TextView mSex;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_row, null);
            holder = new ViewHolder();
            holder.mName = (TextView) convertView.findViewById(R.id.tv_row_name);
            holder.mTel = (TextView) convertView.findViewById(R.id.tv_row_tel);
            holder.mSex = (TextView) convertView.findViewById(R.id.tv_row_sex);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Model item = empDetails.get(position);
        holder.mName.setText(item.getName().toString());
        holder.mTel.setText(item.getTel().toString());
        holder.mSex.setText(item.getSex().toString());
        return convertView;
    }
}

