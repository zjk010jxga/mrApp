package com.bsl.mrapp.fragment.Main;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.bsl.mrapp.R;
import com.bsl.mrapp.TopViewActivity;
import com.bsl.mrapp.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.bsl.mrapp.tools.StatusBarUtil.setStatusColor;

/**
 * fragment首页
 */

public class HomeFragment extends BaseFragment {
//    private Unbinder unbinder;
//    @BindView(R.id.iv_js)
//    ImageView ivJs;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);
//        //返回一个Unbinder值（进行解绑），注意这里的this不能使用getActivity()
//        unbinder = ButterKnife.bind(this,rootView);

        return rootView;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
        //setStatusColor(getActivity(),true,true,0);




    }
//    /**
//     * onDestroyView中进行解绑操作
//     */
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }
//    @OnClick(R.id.iv_js)
//    public void ivJs(){
//        Toast.makeText(getActivity(), "is a click", Toast.LENGTH_SHORT).show();
//
//    }

}
