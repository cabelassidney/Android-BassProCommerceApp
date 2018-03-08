package com.basspro.bassprocommerce.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.basspro.bassprocommerce.R;
import com.basspro.bassprocommerce.customcomponent.WelcomePagerAdapter;

public class Welcome extends AppCompatActivity {

    public static Welcome welcome;

    public static Welcome getInstance()
    {
        return welcome;
    }
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcome = this;
         vp = (ViewPager) findViewById(R.id.pagerAdvId);
        vp.setAdapter(new WelcomePagerAdapter(getSupportFragmentManager()));

    }

    public void  navigateToSecond()
    {
        vp.setCurrentItem(1);
    }}
