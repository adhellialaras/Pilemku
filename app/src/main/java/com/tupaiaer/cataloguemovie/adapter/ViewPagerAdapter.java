package com.tupaiaer.cataloguemovie.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tupaiaer.cataloguemovie.ui.fragment.NowPlayingFragment;
import com.tupaiaer.cataloguemovie.ui.fragment.UpcomingFragment;

/**
 * Created by sandypriyatna on 10/03/19
 * github.com/sandypriyatna
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i){
            case 0:
                fragment = new NowPlayingFragment();
                break;
            case 1:
                fragment = new UpcomingFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
