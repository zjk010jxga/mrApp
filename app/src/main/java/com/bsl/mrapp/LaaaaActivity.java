package com.bsl.mrapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;


public class LaaaaActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_hh)
    TextView tvTry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laaaa);
    }


    @Override
    public void onClick(View v) {
        ButterKnife.bind(this);
    }
}
