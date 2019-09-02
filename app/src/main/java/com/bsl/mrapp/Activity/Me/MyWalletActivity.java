package com.bsl.mrapp.Activity.Me;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bsl.mrapp.Activity.TransactionDetailsActivity;
import com.bsl.mrapp.R;
import com.bsl.mrapp.adapter.TradingAdapter;
import com.bsl.mrapp.base.Trading;

import java.util.ArrayList;
import java.util.List;

public class MyWalletActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Trading> tradingList = new ArrayList<>();
    private LinearLayout transactionDetails;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_my_wallet);
        initTrading();//初始化数据
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        //recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TradingAdapter adapter = new TradingAdapter(tradingList);
        recyclerView.setAdapter(adapter);
        bindView();

    }
    private void initTrading(){
        for(int i = 0; i < 2; i++){
            Trading withdrawal = new Trading("提现","+200","2018-04-06 13:37:08");
            tradingList.add(withdrawal);
            Trading withdrawal2 = new Trading("提现","+200","2018-04-06 13:37:08");
            tradingList.add(withdrawal2);
            Trading withdrawal3 = new Trading("提现","+200","2018-04-06 13:37:08");
            tradingList.add(withdrawal3);
            Trading topUp = new Trading("充值","-100","2018-04-06 13:37:08");
            tradingList.add(topUp);
            Trading envelope = new Trading("红包","+100","2018-04-06 13:37:08");
            tradingList.add(envelope);
            Trading envelope2 = new Trading("红包","+50","2018-04-06 13:37:08");
            tradingList.add(envelope2);
            Trading topUp2 = new Trading("充值","-100","2018-04-06 13:37:08");
            tradingList.add(topUp2);
            Trading withdrawal5 = new Trading("提现","+200","2018-04-06 13:37:08");
            tradingList.add(withdrawal5);
            Trading envelope3 = new Trading("红包","+50","2018-04-06 13:37:08");
            tradingList.add(envelope3);
            Trading envelope4 = new Trading("红包","+50","2018-04-06 13:37:08");
            tradingList.add(envelope4);

        }
    }
    private void bindView(){
        transactionDetails = findViewById(R.id.ll_trading);
        back = findViewById(R.id.nav_back);
        transactionDetails.setOnClickListener(this);
        back.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.ll_trading:
                startActivity(new Intent(MyWalletActivity.this, TransactionDetailsActivity.class));
                break;
            case R.id.nav_back:
                finish();
                break;
        }
    }
}
