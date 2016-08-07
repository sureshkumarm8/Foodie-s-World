package com.myfood.foodie.Foods;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import com.bumptech.glide.Glide;
import com.myfood.foodie.R;

import java.util.List;

import jp.wasabeef.recyclerview.animators.LandingAnimator;
import jp.wasabeef.recyclerview.animators.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.adapters.ScaleInAnimationAdapter;

/**
 * Project: Foodie
 * Package: com.myfood.foodie
 * Created by lusinabrian on 02/08/16 at 22:06
 * Description: Contains the RecyclerView for the food items
 * Allows the user to refresh using a swipe refresh
 */
public class FoodFragRec extends Fragment{
    private static final  String FOODFRAG_TAG = FoodFragRec.class.getSimpleName();
    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;
    private List<FoodModel> foodModelList;

    public static Fragment newInstance() {
        FoodFragRec frag = new FoodFragRec();
        frag.setRetainInstance(true);
        return frag;
    }
    /**reference to activity which uses fragment for initialization*/
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AppCompatActivity appCompatActivity = (AppCompatActivity) context;
        setRetainInstance(true);
    }

    /*called when it is time for the fragment to draw its UI for the first time*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.foodfragrec_layout, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.food_frag_recycler_id);
        SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.food_frag_swipe_refresh_layout_id);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView.findViewById(R.id.foodfrag_coordinatorLayout_id);
        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.dark_slate_blue,
                R.color.dark_slate_gray,
                R.color.dark_cyan,
                R.color.dark_yellow,
                R.color.dark_turquoise,
                R.color.dark_sea_green);

        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(foodAdapter);
        alphaAdapter.setInterpolator(new OvershootInterpolator());
        ScaleInAnimationAdapter scaleAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new LandingAnimator());
        recyclerView.setAdapter(scaleAdapter);

        prepareMockFoodItems();

        return rootView;
    }

    /*mock images and text for food items*/
    private void prepareMockFoodItems() {
        int[] foodimages = new int[]{
                R.drawable.chef;
        };

    }

    /**
     * Called when host activity is created. View can be accessed with findViewById() method
     **/
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**called once fragment becomes visible*/
    @Override
    public void onStart() {
        super.onStart();
    }

    /**fragment becomes active*/
    @Override
    public void onResume() {
        super.onResume();
    }

    /**called when user leaves fragment where changes should be committed. Changes should persist
     * beyond current user session*/
    @Override
    public void onPause() {
        super.onPause();
    }

    /**when fragment is stopped*/
    @Override
    public void onStop() {
        super.onStop();
    }

    /**
     * fragment is destroyed after this
     * */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * Performs final clean up of fragments state but not guaranteed to be called by Android platform
     * */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
/*END*/
}