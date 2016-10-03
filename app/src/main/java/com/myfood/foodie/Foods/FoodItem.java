package com.myfood.foodie.Foods;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myfood.foodie.R;

/**
 * Created by mark2 on 03/10/16.
 */

public class FoodItem extends Fragment{
    View mview;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        mview = inflater.inflate(R.layout.food_item,container,false);
        return mview;
    }
}
