package com.bsl.mrapp.Activity.Me;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bsl.mrapp.R;
import com.bsl.mrapp.base.BaseActivity;

public class ChangeNameActivity extends BaseActivity implements View.OnClickListener {
    private ImageView back;
    private TextView done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_change_name);
        bindView();
    }
    private void bindView(){
        back = findViewById(R.id.nav_back);
        done = findViewById(R.id.done);
        back.setOnClickListener(this);
        done.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.nav_back:
                finish();
                break;
            case R.id.done:


        }
    }
}
