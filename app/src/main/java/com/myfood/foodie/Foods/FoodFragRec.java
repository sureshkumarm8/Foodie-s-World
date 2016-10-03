package com.myfood.foodie.Foods;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.myfood.foodie.MainActivity;
import com.myfood.foodie.R;
import com.myfood.foodie.cfood.FoodAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Foodie
 * Package: com.myfood.foodie
 * Created by lusinabrian on 02/08/16 at 22:06
 * Description: Contains the RecyclerView for the food items
 * Allows the user to refresh using a swipe refresh
 */
public class FoodFragRec extends Fragment{
    private static final  String FOODFRAG_TAG = FoodFragRec.class.getSimpleName();
    private ListView listView;
    //private com.myfood.foodie.cfood.FoodAdapterdapter foodAdapter;
    private com.myfood.foodie.cfood.FoodAdapter foodAdapter;
    private List<FoodModel> foodModelList;
    private LinearLayout linearLayout;
    private View mView;
    private Fragment fragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //has options?
        setHasOptionsMenu(true);

        View rootView = inflater.inflate(R.layout.foodfragrec_layout, container, false);
        listView = (ListView) rootView.findViewById(R.id.recipemainList);


        /*initialize the food model list*/
        foodModelList = new ArrayList<>();
        prepareMockFoodItems();
        foodAdapter = new FoodAdapter(getActivity(), foodModelList);
        listView.setAdapter(foodAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                Log.i("here", "clicked");

                Toast.makeText(getActivity(), "ccliked here ", Toast.LENGTH_LONG).show();


                fragment = new FoodItem();

                if (fragment != null) {
                    android.app.FragmentManager fragmentManager = getFragmentManager();
                    android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.addToBackStack("fooditem");
                    fragmentTransaction.commit();

                }
            }
        });



        return rootView;

    }


    /*called when it is time for the fragment to draw its UI for the first time*/


    /*mock images and text for food items*/
    private void prepareMockFoodItems() {
        int[] foodimages = new int[]{
                R.drawable.bread,
                R.drawable.bread_powdered,
                R.drawable.lasagna,
                R.drawable.salad,
                R.drawable.salmon,
                R.drawable.sweet_cashews,
                R.drawable.noodle,
                R.drawable.rolled_buns,
                R.drawable.teriyaki,
                R.drawable.pancakes
        };

        int[] chefImages = new int[]{
                R.drawable.lusina,
                R.drawable.squirell_oracle,
                R.drawable.thinker,
                R.drawable.intelu
        };
        //add mock data
        FoodModel foodModel = new FoodModel("Bread", "The Lusina",getString(R.string.food_desc_card), "Wednesday",foodimages[0], chefImages[0]);
        foodModelList.add(foodModel);

        foodModel = new FoodModel("Bread Powdered", "Brian",getString(R.string.food_desc_card), "Thursday",foodimages[1],chefImages[1]);
        foodModelList.add(foodModel);

        foodModel = new FoodModel("Lasagna", "Awori",getString(R.string.food_desc_card), "Friday",foodimages[2],chefImages[2]);
        foodModelList.add(foodModel);

        foodModel = new FoodModel("Salad", "Ombito",getString(R.string.food_desc_card), "Saturday",foodimages[3],chefImages[3]);
        foodModelList.add(foodModel);

        foodModel = new FoodModel("Salmon", "Lusina",getString(R.string.food_desc_card), "Wednesday",foodimages[4],chefImages[3]);
        foodModelList.add(foodModel);

        foodModel = new FoodModel("Sweet Cashews", "DeDe",getString(R.string.food_desc_card), "Wednesday",foodimages[5],chefImages[1]);
        foodModelList.add(foodModel);

        foodModel = new FoodModel("Noodle", "The Lusina",getString(R.string.food_desc_card), "Wednesday",foodimages[6],chefImages[0]);
        foodModelList.add(foodModel);

        foodModel = new FoodModel("Rolled Buns", "The Lusina",getString(R.string.food_desc_card), "Wednesday",foodimages[7],chefImages[1]);
        foodModelList.add(foodModel);

        foodModel = new FoodModel("Teriyaki", "The Lusina",getString(R.string.food_desc_card), "Wednesday",foodimages[8],chefImages[2]);
        foodModelList.add(foodModel);
        Log.d(FOODFRAG_TAG, foodModel.toString());
        foodModel = new FoodModel("Pancakes", "The Lusina",getString(R.string.food_desc_card), "Wednesday",foodimages[9],chefImages[3]);
        foodModelList.add(foodModel);
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
        prepareMockFoodItems();
    }

    /**fragment becomes active*/
    @Override
    public void onResume() {
        super.onResume();
        prepareMockFoodItems();
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