package com.bsl.mrapp.Activity.Lock;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bsl.mrapp.R;
import com.bsl.mrapp.adapter.AuthorizedAdapter;
import com.bsl.mrapp.base.Authorized;
import com.bsl.mrapp.dialog.CancelAuthorizedDialog;

import java.util.ArrayList;
import java.util.List;

import static com.bsl.mrapp.tools.StatusBarUtil.setStatusColor;

public class AuthorizedTheLockActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Authorized> AuthorizedList = new ArrayList<>();
    private TextView tvAddAuthorizedLock;
    private ImageView ivBack;
    private Button btCancel;




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorized_the_lock);
        setStatusColor(this,true,true,0);
        bindView();
        initAuthorized();//初始化数据
        RecyclerView recyclerView = findViewById(R.id.rv_authorized);
        //recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置adapter
        AuthorizedAdapter adapter = new AuthorizedAdapter(AuthorizedList);
        recyclerView.setAdapter(adapter);
        // 设置item及item中控件的点击事件
        adapter.setOnItemClickListener(MyItemClickListener);
    }
    private void bindView(){
        tvAddAuthorizedLock = findViewById(R.id.tv_add_authorized_lock);
        ivBack = findViewById(R.id.nav_back);
        tvAddAuthorizedLock.setOnClickListener(this);
        ivBack.setOnClickListener(this);

    }
    private void initAuthorized(){
        for (int i = 0; i < 2; i++) {
            Authorized phoneNum = new Authorized("13767019479");
            AuthorizedList.add(phoneNum);
            Authorized phoneNum1 = new Authorized("15978451020");
            AuthorizedList.add(phoneNum1);
            Authorized phoneNum2 = new Authorized("18145206120");
            AuthorizedList.add(phoneNum2);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_add_authorized_lock:
                startActivity(new Intent(AuthorizedTheLockActivity.this,AddAuthorizedLockActivity.class));
                break;
            case R.id.nav_back:
                finish();
                break;


        }

    }
    /**
     * item+item里的空间点击监听事件
     */
    private AuthorizedAdapter.OnItemClickListener MyItemClickListener = new AuthorizedAdapter.OnItemClickListener() {
        public CancelAuthorizedDialog cancelAuthorizedDialog;
        @Override
        public void onItemClick(View v, AuthorizedAdapter.ViewName viewName, int position) {
        //viewName可区分item及item内部控件
            switch (v.getId()){
                case R.id.bt_cancel:
                    if (cancelAuthorizedDialog==null){
                        CancelAuthorizedDialog cancelAuthorizedDialog =new CancelAuthorizedDialog(AuthorizedTheLockActivity.this,R.style.dialog);
                        cancelAuthorizedDialog.btnShowDialog();
                    }else {
                        cancelAuthorizedDialog.btnShowDialog();
                    }
            }
        }

        @Override
        public void onItemLongClick(View v) {

        }
    };

}
