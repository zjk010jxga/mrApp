package com.bsl.mrapp.Activity.Login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bsl.mrapp.R;

public class AccountLogActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView forgetAccount;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_account_log);
        findId();
    }
    private void findId(){
        forgetAccount = findViewById(R.id.forget_account);
        backBtn = findViewById(R.id.nav_back);
        forgetAccount.setOnClickListener(this);
        backBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.forget_account:
                startActivity(new Intent(AccountLogActivity.this, FindAccountActivity.class));
                break;
            case R.id.nav_back:
                finish();
                break;
        }
    }
}
