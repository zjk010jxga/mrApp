package com.bsl.mrapp.Activity.Lock;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bsl.mrapp.R;

import static com.bsl.mrapp.tools.StatusBarUtil.setStatusColor;

public class LockActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvAuthorizedLock,tvMyLock;
    private ImageView ivBack;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);
        setStatusColor(this,true,true,0);
        bindView();
    }
    private void bindView(){
        tvAuthorizedLock = findViewById(R.id.tv_authorized_lock);
        tvMyLock = findViewById(R.id.tv_myLock);
        ivBack = findViewById(R.id.nav_back);
        tvAuthorizedLock.setOnClickListener(this);
        tvMyLock.setOnClickListener(this);
        ivBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_authorized_lock:
                startActivity(new Intent(LockActivity.this,AuthorizedTheLockActivity.class));
                break;
            case R.id.nav_back:
                finish();
                break;
            case R.id.tv_myLock:
                startActivity(new Intent(LockActivity.this,MyLockActivity.class));
                break;
        }

    }
}
