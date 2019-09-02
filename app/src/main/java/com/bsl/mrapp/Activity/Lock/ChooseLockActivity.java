package com.bsl.mrapp.Activity.Lock;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bsl.mrapp.R;
import com.bsl.mrapp.adapter.LockAdapter;
import com.bsl.mrapp.base.Lock;
import java.util.ArrayList;
import java.util.List;
import static com.bsl.mrapp.tools.StatusBarUtil.setStatusColor;
public class ChooseLockActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Lock> LockList = new ArrayList<>();
    private ImageView ivBack;
    public static final int LOCK_ID = 1;
    public TextView tvLockId;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_lock);
        setStatusColor(this,true,true,0);
        bindView();
        initLock();//初始化数据
        RecyclerView recyclerView = findViewById(R.id.rv_choose_lock);
        //recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置adapter
        LockAdapter adapter = new LockAdapter(LockList);
        recyclerView.setAdapter(adapter);
        // 设置item及item中控件的点击事件
        adapter.setOnItemClickListener(MyItemClickListener);

    }
    private void bindView(){

        ivBack = findViewById(R.id.nav_back);
        ivBack.setOnClickListener(this);

    }
    private void initLock(){
        for (int i=0;i<2;i++){
            Lock lockId = new Lock("AGNI2451542");//创建对象
            LockList.add(lockId);
            Lock lockId1 = new Lock("GNNI2451542");
            LockList.add(lockId1);

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nav_back:
                finish();
                break;
        }
    }
    /**
     * item+item里的空间点击监听事件
     */
    private LockAdapter.OnItemClickListener MyItemClickListener =new LockAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, LockAdapter.ViewName viewName, int position) {


            //viewName可区分item及item内部控件
            switch (v.getId()){
                case R.id.bt_choose:
                    String lockId =LockList.get(position).getLockId();
                    Intent data= new Intent();
                    data.putExtra("lock_Id",lockId);
                    setResult(2,data);
                    Log.d(String.valueOf(2),"锁编号" + lockId);
                    finish();
                    break;




            }

        }

        @Override
        public void onItemLongClick(View v) {

        }
    };

}
