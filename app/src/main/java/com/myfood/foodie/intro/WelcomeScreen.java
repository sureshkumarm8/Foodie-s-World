package com.myfood.foodie.intro;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;

/**
 * Foodie-s-World
 * com.myfood.foodie.intro
 * Created by lusinabrian on 28/10/16.
 * Description: Welcome screen for the application, will be displayed once
 */

public class WelcomeScreen extends WelcomeActivity {

    @Override
    protected WelcomeConfiguration configuration() {
        /*return new WelcomeConfiguration.Builder(this)
                .defaultTitleTypefacePath("Montserrat-Bold.ttf")
                .defaultHeaderTypefacePath("Montserrat-Bold.ttf")
                //page 1
                .page(new BasicPage(R.drawable.ic_front_desk_white,
                        "Welcome",
                        "An Android app that loves food as much as you do")
                        .background(R.color.orange_background)
                )

                //page 2
                .page(new BasicPage(R.drawable.ic_fron_desck_white,
                        "Easy to use",
                        "").background()
                )*/
        return null;
    }
}
