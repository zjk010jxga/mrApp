package com.bsl.mrapp.Activity.Lock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bsl.mrapp.R;
import com.bsl.mrapp.base.TestRxJava;

public class TestRxJavaActivity extends AppCompatActivity {
    public TestRxJava testRxJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_rx_java);
        testRxJava.createObservable();
    }
}
