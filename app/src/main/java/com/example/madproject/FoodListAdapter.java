package com.example.madproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Food> foodsList;

    public FoodListAdapter(Context context, int layout, ArrayList<Food> foodsList) {
        this.context = context;
        this.layout = layout;
        this.foodsList = foodsList;
    }

    @Override
    public int getCount() {

        return foodsList.size();
    }

    @Override
    public Object getItem(int position) {

        return foodsList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    private class ViewHolder{
        TextView txtCalory, txtDate;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtCalory = (TextView) row.findViewById(R.id.txt_Calories);
            holder.txtDate = (TextView) row.findViewById(R.id.txt_date);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Food food = foodsList.get(position);

        holder.txtCalory.setText(food.getCalories());
        holder.txtDate.setText(food.getDate());
        
        return row;
    }
}
