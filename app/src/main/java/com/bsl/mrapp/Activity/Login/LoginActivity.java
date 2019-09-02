package com.bsl.mrapp.Activity.Login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bsl.mrapp.Activity.MainActivity;
import com.bsl.mrapp.R;
import com.bsl.mrapp.base.BaseActivity;
import com.bsl.mrapp.tools.TextUtil;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private TextView register,accountLogin,codeBtn,account;
    private ImageView qqLogin,wxLogin,webLogin;
    private EditText InputPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_login);

        findId();
        String data = InputPhone.getText().toString();
        Intent intent= new Intent();
        intent.putExtra("num_data",data);

    }
    /**
     * 初始化
     */
    private void findId(){
        account = findViewById(R.id.account_text);
        register = findViewById(R.id.registered_text);
        accountLogin = findViewById(R.id.account_log);
        InputPhone = findViewById(R.id.phone_num);
        codeBtn = findViewById(R.id.code_btn);
        qqLogin = findViewById(R.id.qq);
        wxLogin = findViewById(R.id.wx);
        webLogin = findViewById(R.id.wb);
        register.setOnClickListener(this);
        accountLogin.setOnClickListener(this);
        codeBtn.setOnClickListener(this);
        qqLogin.setOnClickListener(this);
        wxLogin.setOnClickListener(this);
        webLogin.setOnClickListener(this);
        InputPhone.setOnClickListener(this);
        account.setOnClickListener(this);
        InputListener();



    }


    /**
     *
     * edit输入监听
     */
    private void InputListener(){
        InputPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtil.isMobileNO(s.toString())){
                    /**TextView textView;
                    int login_code2;
                    int colorWhite;
                    colorWhite = (R.color.colorWrite);
                    textView = findViewById(R.id.code_btn);
                    login_code2 =(R.drawable.login_code2);
                    textView.setBackground(getDrawable(login_code2));
                    textView.setTextColor(getResources().getColor(colorWhite);
                     **/
                    setBtnState(codeBtn,R.drawable.login_code2,R.color.colorWrite);
                }
                else {
                   /** TextView textView;
                    int login_code;
                    int color;
                    color = (R.color.colorEEEEEE);
                    textView = findViewById(R.id.code_btn);
                    login_code =(R.drawable.login_code);
                    textView.setBackground(getDrawable(login_code));
                    textView.setTextColor(getResources().getColor(color));
                    **/
                    setBtnState(codeBtn,R.drawable.login_code,R.color.colorEEEEEE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.registered_text:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            case R.id.account_log:
                startActivity(new Intent( LoginActivity.this, AccountLogActivity.class));
                break;
            case R.id.code_btn:
                String data = InputPhone.getText().toString();
                Intent intent= new Intent(LoginActivity.this,InputCodeActivity.class);
                intent.putExtra("num_data",data);
                if (TextUtil.isMobileNO(InputPhone.getText().toString())){
                startActivity(intent);}
                break;
            case R.id.qq:
                Toast.makeText(this,"QQ登录",Toast.LENGTH_SHORT).show();
                break;
            case R.id.wx:
                Toast.makeText(this,"微信登录",Toast.LENGTH_SHORT).show();
                break;
            case R.id.wb:
                Toast.makeText(this,"微博登录",Toast.LENGTH_SHORT).show();
                break;
            case R.id.account_text:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }
    }
}
