package com.bsl.mrapp.tools;
import android.app.Activity;
import java.util.HashMap;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {
    public Activity activity;
    /**
     * OkHttp通过Get请求访问Url
     * @param address
     * @param callback
     */
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);

    }


    /**
     * OkHttp通过Post请求访问Url
     */
    public static void OkHttpRequestLogin(String address, HashMap<String,Object> map,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        //构建一个requestBody对象存放待提交的参数
        RequestBody requestBody = new FormBody.Builder().add("username", "bsl").add("password", "bsl654321").build();
        //调用post方法，将requestBody对象传入
        Request request = new Request.Builder().url(address).post(requestBody).build();
        client.newCall(request).enqueue(callback);
    }
    public  void OkHttpRequestGetUser(String address, HashMap<String,Object> map,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        //构建一个requestBody对象存放待提交的参数
        RequestBody requestBody = new FormBody.Builder().add("token",SpUtil.getString(activity,"token")).build();
        //调用post方法，将requestBody对象传入
        Request request = new Request.Builder().url(address).post(requestBody).build();
        client.newCall(request).enqueue(callback);
    }
}
