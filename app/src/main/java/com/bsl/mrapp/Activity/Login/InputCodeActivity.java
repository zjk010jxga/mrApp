package com.bsl.mrapp.Activity.Login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.renderscript.ScriptGroup;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bsl.mrapp.R;
import com.bsl.mrapp.base.BaseActivity;

public class InputCodeActivity extends BaseActivity implements View.OnClickListener {
    private ImageView backBtn;
    private TextView phone_ifo,mobile,validation,register;
    private EditText InputCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_input_code);
        findId();
        Intent intent = getIntent();
        //获取数据
        String data = intent.getStringExtra("num_data");
        //设置数据
        StringBuilder sb = new StringBuilder(data);
        sb.replace(3, 7, "****");//取中间四位用*代替
        sb.substring(7, 11);//取后四位
        mobile.setText(sb.toString());
        Log.d("手机号",data);

    }
    private void findId(){
        backBtn = findViewById(R.id.nav_back);
        InputCode = findViewById(R.id.input_code);
        phone_ifo = findViewById(R.id.code_info);
        mobile = findViewById(R.id.number);
        validation = findViewById(R.id.validation);
        register = findViewById(R.id.registered_text);
        mobile.setOnClickListener(this);
        InputCode.setOnClickListener(this);
        backBtn.setOnClickListener(this);
        phone_ifo.setOnClickListener(this);
        validation.setOnClickListener(this);
        register.setOnClickListener(this);
        InputCode();



    }

    /**
     * edit监听
     */
    public void InputCode() {
        InputCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //text  输入框中改变前的字符串信息
                //start 输入框中改变前的字符串的起始位置
                //count 输入框中改变前后的字符串改变数量一般为0
                //after 输入框中改变后的字符串与起始位置的偏移量

            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //text  输入框中改变后的字符串信息
                //start 输入框中改变后的字符串的起始位置
                //before 输入框中改变前的字符串的位置 默认为0
                //count 输入框中改变后的一共输入字符串的数量
                if (InputCode.getText().toString().length()!= 6){
                    setBtnState(validation,R.drawable.login_code,R.color.colorEEEEEE);
                }else {

                    setBtnState(validation,R.drawable.login_code2,R.color.colorWrite);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.nav_back:
                finish();
                break;
            case R.id.registered_text:
                startActivity(new Intent(InputCodeActivity.this,RegisterActivity.class));
                break;

        }

    }

}
