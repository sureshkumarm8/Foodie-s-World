package com.myfood.foodie.cfood;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myfood.foodie.Foods.FoodItem;
import com.myfood.foodie.Foods.FoodModel;
import com.myfood.foodie.MainActivity;
import com.myfood.foodie.R;

import java.util.List;

/**
 * Created by mark on 23/09/16.
 */

public class FoodAdapter extends BaseAdapter implements View.OnClickListener {

    public static final int DIRECTION_INCOMING = 0;
    public static final int DIRECTION_OUTGOING = 1;
    private List<FoodModel> foods;
    private LayoutInflater mInflater;
    private Activity mActivity;
    private Fragment fragment;

    ViewHolder holder = null;

    public FoodAdapter(Activity mActivity, List<FoodModel> foods) {
        this.foods = foods;
        this.mActivity = mActivity;
    }
    public class ViewHolder {
        TextView chefcard, datecard, titlecard,desccard;
        ImageView food_image_card;
        View delimter;

        ViewHolder(View v) {
            this.chefcard = (TextView) v.findViewById(R.id.food_chef_card);
            this.datecard = (TextView) v.findViewById(R.id.food_date_card);
            this.titlecard = (TextView) v.findViewById(R.id.food_title_card);
            this.desccard = (TextView) v.findViewById(R.id.food_desc_card);
           this.food_image_card = (ImageView) v.findViewById(R.id.food_image_card);
//            this.message = (TextView) v.findViewById(R.id.message_text);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.food_title_card:

                Bundle args = new Bundle();
                args.putString("title",holder.titlecard.getText().toString());
                args.putString("desc",holder.desccard.getText().toString());
                fragment = new FoodItem();

                fragment.setArguments(args);

                if (fragment != null) {
                    android.app.FragmentManager fragmentManager =  mActivity.getFragmentManager();
                    android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.addToBackStack("fooditem");
                    fragmentTransaction.commit();

                }


                break;
            case R.id.food_desc_card:
                Bundle args2 = new Bundle();
                args2.putString("desc",holder.desccard.getText().toString());
                args2.putString("title",holder.titlecard.getText().toString());
                fragment = new FoodItem();

                fragment.setArguments(args2);
                if (fragment != null) {
                    android.app.FragmentManager fragmentManager =  mActivity.getFragmentManager();
                    android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.addToBackStack("fooditem");
                    fragmentTransaction.commit();

                }

                break;
            default:
                break;




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
        holder.titlecard.setOnClickListener(this);
        holder.desccard.setText(item.getBriefDesc());
        holder.desccard.setOnClickListener(this);
        Drawable drawable = mActivity.getResources().getDrawable(item.getThumbnail());
        holder.food_image_card.setImageDrawable(drawable);


        return convertView;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
