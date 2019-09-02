package com.bsl.mrapp.Activity.Me;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bsl.mrapp.R;
import com.bsl.mrapp.dialog.LogOutDialog;

import static com.bsl.mrapp.tools.StatusBarUtil.setStatusColor;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView back;
    private LinearLayout notification,privacy,general,bindPhoneNum,changePwd,feedback,logout;
    LogOutDialog logOutDialog;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_setting);
        setStatusColor(this,true,true,0);
        bindView();
    }
    private void bindView(){
        back = findViewById(R.id.nav_back);
        notification = findViewById(R.id.ll_new_message_setting);
        privacy = findViewById(R.id.ll_privacy_setting);
        general = findViewById(R.id.ll_general);
        bindPhoneNum = findViewById(R.id.ll_mobile_phone_binding);
        changePwd = findViewById(R.id.ll_change_password);
        feedback = findViewById(R.id.ll_help_and_feedback);
        logout = findViewById(R.id.ll_log_out);
        notification.setOnClickListener(this);
        back.setOnClickListener(this);
        privacy.setOnClickListener(this);
        general.setOnClickListener(this);
        bindPhoneNum.setOnClickListener(this);
        changePwd.setOnClickListener(this);
        feedback.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nav_back:
                finish();
                break;
            case R.id.ll_new_message_setting:
                startActivity(new Intent(this,NewMessageNotificationActivity.class));
                break;
            case R.id.ll_privacy_setting:
                startActivity(new Intent(this,PrivacySettingActivity.class));
                break;
            case R.id.ll_general:
                startActivity(new Intent(this,GeneralSettingActivity.class));
                break;
            case R.id.ll_mobile_phone_binding:
                startActivity(new Intent(this,ChangeBindingPhoneNumberActivity.class));
                break;
            case R.id.ll_change_password:
                startActivity(new Intent(this,ChangePasActivity.class));
                break;
            case R.id.ll_help_and_feedback:
                startActivity(new Intent(this,HelpActivity.class));
                break;
            case R.id.ll_log_out:
                if (logOutDialog==null){
                    LogOutDialog logOutDialog = new LogOutDialog(SettingActivity.this,R.style.dialog);
                    logOutDialog.btnShowDialog();
                }else {
                    logOutDialog.btnShowDialog();
                }


        }


    }
}
