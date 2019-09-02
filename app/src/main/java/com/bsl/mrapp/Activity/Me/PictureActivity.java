package com.bsl.mrapp.Activity.Me;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bsl.mrapp.R;
import com.bsl.mrapp.base.BaseActivity;
import com.bsl.mrapp.dialog.BottomDialog;

public class PictureActivity extends BaseActivity implements View.OnClickListener {
    private ImageView menu;
    private ImageView back;
    BottomDialog bottomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        bindView();
    }

    private void bindView() {
        menu = findViewById(R.id.menu);
        back = findViewById(R.id.nav_back);
        menu.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nav_back:
                finish();
                break;
            case R.id.menu:
                if (bottomDialog == null) {
                    BottomDialog bottomDialog = new BottomDialog(PictureActivity.this, R.style.dialog);
                    bottomDialog.btnShowDialog();
                } else {
                    bottomDialog.btnShowDialog();
                }
                break;
        }
    }
}