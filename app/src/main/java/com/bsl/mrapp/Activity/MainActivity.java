package com.bsl.mrapp.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.bsl.mrapp.R;
import com.bsl.mrapp.adapter.MyFragmentPagerAdapter;
import static com.bsl.mrapp.tools.StatusBarUtil.setStatusColor;


/**
 * Created by Coder-pig on 2015/8/28 0028.
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {

    //UI Objects
    private TextView txt_topbar;
    private RadioGroup rg_tab_bar;
    private RadioButton home;
    private RadioButton video;
    private RadioButton me;
    private ViewPager pager;
    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        setStatusColor(this,true,true,0);
        home.setSelected(true);
    }



    private void bindViews() {

        rg_tab_bar = findViewById(R.id.rg_tab_bar);
        home = findViewById(R.id.mr_home);
        video = findViewById(R.id.mr_video);
        me = findViewById(R.id.mr_me);
        rg_tab_bar.setOnCheckedChangeListener(this);
        pager = findViewById(R.id.pager);
        pager.setAdapter(mAdapter);
        pager.setCurrentItem(0);
        pager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int selectedId) {
        switch (selectedId) {
            case R.id.mr_home:
                pager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.mr_video:
                pager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.mr_me:
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
                    home.setSelected(true);
                    video.setSelected(false);
                    me.setSelected(false);
                    break;
                case PAGE_TWO:
                    video.setSelected(true);
                    me.setSelected(false);
                    home.setSelected(false);
                    break;
                case PAGE_THREE:
                    me.setSelected(true);
                    video.setSelected(false);
                    home.setSelected(false);
                    break;

            }
        }
    }
}
