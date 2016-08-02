package com.myfood.foodie;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialdrawer.util.KeyboardUtil;
import com.myfood.foodie.Foods.FoodFragment;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/**Set the view of the screen and find the toolbar
 * create the main drawer for the entire application.
 * The home/main activity will have a FrameLayout and each fragment will be loaded on the FrameLayout
 * The*/
public class MainActivity extends AppCompatActivity {
    public static String MAINACTIVITY_TAG = MainActivity.class.getSimpleName();
    /*drawer object to be used*/
    private Drawer drawer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHeader(R.layout.main_drawer_header_view)
                .withActionBarDrawerToggle(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.app_name).withSelectedTextColor(getResources().getColor(R.color.fire_brick)).withIcon(R.mipmap.ic_launcher).withIdentifier(0),
                        new PrimaryDrawerItem().withName(R.string.app_name).withSelectedTextColor(getResources().getColor(R.color.fire_brick)).withIcon(R.mipmap.ic_launcher).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.app_name).withSelectedTextColor(getResources().getColor(R.color.fire_brick)).withIcon(R.mipmap.ic_launcher).withIdentifier(2),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName(R.string.app_name).withSelectedTextColor(getResources().getColor(R.color.fire_brick)).withIcon(R.mipmap.ic_launcher).withIdentifier(3)
                ).withOnDrawerListener(new Drawer.OnDrawerListener(){

                    /*hide keyboard when user opens the drawer*/
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        KeyboardUtil.hideKeyboard(MainActivity.this);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {

                    }


                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {

                    }
                }).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if(drawerItem != null){
                            if(drawerItem instanceof Nameable){
                               String name = ((Nameable) drawerItem).getName().getText(MainActivity.this);
                                getSupportActionBar().setTitle(name);
                                Fragment fragment = null;
                                String title;
                                switch ((int) drawerItem.getIdentifier()){
                                    case 0:
                                        fragment = FoodFragment.newInstance();
                                        title=getString(R.string.title_news);
                                        Log.d(MAINACTIVITY_TAG, "Opened and Viewing " + name);
                                        break;
                                    case 1:
                                        fragment= StocksFragment.newInstance();
                                        title =getString(R.string.title_stocks);
                                        Log.d(MAINACTIVITY_TAG, name + " opened");
                                        break;
                                    case 2:
                                        fragment= ForexFragment.newInstance();
                                        title =getString(R.string.title_forex);
                                        Log.d(MAINACTIVITY_TAG,name + " opened");
                                        break;
                                    case 3:
                                        fragment= BondsFragment.newInstance();
                                        title =getString(R.string.title_bonds);
                                        Log.d(MAINACTIVITY_TAG, name + " opened");
                                        break;
                                }
                                if (fragment != null) {
                                    FragmentManager fragmentManager = getSupportFragmentManager();
                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                    fragmentTransaction.replace(R.id.container_body, fragment);
                                    fragmentTransaction.commit();
                                    // set the toolbar title
                                    getSupportActionBar().setTitle(title);
                                }
                            }
                        }
                        return false;
                    }
                }).build();

        /*Add custom activity on crash*/
        CustomActivityOnCrash.install(this);
        CustomActivityOnCrash.setEnableAppRestart(true);
        /*show the stracktrace*/
        CustomActivityOnCrash.setShowErrorDetails(false);
        CustomActivityOnCrash.setRestartActivityClass(MainActivity.class);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

/*-------------------OPTION MENU---------------------------------------------*/

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

    /** Take care of popping the fragment back stack or finishing the activity as appropriate.*/
    @Override
    public void onBackPressed() {
        //handle the back press close the drawer first and if the drawer is closed close the activity
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();}
    }

/*CLASS END*/
}
