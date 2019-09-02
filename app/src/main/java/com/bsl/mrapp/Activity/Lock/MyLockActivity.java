package com.bsl.mrapp.Activity.Lock;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bsl.mrapp.R;
import com.bsl.mrapp.adapter.MyLockAdapter;
import com.bsl.mrapp.base.Lock;
import com.bsl.mrapp.dialog.DeleteLockDialog;
import java.util.ArrayList;
import java.util.List;

import static com.bsl.mrapp.tools.StatusBarUtil.setStatusColor;

public class MyLockActivity extends AppCompatActivity implements View.OnClickListener{
    public List<Lock> MyLockList = new ArrayList<>();
    DeleteLockDialog deleteLockDialog;
    private ImageView ivBack;
    private TextView tvUpdate;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusColor(this,true,true,0);
        setContentView(R.layout.activity_my_lock);
        RecyclerView recyclerView = findViewById(R.id.rv_myLock);
        //recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置adapter
        MyLockAdapter adapter = new MyLockAdapter(MyLockList);
        recyclerView.setAdapter(adapter);
        // 设置item及item中控件的点击事件
        adapter.setOnItemClickListener(MyItemClickListener);
        bindView();
        initMyLockList();
    }
    private void bindView(){
        ivBack = findViewById(R.id.nav_back);
        tvUpdate = findViewById(R.id.tv_update_information);
        ivBack.setOnClickListener(this);
        tvUpdate.setOnClickListener(this);


    }
    private void initMyLockList(){
        Lock lockId =new Lock("BFB45215623");
        MyLockList.add(lockId);
        Lock lockId1 =new Lock("GJB45215623");
        MyLockList.add(lockId1);
    }
    /**
     * item+item里的空间点击监听事件
     */
    private MyLockAdapter.OnItemClickListener MyItemClickListener = new MyLockAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, MyLockAdapter.ViewName viewName, int position) {
            //viewName可区分item及item内部控件
            switch (v.getId()){
                case R.id.bt_delete:
                    if (deleteLockDialog==null){
                        DeleteLockDialog deleteLockDialog = new DeleteLockDialog(MyLockActivity.this,R.style.dialog);
                        deleteLockDialog.btnShowDialog();
                    }else {
                        deleteLockDialog.btnShowDialog();

                    }

            }

        }

        @Override
        public void onItemLongClick(View v) {


        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nav_back:
                finish();
                break;
        }

    }
}
