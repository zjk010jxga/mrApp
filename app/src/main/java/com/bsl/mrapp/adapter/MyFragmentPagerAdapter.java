package com.bsl.mrapp.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.bsl.mrapp.Activity.MainActivity;
import com.bsl.mrapp.fragment.Main.HomeFragment;
import com.bsl.mrapp.fragment.Main.MyFragment;
import com.bsl.mrapp.fragment.Main.VideoFragment;

import static com.bsl.mrapp.tools.StatusBarUtil.setStatusColor;

public class  MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 3;
    private HomeFragment myFragment1 = null;
    private VideoFragment myFragment2 = null;
    private MyFragment myFragment3 = null;



    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new HomeFragment();
        myFragment2 = new VideoFragment();
        myFragment3 = new MyFragment();

    }


    @Override
    public int getCount() {

        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destroy" + position);
        super.destroyItem(container, position, object);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case MainActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case MainActivity.PAGE_THREE:
                fragment = myFragment3;
                break;

        }
        return fragment;
    }

}

