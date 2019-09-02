package com.bsl.mrapp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.bsl.mrapp.R;

public class BottomAnimDialog extends Dialog {
    private final Context mContext;
    private final String mItem1Name;
    private final String mItem2Name;
    private final String mItem3Name;
    private BottomAnimDialogListener mListener;
    private TextView mTvItem1;
    private TextView mTvItem2;
    private TextView mTvItem3;

    public BottomAnimDialog(Context context, String item1Name, String item2Name, String item3Name) {

        super(context, R.style.Dialog);
        this.mContext = context;
        this.mItem1Name = item1Name;
        this.mItem2Name = item2Name;
        this.mItem3Name = item3Name;

    initView();

}


    private void initView() {


        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_change_picture, null);



/**
        Window window = this.getWindow();
        if (window != null) { //设置dialog的布局样式 让其位于底部
            window.setGravity(Gravity.BOTTOM);
            WindowManager.LayoutParams lp = window.getAttributes();

        }**/

        mTvItem1 = view.findViewById(R.id.cancel_text);
        mTvItem2 =  view.findViewById(R.id.choose_picture_text);
        mTvItem3 =  view.findViewById(R.id.take_photo_text);

        mTvItem1.setOnClickListener(new clickListener());
        mTvItem2.setOnClickListener(new clickListener());
        mTvItem3.setOnClickListener(new clickListener());

        setContentView(view);

        setData();
    }


    private void setData() {
        mTvItem1.setText(mItem1Name);
        mTvItem2.setText(mItem2Name);
        mTvItem3.setText(mItem3Name);
    }

    public void setItem1TextColor(int colorId) {//设置item的字体颜色
        if (mTvItem1 != null) {
            mTvItem1.setTextColor(colorId);
        }
    }

    public void setItem2TextColor(int colorId) {
        if (mTvItem2 != null) {
            mTvItem2.setTextColor(colorId);
        }
    }

    public void setItem3TextColor(int colorId) {
        if (mTvItem3 != null) {
            mTvItem3.setTextColor(colorId);
        }
    }

    public void setClickListener(BottomAnimDialogListener listener) {
        this.mListener = listener;
    }

    public interface BottomAnimDialogListener {
        void onItem1Listener();

        void onItem2Listener();

        void onItem3Listener();
    }
    public void onWindowFocusChanged(boolean hasFocus) {
        if (!hasFocus) {
            dismiss();
        }
    }


    private class clickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.cancel:
                    if (mListener != null) {
                        mListener.onItem1Listener();
                    }
                    break;
                case R.id.choose_picture:
                    if (mListener != null) {
                        mListener.onItem2Listener();
                    }
                    break;
                case R.id.take_photo:
                    if (mListener != null) {
                        mListener.onItem3Listener();
                    }
                    break;
            }
        }
    }
}


