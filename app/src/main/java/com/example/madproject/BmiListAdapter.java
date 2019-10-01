package com.example.madproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BmiListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Bmi> bmiList;

    public BmiListAdapter(Context context, int layout, ArrayList<Bmi> bmiList) {
        this.context = context;
        this.layout = layout;
        this.bmiList = bmiList;
    }

    @Override
    public int getCount() {
        return bmiList.size();
    }

    @Override
    public Object getItem(int position) {
        return bmiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{

        TextView txtName, txtHeight, txtWeight, txtAns;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtHeight = (TextView) row.findViewById(R.id.txtHeight);
            holder.txtWeight = (TextView) row.findViewById(R.id.txtWeight);
            holder.txtAns = (TextView) row.findViewById(R.id.txtBmi);

            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Bmi bmi = bmiList.get(position);

        holder.txtName.setText(bmi.getName());
        holder.txtHeight.setText("Height : "+bmi.getHeight());
        holder.txtWeight.setText("Weight : "+bmi.getWeight());
        holder.txtAns.setText("BMI : "+bmi.getAns());





        return row;
    }
}
