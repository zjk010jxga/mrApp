package com.bsl.mrapp.Activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bsl.mrapp.R;
import com.bsl.mrapp.adapter.MyFragmentPagerAdapter;
import com.bsl.mrapp.adapter.TradingFragmentPagerAdapter;
import com.bsl.mrapp.base.BaseActivity;

public class TransactionDetailsActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener,View.OnClickListener{
    private RadioGroup rg_tab_bar;
    private RadioButton rbAll;
    private RadioButton rbIncome;
    private RadioButton rbSpending;
    private ViewPager pager;
    private TradingFragmentPagerAdapter mAdapter;
    private ImageView back;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_transaction_details);
        mAdapter = new TradingFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        rbAll.setSelected(true);
        back = findViewById(R.id.nav_back);
        back.setOnClickListener(this);
    }
    private void bindViews() {

        rg_tab_bar =  findViewById(R.id.rg_tab_bar);
        rbAll =  findViewById(R.id.rb_all);
        rbIncome =  findViewById(R.id.rb_income);
        rbSpending =  findViewById(R.id.rb_spending);
        rg_tab_bar.setOnCheckedChangeListener(this);

        pager = findViewById(R.id.pager);
        pager.setAdapter(mAdapter);
        pager.setCurrentItem(0);
        pager.addOnPageChangeListener(this);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int selectedId) {
        switch (selectedId) {
            case R.id.rb_all:
                pager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_income:
                pager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_spending:
                pager.setCurrentItem(PAGE_THREE);
                break;

        }
    }
    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (pager.getCurrentItem()) {
                case PAGE_ONE:
                    rbAll.setSelected(true);
                    rbSpending.setSelected(false);
                    rbIncome.setSelected(false);
                    break;
                case PAGE_TWO:
                    rbIncome.setSelected(true);
                    rbSpending.setSelected(false);
                    rbAll.setSelected(false);
                    break;
                case PAGE_THREE:
                    rbSpending.setSelected(true);
                    rbAll.setSelected(false);
                    rbIncome.setSelected(false);
                    break;

            }
        }
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.nav_back:
                finish();
                break;
        }
    }
}
