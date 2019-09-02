package com.bsl.mrapp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;


import com.bsl.mrapp.R;

/**
 * 选择世界或朋友圈底部弹窗dialog

public class SelectWorldFriendCircleDialog extends Dialog implements View.OnClickListener {
    private static SelectWorldFriendCircleDialog bottomDialog;
    private View vwChatBg;
    private RelativeLayout rlChatVideoCall, rlChatVoiceCall, rlChatCancel;
    private CallBack callBack;

    public interface CallBack{
        void setVideoCall();
        void setVoiceCall();
    }
/**
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_circle_view);
        findId();
    }

    /**
     * 初始化
     *
    private void findId() {
        vwChatBg = findViewById(R.id.vwChatBg);
        rlChatVideoCall = findViewById(R.id.rlChatVideoCall);
        rlChatVoiceCall = findViewById(R.id.rlChatVoiceCall);
        rlChatCancel = findViewById(R.id.rlChatCancel);
        vwChatBg.setOnClickListener(this);
        rlChatVideoCall.setOnClickListener(this);
        rlChatVoiceCall.setOnClickListener(this);
        rlChatCancel.setOnClickListener(this);
    }

    public SelectWorldFriendCircleDialog(@NonNull Context context, int themeResId, CallBack callBack) {
        super(context, themeResId);
        this.callBack = callBack;
    }

    public static SelectWorldFriendCircleDialog getInstance(Context context, CallBack callBack) {
        if (bottomDialog == null) {
            bottomDialog = new SelectWorldFriendCircleDialog(context, R.style.BottomDialog,callBack);
            bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
            bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        }
        return bottomDialog;
    }

    public void showDialog() {
        bottomDialog.show();
    }

    public void dismissDialog() {
        bottomDialog.dismiss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.vwChatBg:
//                bottomDialog.dismiss();
                dismiss();
                break;
            case R.id.rlChatVideoCall:
                callBack.setVideoCall();
                break;
            case R.id.rlChatVoiceCall:
                callBack.setVoiceCall();
                break;
            case R.id.rlChatCancel:
//                bottomDialog.dismiss();
                dismiss();
                break;
        }
    }**/


