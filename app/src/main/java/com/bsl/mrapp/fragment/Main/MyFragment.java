package com.bsl.mrapp.fragment.Main;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bsl.mrapp.Activity.Lock.LockActivity;
import com.bsl.mrapp.Activity.Me.MyQrCodeActivity;
import com.bsl.mrapp.Activity.Me.MyWalletActivity;
import com.bsl.mrapp.Activity.Me.PersonInfoActivity;
import com.bsl.mrapp.Activity.Me.SettingActivity;
import com.bsl.mrapp.R;


public class MyFragment extends Fragment implements View.OnClickListener {
    private ImageView userHead,sex,qr_code;
    private TextView nick,area,address;
    private LinearLayout wallet,setting,yunCode;
    private RelativeLayout info;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_me,container,false);
        return rootView;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
        userHead = getActivity().findViewById(R.id.usr_img);
        sex =getActivity().findViewById(R.id.sex);
        qr_code =getActivity().findViewById(R.id.qr_code);
        nick = getActivity().findViewById(R.id.nick);
        area = getActivity().findViewById(R.id.area);
        address = getActivity().findViewById(R.id.address);
        wallet = getActivity().findViewById(R.id.mr_wallet);
        setting = getActivity().findViewById(R.id.mr_setting);
        info =  getActivity().findViewById(R.id.ps_info);
        yunCode = getActivity().findViewById(R.id.mr_yun_code);
        wallet.setOnClickListener(this);
        setting.setOnClickListener(this);
        yunCode.setOnClickListener(this);
        /**userHead.setOnClickListener(this);
        sex.setOnClickListener(this);
        nick.setOnClickListener(this);
        area.setOnClickListener(this);
        address.setOnClickListener(this);**/
        info.setOnClickListener(this);
        qr_code.setOnClickListener(this);
        //setStatusColor(getActivity(),true,false,0);


    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.ps_info:
                startActivity(new Intent(getActivity(), PersonInfoActivity.class));
                break;
            case R.id.qr_code:
                startActivity(new Intent(getActivity(), MyQrCodeActivity.class));
                break;
            case R.id.mr_wallet:
                startActivity(new Intent(getActivity(), MyWalletActivity.class));
                break;
            case R.id.mr_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            case R.id.mr_yun_code:
                startActivity(new Intent(getActivity(), LockActivity.class));
                break;


        }
    }
}
