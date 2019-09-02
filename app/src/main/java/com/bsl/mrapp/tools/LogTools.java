package com.bsl.mrapp.tools;

import android.util.Log;

/**
 * Created by lsl on 2017/12/19 0019.
 * 日志打印工具
 */

public class LogTools {
  public static String TAG = "HslIntelligenceLock";
  public static boolean is_log=true;//日志开关

  public static void e(String tag,String s){
    if(is_log){
      Log.e(tag,s);
    }
  }
  public static void i(String tag,String s){
    if(is_log){
      Log.i(tag,s);
    }
  }
  public static void d(String tag,String s){
    if(is_log){
      Log.d(tag,s);
    }
  }
  public static void w(String tag,String s){
    if(is_log){
      Log.w(tag,s);
    }
  }
}
