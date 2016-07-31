package com.myfood.foodie;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 Project: Foodie
 Package: ${PACKAGE_NAME}
 Created by lusinabrian on 31/07/16 at 14:48

 Description: App life begins here. A simple splash screen. Takes 3 seconds, before moving on to next activity
 Has simple display of app logo, tag and indeterminate progress bar
 */
public class SplashScreen extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.splashscreen);
    }


}/*CLASS END*/
