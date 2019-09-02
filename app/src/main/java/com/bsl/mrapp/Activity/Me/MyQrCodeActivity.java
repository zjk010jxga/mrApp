package com.bsl.mrapp.Activity.Me;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bsl.mrapp.Activity.MainActivity;
import com.bsl.mrapp.R;
import com.bsl.mrapp.base.BaseActivity;
import com.bsl.mrapp.dialog.MyQrCodeDialog;

public class MyQrCodeActivity extends BaseActivity implements View.OnClickListener,View.OnLongClickListener{
    private ImageView back,menu;
    MyQrCodeDialog myQrCodeDialog;
    private ImageView QrCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_qr_code);
        bindView();

    }
    private void bindView(){
        QrCode = findViewById(R.id.qr_code);
        back = findViewById(R.id.nav_back);
        menu = findViewById(R.id.menu);
        back.setOnClickListener(this);
        menu.setOnClickListener(this);
        QrCode.setOnLongClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.nav_back:
                finish();
                break;
            case R.id.menu:
                if (myQrCodeDialog == null){
                    MyQrCodeDialog myQrCodeDialog = new MyQrCodeDialog(MyQrCodeActivity.this,R.style.dialog);
                    myQrCodeDialog.btnShowDialog();
                }
                else {
                    myQrCodeDialog.btnShowDialog();
                }


        }
    }
    @Override
    public boolean onLongClick(View v){
        switch (v.getId()){
            case R.id.qr_code:
                startActivity(new Intent(MyQrCodeActivity.this, MainActivity.class));



        }
      return true;

    }
}
