package com.bsl.mrapp.tools;

import android.util.Log;

//只需要控制LEVEL的大小就可以控制输出的等级
public class LogUtil {
    public static final int VERBOSE = 1;//啰嗦，等级最低的
    public static final int DEBUG = 2;//调试
    public static final int INFO = 3;//信息
    public static final int WARN = 4;//警告
    public static final int ERROR = 5;//错误
    public static final int NOTHING = 6;//什么也不打印出来
    public static final int LEVEL = VERBOSE;//LEVEL:标准
    public static void v(String tag,String msg){
        if(LEVEL<=VERBOSE){//如果大于或者等于定义的标准就打印出来
            Log.v(tag, msg);
        }
    }
    public static void d(String tag,String msg){
        if(LEVEL<=DEBUG){
            Log.d(tag, msg);
        }
    }
    public static void i(String tag,String msg){
        if(LEVEL<=INFO){
            Log.i(tag, msg);
        }
    }
    public static void w(String tag,String msg){
        if(LEVEL<=WARN){
            Log.w(tag, msg);
        }
    }
    public static void e(String tag,String msg){
        if(LEVEL<=ERROR){
            Log.e(tag, msg);
        }
    }
}
