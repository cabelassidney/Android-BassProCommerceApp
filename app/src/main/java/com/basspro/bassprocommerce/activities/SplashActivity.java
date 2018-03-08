package com.basspro.bassprocommerce.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.basspro.bassprocommerce.R;
import com.basspro.bassprocommerce.https.HttpsUtil;
import com.basspro.bassprocommerce.localstorage.AppData;
import com.basspro.bassprocommerce.services.ServiceLogon;
import com.basspro.bassprocommerce.services.datatypes.LogonData;
import com.basspro.bassprocommerce.services.datatypes.ServiceDataHandler;

/**
 * Created by dpaunovi on 2/12/18.
 */

public class SplashActivity extends AppCompatActivity {


    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        AppData.createSharedPref(getApplicationContext());
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                navigate();
            }
        }, SPLASH_TIME_OUT);

    }

    private void navigate(){
        Intent intent = null;
        if (AppData.isGuest()){

            intent = new Intent(SplashActivity.this, Home.class);
        }else if(AppData.isRegistering()){
            intent = new Intent(SplashActivity.this, Register.class);
        }else if (AppData.isRegistered()){
            intent = new Intent(SplashActivity.this, Home.class);
        }
        else {
            // This method will be executed once the timer is over
            // Start your app main activity
            intent = new Intent(SplashActivity.this, Welcome.class);
        }
        startActivity(intent);
        finish();
    }

}


        /*HttpsUtil.InitializeKeyStore(getApplicationContext());*/
       /* AppData.loadOnSplash(this);

        if (AppData.isNew()) {
            Intent intent = new Intent(SplashActivity.this, Welcome.class);
            startActivity(intent);
            finish();
        } else if (AppData.isGuest()) {
            Intent intent = new Intent(SplashActivity.this, Home.class);
            startActivity(intent);
            finish();
        } else {
            //attempt logon from prefences
            String logonid = AppData.getUserEmail(), password = AppData.getPassword();

            new ServiceLogon().makeCall(logonid, password, new ServiceDataHandler<LogonData>() {
                @Override
                public void handleResponse(LogonData data) {

                    // TODO set addition preferences, like store preferece ore category preference.

                    if (data.isError()) {
                        //TODO if fail, is it bad passowrd, if so
                        //reenter password
                        //or
                        //go to reset password.
                    } else {
                        Intent intent = new Intent(SplashActivity.this, Home.class);
                        startActivity(intent);
                        finish();
                    }
                    return;
                }
            });
        }


        //TODO Get owners data and login if found, otherwise intent to log on
        //if(login worked){
        //    intent = new Intent(this, Home.class);
        //else
//        intent = new Intent(this, Login.class);
//
//        startActivity(intent);
//        finish();

    }
}*/
