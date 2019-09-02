package com.bsl.mrapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.bsl.mrapp.Activity.MainActivity;
import com.bsl.mrapp.Activity.TransactionDetailsActivity;
import com.bsl.mrapp.fragment.WallectDetails.AllFragment;
import com.bsl.mrapp.fragment.WallectDetails.IncomeFragment;
import com.bsl.mrapp.fragment.WallectDetails.SpendingFragment;

public class TradingFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 3;
    private AllFragment myFragment1 = null;
    private IncomeFragment myFragment2 = null;
    private SpendingFragment myFragment3 = null;



    public TradingFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new AllFragment();
        myFragment2 = new IncomeFragment();
        myFragment3 = new SpendingFragment();

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

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case TransactionDetailsActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case TransactionDetailsActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case TransactionDetailsActivity.PAGE_THREE:
                fragment = myFragment3;
                break;

        }
        return fragment;
    }

}

