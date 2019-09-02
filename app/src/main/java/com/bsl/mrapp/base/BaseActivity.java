package com.bsl.mrapp.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bsl.mrapp.R;
import com.bsl.mrapp.tools.AppManager;

public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 设置按钮状态
     * @param textView
     * @param login_code2
     * @param colorWhite
     *
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setBtnState(TextView textView, int login_code2, int colorWhite){
        textView.setBackground(getDrawable(login_code2));
        textView.setTextColor(getResources().getColor(colorWhite));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        AppManager.getInstance().addActivity(this); //添加到栈中
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().finishActivity(this); //从栈中移除
    }

}
