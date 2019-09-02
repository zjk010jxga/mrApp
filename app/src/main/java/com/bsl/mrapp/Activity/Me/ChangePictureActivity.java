package com.bsl.mrapp.Activity.Me;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bsl.mrapp.R;
import com.bsl.mrapp.base.BaseActivity;


public class ChangePictureActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout layoutText;
    private TextView cancelText;
    private static final String TAG ="ChangePictureActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.dialog_change_picture);
        bindView();
    }
    private void bindView(){
        layoutText = findViewById(R.id.layout);
        cancelText =findViewById(R.id.cancel_text);
        cancelText.setOnClickListener(this);
        layoutText.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.layout:
                Toast.makeText(this,"你点击了拍照",Toast.LENGTH_LONG).show();
                Log.d(TAG,"什么情况");
            case R.id.cancel_text:
                startActivity(new Intent(ChangePictureActivity.this,PictureActivity.class));

        }
    }
}
