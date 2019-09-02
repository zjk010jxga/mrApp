package com.bsl.mrapp.Activity.Me;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bsl.mrapp.R;

import static com.bsl.mrapp.tools.StatusBarUtil.setStatusColor;

public class ChangeBindingPhoneNumberActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_binding_phone_number);
        setStatusColor(this,true,true,0);
    }
}
