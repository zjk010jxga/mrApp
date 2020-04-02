package com.bsl.mrapp;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bsl.mrapp.Activity.MainActivity;

public class TopViewActivity extends AppCompatActivity {

    private TopView topView;
    MyBRReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_view);
        myReceiver = new MyBRReceiver();
        IntentFilter itFilter = new IntentFilter();
        itFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(myReceiver, itFilter);
        topView = (TopView) findViewById(R.id.top_view);

        topView.setOnclickLeft(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TopViewActivity.this, "点击了返回按钮", Toast.LENGTH_SHORT).show();
            }
        });
        topView.setRightTitle("设置");

        topView.setTitle("我");
    }
    //别忘了将广播取消掉哦~
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }


}
