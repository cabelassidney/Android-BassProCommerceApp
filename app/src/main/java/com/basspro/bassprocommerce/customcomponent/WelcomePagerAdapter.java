package com.basspro.bassprocommerce.customcomponent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.basspro.bassprocommerce.fragments.ChooseYourOwnAdventure;
import com.basspro.bassprocommerce.fragments.StartAdventure;

/**
 * Created by jgreve on 2/28/18.
 */

public class WelcomePagerAdapter extends FragmentPagerAdapter {


    public WelcomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
            case 0:
                return new StartAdventure();
            case 1:
                return new ChooseYourOwnAdventure(); // three way swicth, new, old, guest
//            default:
//                Log.i("position",String.valueOf(position));
//                return new StartAdventure();
        }
    }


    public Fragment onBackPressed(int position) {
        if (position > 0) {
            return getItem(position - 1);
        }

        return getItem(0);
    }

    @Override
    public int getCount() {
        return 2; // TODO kill this magic number
    }
}
