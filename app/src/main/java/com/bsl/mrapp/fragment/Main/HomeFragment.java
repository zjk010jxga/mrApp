package com.bsl.mrapp.fragment.Main;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bsl.mrapp.R;
import com.bsl.mrapp.base.BaseFragment;

import static com.bsl.mrapp.tools.StatusBarUtil.setStatusColor;

/**
 * fragment首页
 */

public class HomeFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);
        return rootView;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
        //setStatusColor(getActivity(),true,true,0);


    }
}
