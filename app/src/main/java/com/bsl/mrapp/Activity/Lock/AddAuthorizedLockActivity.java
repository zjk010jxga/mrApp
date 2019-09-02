package com.bsl.mrapp.Activity.Lock;

import android.content.Intent;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bsl.mrapp.R;
import com.bsl.mrapp.adapter.LockAdapter;
import com.bsl.mrapp.base.BaseActivity;
import com.bsl.mrapp.dialog.BottomDialog;
import com.bsl.mrapp.dialog.CancelAuthorizedDialog;
import com.bsl.mrapp.dialog.ChooseLockDialog;
import com.bsl.mrapp.tools.TextUtil;

import static com.bsl.mrapp.Activity.Lock.ChooseLockActivity.LOCK_ID;
import static com.bsl.mrapp.tools.StatusBarUtil.setStatusColor;

public class AddAuthorizedLockActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private LinearLayout llChooseLock;
    private EditText etPhoneNum;
    private Button btSure;
    private TextView tvLockId;
    ChooseLockDialog chooseLockDialog;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_authorized_lock);
        setStatusColor(this,true,true,0);
        bindView();

    }
    private void bindView(){
        ivBack = findViewById(R.id.nav_back);
        llChooseLock = findViewById(R.id.ll_choose_lock);
        etPhoneNum = findViewById(R.id.et_phone_num);
        btSure = findViewById(R.id.bt_sure);
        tvLockId = findViewById(R.id.tv_lock_id);
        llChooseLock.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        etPhoneNum.setOnClickListener(this);
        btSure.setOnClickListener(this);
        InputListener();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nav_back:
                finish();
                break;
            case R.id.ll_choose_lock:
                Intent intent = new Intent(AddAuthorizedLockActivity.this,ChooseLockActivity.class);
                startActivityForResult(intent,LOCK_ID);
                break;
            case R.id.bt_sure:
                if (TextUtil.isMobileNO(etPhoneNum.getText().toString())&&(!tvLockId.getText().toString().equals(""))){
                    if (chooseLockDialog==null){
                        ChooseLockDialog chooseLockDialog = new ChooseLockDialog(this,R.style.dialog);
                        chooseLockDialog.btnShowDialog();
                    }else
                        chooseLockDialog.btnShowDialog();


                }

        }


    }

    /**
     * 输入监听edit
     */
    private void InputListener(){
        etPhoneNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtil.isMobileNO(s.toString())&&(!tvLockId.getText().toString().equals(""))){
                    /**TextView textView;
                     int login_code2;
                     int colorWhite;
                     colorWhite = (R.color.colorWrite);
                     textView = findViewById(R.id.code_btn);
                     login_code2 =(R.drawable.login_code2);
                     textView.setBackground(getDrawable(login_code2));
                     textView.setTextColor(getResources().getColor(colorWhite);
                     **/
                    setBtnState(btSure,R.drawable.login_code2,R.color.colorWrite);
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
                    setBtnState(btSure,R.drawable.login_code,R.color.colorEEEEEE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

            //首先要判断有没有返回成功，然后再根据requestcode来判断是来自那个activiry
            //然后用requestcode判断是来自哪个activity
                String lockId = data.getStringExtra("lock_Id");
                //设置数据
                tvLockId.setText(lockId);
            Log.d("2","获取的锁编号"+ lockId);



    }
}
