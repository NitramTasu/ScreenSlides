package br.martin.screenslides;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Martin on 18/11/2016.
 */

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    protected  static  final String[] CONTENT = new String[]{"This", "Is", "A", "Test"};
    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ScreenSlidePageFragment.create(CONTENT[position]);
    }

    @Override
    public int getCount() {
        return CONTENT.length;
    }
}
