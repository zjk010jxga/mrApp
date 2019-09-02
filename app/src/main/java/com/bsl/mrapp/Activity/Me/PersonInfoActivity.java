package com.bsl.mrapp.Activity.Me;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bsl.mrapp.R;
import com.bsl.mrapp.base.BaseActivity;

import static com.bsl.mrapp.tools.StatusBarUtil.setStatusColor;

public class PersonInfoActivity extends BaseActivity implements View.OnClickListener {
    private ImageView back;
    private LinearLayout headIcon, qrCode, sex, sign, nick;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusColor(this,true,true,0);
        setContentView(R.layout.activity_person_info);

        bindView();

    }

    private void bindView() {
        back = findViewById(R.id.nav_back);
        qrCode = findViewById(R.id.qr_code);
        headIcon = findViewById(R.id.change_head);
        sex = findViewById(R.id.sex);
        sign = findViewById(R.id.name);
        nick = findViewById(R.id.signature);
        nick.setOnClickListener(this);
        sign.setOnClickListener(this);
        sex.setOnClickListener(this);
        qrCode.setOnClickListener(this);
        headIcon.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nav_back:
                finish();
                break;
            case R.id.change_head:
                startActivity(new Intent(PersonInfoActivity.this, PictureActivity.class));
                break;
            case R.id.qr_code:
                startActivity(new Intent(PersonInfoActivity.this, MyQrCodeActivity.class));
                break;
            case R.id.sex:
                startActivity(new Intent(PersonInfoActivity.this, ChangeSexActivity.class));
                break;
            case R.id.signature:
                startActivity(new Intent(PersonInfoActivity.this, ChangeSignActivity.class));
                break;
            case R.id.name:
                startActivity(new Intent(PersonInfoActivity.this, ChangeNameActivity.class));
                break;
        }

    }
}
