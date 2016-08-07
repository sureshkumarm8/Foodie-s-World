package com.myfood.foodie;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 Project: Foodie
 Package: ${PACKAGE_NAME}
 Created by lusinabrian on 31/07/16 at 14:48

 Description: App life begins here. A simple splash screen. Takes 3 seconds, before moving on to next activity
 Has simple display of app logo, tag and indeterminate progress bar
 */
public class SplashScreen extends AppCompatActivity{
    /*FIELDS*/
    private TextView appName, appTag;
    private ImageView appIcon;

    /**Set the window to full screen using requestWindow feature
     * set the height and the window and the view
     * initialize the UI controls, that is the app icon, name and tag
     * Set the timer on a thread to mock a loading view
     * set the splash screen to display for only 3s, before moving on to Main activity*/
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splashscreen);

        initializeUICtrls();

        //set the timer
        Thread timer = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                Intent openMain = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(openMain);
            }
        };
        //start timer
        timer.start();
    }
    /**Initializes the User Interface controls
     * obtains the appName, appTag and appIcon variables and finds their ids in the layout*/
    private void initializeUICtrls() {
        appIcon = (ImageView)findViewById(R.id.appicon_splash);
        appName = (TextView)findViewById(R.id.appname_splash);
        appTag = (TextView)findViewById(R.id.apptag_splash);

        //set the fonts
        String fontPath = "fonts/Roboto-Black.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), fontPath);
        appName.setTypeface(typeface);
    }

    /*kill this splash screen to save memory*/
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}/*CLASS END*/
