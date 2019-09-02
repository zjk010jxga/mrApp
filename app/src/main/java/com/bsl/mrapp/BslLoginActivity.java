package com.bsl.mrapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bsl.mrapp.Activity.Login.LoginActivity;
import com.bsl.mrapp.Activity.MainActivity;
import com.bsl.mrapp.tools.HttpUtil;
import com.bsl.mrapp.tools.MyConnect;
import com.bsl.mrapp.tools.SpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class BslLoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btLogin;
    private EditText etUserName,etPassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_login);
        bindView();
    }
    private void bindView(){
        btLogin = findViewById(R.id.login);
        etUserName = findViewById(R.id.et_data_name);
        etPassWord = findViewById(R.id.et_data_paw);
        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                Login();
                break;

        }
    }
//    /**
//     * 登录接口
//     */
//    private void Login(){
//        HashMap<String,Object> map = new HashMap<>();
//        map.put("username",etUserName.getText().toString());
//        map.put("password",etPassWord.getText().toString() );
//
//
//        MyConnect.post(BslLoginActivity.this, MyConnect.URL + "/web/login", map, new MyConnect.CallBack() {
//            @Override
//            public void setSuccess(String result) {
//                try{
//                    JSONObject jsonObject = new JSONObject(result);
//                    JSONObject jsonObject2 = jsonObject.optJSONObject("data");
//                    String token = jsonObject2.optString("token");
//                    SpUtil.putString(BslLoginActivity.this,"token",token);
//                    startActivity(new Intent(BslLoginActivity.this, MainActivity.class));
//
//
//                }catch (JSONException e){
//                    e.printStackTrace();
//
//                }
//            }
//
//            @Override
//            public void setFail(int state) {
//                Message message = new Message();
//                message.what = 1;
//                message.arg1 = state;
//                handler.sendMessage(message);
//            }
//        });
//    }
//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what) {
//                case 1:
//
//                    break;
//            }
//        }
//    };
    private void Login(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    OkHttpClient client = new OkHttpClient();
//                    //构建一个requestBody对象存放待提交的参数
//                    RequestBody requestBody = new FormBody.Builder().add("username",etUserName.getText().toString()).add("password",etPassWord.getText().toString()).build();
//                    //调用post方法，将requestBody对象传入
//                    Request request = new Request.Builder().url("https://www.bsl-ai.com/web/login").post(requestBody).build();
//                    Response response = client.newCall(request).execute();
//                    String responseData = response.body().string();
//                    Log.d("this","result "+ responseData);
//
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
        HashMap<String,Object> map = new HashMap();
        map.put("username",etUserName.getText().toString());
        map.put("password",etPassWord.getText().toString());

   String Url = "https://www.bsl-ai.com/web/login";
    HttpUtil.OkHttpRequestLogin(Url,map, new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                }
            });

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            final String responseText = response.body().string();
           Log.d("this","result"+ responseText);
           try{
               JSONObject jsonObject =new JSONObject(responseText);
               JSONObject jsonObject2 = jsonObject.optJSONObject("data");
             int code = jsonObject.optInt("code");
             String msg = jsonObject.optString("msg");
               String   token = jsonObject2.optString("token");
             SpUtil.putString(BslLoginActivity.this,"token",token);
               Log.d("this","token:"+ token);

           }catch (JSONException e){
               e.printStackTrace();

           }
           runOnUiThread(new Runnable() {
               @Override
               public void run() {
                   if (!SpUtil.getString(BslLoginActivity.this, "token").equals("")){
                       Toast.makeText(BslLoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                       startActivity(new Intent(BslLoginActivity.this,UserActivity.class));

                   }else  {
                       Toast.makeText(BslLoginActivity.this,"登录失败",Toast.LENGTH_LONG).show();


                   }
               }
           });

        }
    });
    }
}
