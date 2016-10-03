package com.myfood.foodie.cfood;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.myfood.foodie.Foods.FoodModel;
import com.myfood.foodie.R;

import java.util.List;

/**
 * Created by mark on 23/09/16.
 */

public class FoodAdapter extends BaseAdapter{

    public static final int DIRECTION_INCOMING = 0;
    public static final int DIRECTION_OUTGOING = 1;
    private List<FoodModel> foods;
    private LayoutInflater mInflater;
    private Activity mActivity;

    ViewHolder holder = null;

    public FoodAdapter(Activity mActivity, List<FoodModel> foods) {
        this.foods = foods;
        this.mActivity = mActivity;
    }

    private class ViewHolder {
        TextView chefcard, datecard, titlecard,desccard;
        View delimter;

        ViewHolder(View v) {
            this.chefcard = (TextView) v.findViewById(R.id.food_chef_card);
            this.datecard = (TextView) v.findViewById(R.id.food_date_card);
            this.titlecard = (TextView) v.findViewById(R.id.food_title_card);
           this.desccard = (TextView) v.findViewById(R.id.food_desc_card);
//            this.delimter = v.findViewById(R.id.message_delimter);
//            this.message = (TextView) v.findViewById(R.id.message_text);
        }
    }

    @Override
    public Object getItem(int i) {
        return foods.get(i);
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (mInflater == null)
            mInflater = (LayoutInflater) mActivity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        FoodModel item = (FoodModel) getItem(i);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.fooditem_layout, viewGroup,
                    false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.chefcard.setText(item.getChefName());
        holder.datecard.setText(item.getDatePosted());
        holder.titlecard.setText(item.getFoodName());
        holder.desccard.setText(item.getBriefDesc());


        return convertView;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
