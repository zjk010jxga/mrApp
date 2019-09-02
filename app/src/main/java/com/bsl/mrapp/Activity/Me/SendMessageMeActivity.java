package com.bsl.mrapp.Activity.Me;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.bsl.mrapp.R;
import com.bsl.mrapp.adapter.MyFragmentPagerAdapter;

import static com.bsl.mrapp.tools.StatusBarUtil.setStatusColor;

public class SendMessageMeActivity extends AppCompatActivity implements View.OnClickListener {
    public CheckBox cb1,cb2,cb3;
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
        setContentView(R.layout.activity_send_message_me);
        setStatusColor(this,true,true,0);
        cb1 = findViewById(R.id.cb_all);
        cb2 = findViewById(R.id.cb_focus_on);
        cb3 = findViewById(R.id.cb_close);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb1.setVisibility(View.VISIBLE);
                    cb2.setVisibility(View.INVISIBLE);
                    cb3.setVisibility(View.INVISIBLE);

                }
            }

        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cb2.setVisibility(View.VISIBLE);
                    cb1.setVisibility(View.INVISIBLE);
                    cb3.setVisibility(View.INVISIBLE);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cb3.setVisibility(View.VISIBLE);
                    cb1.setVisibility(View.INVISIBLE);
                    cb2.setVisibility(View.INVISIBLE);
                }
            }
        });

    }


    @Override
    public void onClick(View v) {


    }
}
