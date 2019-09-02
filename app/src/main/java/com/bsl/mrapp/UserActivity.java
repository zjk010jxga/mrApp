package com.bsl.mrapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bsl.mrapp.tools.HttpUtil;
import com.bsl.mrapp.tools.SpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mUserId,mUserPhone,mCreateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        bindView();
        getUser();
        mUserId.setText(SpUtil.getString(UserActivity.this,"code"));
        mUserPhone.setText(SpUtil.getString(UserActivity.this,"msg"));

    }
    private void bindView(){
        mUserId = findViewById(R.id.tv_userId);
        mUserPhone = findViewById(R.id.tv_userPhoneNum);
        mCreateTime = findViewById(R.id.tv_createTime);
        

    }

    @Override
    public void onClick(View v) {

    }
    private void getUser(){
        String url = "https://www.bsl-ai.com/web/getuser";
        final HashMap<String,Object> map = new HashMap<>();
        map.put("token", SpUtil.getString(UserActivity.this,"token"));
        Log.d("2","Token: "+map);
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.OkHttpRequestGetUser(url, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                Log.d("this","user"+ responseText);
                try{
                   JSONObject jsonObject =new JSONObject(responseText);
                    JSONArray jsonArray = jsonObject.optJSONArray("data");
                    String code = jsonObject.optString("code");
                    String msg = jsonObject.optString("msg");
                    SpUtil.putString(UserActivity.this,"code",code);
                    SpUtil.putString(UserActivity.this,"msg",msg);
////                    for (int i = 0;i<jsonArray.length();i++){
//////                        JSONObject object = jsonArray.optJSONObject(i);
//////                        HashMap<String,Object> map = new HashMap<>();
////////                        map.put("msg",object.optString("msg"));
//////                        map.put("User_id",object.optString("User_id"));
//////                        map.put("Cellphone",object.optString("Cellphone"));
//////                        map.put("Created_at",object.optString("Create_at"));
//////
////                    }

                }catch (JSONException e){

                  e.printStackTrace();

               }

            }
        });

    }
}
