package com.myfood.foodie;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialdrawer.util.KeyboardUtil;
import com.myfood.foodie.Foods.FoodFragRec;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/**
 * Set the view of the screen and find the toolbar
 * create the main drawer for the entire application.
 * The home/main activity will have a FrameLayout and each fragment will be loaded on the FrameLayout
 * The
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static String MAINACTIVITY_TAG = MainActivity.class.getSimpleName();
    /*drawer object to be used*/
    private Drawer drawer = null;
    public Context mcontext;
    android.app.Fragment fragment;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        //setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//
//        drawer = new DrawerBuilder()
//                .withActivity(this)
//                .withHeader(R.layout.main_drawer_header_view)
//                .withActionBarDrawerToggle(true)
//                .addDrawerItems(
//                        new PrimaryDrawerItem().withName(R.string.app_name).withSelectedTextColor(getResources().getColor(R.color.fire_brick)).withIcon(R.mipmap.ic_launcher).withIdentifier(0),
//                        new PrimaryDrawerItem().withName(R.string.app_name).withSelectedTextColor(getResources().getColor(R.color.fire_brick)).withIcon(R.mipmap.ic_launcher).withIdentifier(1),
//                        new PrimaryDrawerItem().withName(R.string.app_name).withSelectedTextColor(getResources().getColor(R.color.fire_brick)).withIcon(R.mipmap.ic_launcher).withIdentifier(2),
//                        new DividerDrawerItem(),
//                        new PrimaryDrawerItem().withName(R.string.app_name).withSelectedTextColor(getResources().getColor(R.color.fire_brick)).withIcon(R.mipmap.ic_launcher).withIdentifier(3)
//                ).withOnDrawerListener(new Drawer.OnDrawerListener(){
//
//                    /*hide keyboard when user opens the drawer*/
//                    @Override
//                    public void onDrawerOpened(View drawerView) {
//                        KeyboardUtil.hideKeyboard(MainActivity.this);
//                    }
//
//                    @Override
//                    public void onDrawerClosed(View drawerView) {
//
//                    }
//
//
//                    @Override
//                    public void onDrawerSlide(View drawerView, float slideOffset) {
//
//                    }
//                }).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//                    @Override
//                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
//                        if(drawerItem != null){
//                            if(drawerItem instanceof Nameable){
//                               String name = ((Nameable) drawerItem).getName().getText(MainActivity.this);
//////                                getActionBar().setTitle(name);
//                                android.app.Fragment fragment = null;
//                                String title = "Foodie";
//                                switch ((int) drawerItem.getIdentifier()){
//                                    case 0:
//                                        fragment = new FoodFragRec();
//                                        title=getString(R.string.app_name);
//                                        Log.d(MAINACTIVITY_TAG, "Opened and Viewing " + name);
//                                        break;
//                                    case 1:
//                                        fragment= new FoodFragRec();
//                                        title =getString(R.string.app_name);
//                                        Log.d(MAINACTIVITY_TAG, name + " opened");
//                                        break;
//                                    case 2:
//                                        fragment= new FoodFragRec();
//                                        title =getString(R.string.app_name);
//                                        Log.d(MAINACTIVITY_TAG,name + " opened");
//                                        break;
//                                    case 3:
//                                        fragment= new FoodFragRec();
//                                        title =getString(R.string.app_name);
//                                        Log.d(MAINACTIVITY_TAG, name + " opened");
//                                        break;
//                                }
//                                if (fragment != null) {
//                                    android.app.FragmentManager fragmentManager = getFragmentManager();
//                                    android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                                    fragmentTransaction.replace(R.id.container_body, fragment);
//                                    fragmentTransaction.commit();
//                                    // set the toolbar title
//                                   //// getActionBar().setTitle(title);
//                                }
//                            }
//                        }
//                        return false;
//                    }
//                }).build();

        /*Add custom activity on crash*/
        CustomActivityOnCrash.install(this);
        CustomActivityOnCrash.setEnableAppRestart(true);
        /*show the stracktrace*/
        CustomActivityOnCrash.setShowErrorDetails(false);
        CustomActivityOnCrash.setRestartActivityClass(MainActivity.class);

    }

/*-------------------OPTION MENU---------------------------------------------*/

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_camera:
                fragment = new FoodFragRec();
                break;
            case R.id.nav_gallery:
                fragment = new FoodFragRec();
                break;
            case R.id.nav_slideshow:
                fragment = new FoodFragRec();
                break;
            default:
                break;
        }

        if (fragment != null) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.addToBackStack("fooditem");
            fragmentTransaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*----------------------------------------------------------------------------------------------------------*/
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = drawer.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        super.onSaveInstanceState(outState);
    }

    /**
     * Take care of popping the fragment back stack or finishing the activity as appropriate.
     */
    @Override
    public void onBackPressed() {
        //handle the back press close the drawer first and if the drawer is closed close the activity
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

/*CLASS END*/
}
