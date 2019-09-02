package com.bsl.mrapp.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bsl.mrapp.Activity.Lock.LockActivity;
import com.bsl.mrapp.Activity.Me.PersonInfoActivity;
import com.bsl.mrapp.R;
import com.bsl.mrapp.base.BaseActivity;

public class MyActivity extends BaseActivity  implements View.OnClickListener{
    private ImageView userHead,sex,qr_code;
    private TextView nick,area,address;
    private LinearLayout wallet,yunCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.fragment_me);
        bindView();
    }
    private void bindView(){
        userHead = findViewById(R.id.usr_img);
        sex= findViewById(R.id.sex);
        qr_code =findViewById(R.id.qr_code);
        nick = findViewById(R.id.nick);
        area = findViewById(R.id.area);
        address = findViewById(R.id.address);
        wallet =findViewById(R.id.mr_wallet);
        yunCode = findViewById(R.id.mr_yun_code);
        wallet.setOnClickListener(this);
        yunCode.setOnClickListener(this);


        userHead.setOnClickListener(this);
        sex.setOnClickListener(this);
        qr_code.setOnClickListener(this);
        nick.setOnClickListener(this);
        area.setOnClickListener(this);
        address.setOnClickListener(this);



    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.usr_img:
                startActivity(new Intent(MyActivity.this, PersonInfoActivity.class));
                break;
            case R.id.sex:
                startActivity(new Intent(MyActivity.this, PersonInfoActivity.class));
                break;
            case R.id.area:
                startActivity(new Intent(MyActivity.this, PersonInfoActivity.class));
                break;
            case R.id.address:
                startActivity(new Intent(MyActivity.this, PersonInfoActivity.class));
                break;
            case R.id.name:
                startActivity(new Intent(MyActivity.this, PersonInfoActivity.class));
                break;
            case R.id.mr_wallet:
                startActivity(new Intent(MyActivity.this, PersonInfoActivity.class));
                break;
            case R.id.mr_yun_code:
                startActivity(new Intent(MyActivity.this, LockActivity.class));
                break;


        }
    }
}
