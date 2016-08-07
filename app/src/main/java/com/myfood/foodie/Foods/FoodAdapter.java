package com.myfood.foodie.Foods;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.TestMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myfood.foodie.R;

import org.w3c.dom.Text;

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
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{
    private Context mContext;
    private List<FoodModel> foodModelList;

    public class FoodViewHolder extends RecyclerView.ViewHolder{
        public ImageView foodImage;
        public TextView foodTitle, foodDesc, datePosted, chefName;

        public FoodViewHolder(View itemView) {
            super(itemView);
            foodImage = (ImageView) itemView.findViewById(R.id.food_image_card);
            foodTitle = (TextView) itemView.findViewById(R.id.food_title_card);
            foodDesc = (TextView) itemView.findViewById(R.id.food_desc_card);
            datePosted = (TextView) itemView.findViewById(R.id.food_date_card);
            chefName = (TextView) itemView.findViewById(R.id.food_chef_card);
        }
    }

    // constructor
    public FoodAdapter(Context mContext, List<FoodModel> foodModelList){
        this.mContext = mContext;
        this.foodModelList = foodModelList;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fooditem_layout, parent, false);
        return new FoodViewHolder(itemView);
    }

    /*CLASS END, get out!!*/
}
