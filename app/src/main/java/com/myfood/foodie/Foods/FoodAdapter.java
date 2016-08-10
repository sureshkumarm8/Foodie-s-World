package com.myfood.foodie.Foods;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myfood.foodie.R;

import java.util.List;

/**
 * Project: Foodie
 * Package: com.myfood.foodie.Foods
 * Created by lusinabrian on 05/08/16 at 06:31
 * Description:Render the RecyclerView, we need an adapter class which inflates the fooditem_layout.xml by keeping appropriate information.
 *
 * The mContext shall render the views in the appropriate view in which it is called
 * foodModelList will hold the Food items in a list.
 *
 * the FoodViewHolder will find the view items with their ids
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{
    private Context mContext;
    private List<FoodModel> foodModelList;
    public int itemLayout;


    // constructor
    public FoodAdapter(Context mContext, List<FoodModel> foodModelList, int itemLayout){
        this.mContext = mContext;
        this.itemLayout = itemLayout;
        this.foodModelList = foodModelList;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        FoodModel foodModel = foodModelList.get(position);
        holder.itemView.setTag(foodModel);
        holder.bind(foodModel);

        //load images using Glider library
        Glide.with(mContext).load(foodModel.getThumbnail()).into(holder.foodImage);
        Glide.with(mContext).load(foodModel.getChefImage()).into(holder.chefImage);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView foodImage, chefImage;
        public TextView foodTitle, foodDesc, datePosted, chefName;

        public ViewHolder(View itemView) {
            super(itemView);
            foodImage = (ImageView) itemView.findViewById(R.id.food_image_card);
            foodTitle = (TextView) itemView.findViewById(R.id.food_title_card);
            foodDesc = (TextView) itemView.findViewById(R.id.food_desc_card);
            datePosted = (TextView) itemView.findViewById(R.id.food_date_card);
            chefName = (TextView) itemView.findViewById(R.id.food_chef_card);
            chefImage = (ImageView)itemView.findViewById(R.id.food_chef_card_img);
        }
        public void bind(FoodModel foodModel){
            foodTitle.setText(foodModel.getFoodName());
            foodDesc.setText(foodModel.getBriefDesc());
            datePosted.setText(foodModel.getDatePosted());
            chefName.setText(foodModel.getChefName());
        }
    }

    public void add(FoodModel itemModel, int postion){
        foodModelList.add(postion,itemModel);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return foodModelList.size();
    }

/*CLASS END, get out!!*/
}
