package com.bsl.mrapp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bsl.mrapp.R;



public class LogOutDialog extends Dialog {
    private Context context;

    public LogOutDialog( Context context, int style) {
        super(context,style);
        this.context = context;
        initShareDialog();
    }
    //按钮单击事件
    public void btnShowDialog() {
        showDialog();// 单击按钮后 调用显示视图的 showDialog 方法，
    }
    /**
     * 显示弹出框
     */
    private void showDialog(){
        if (this == null) {
            initShareDialog();
        }
        this.show();
    }
    /**
     * 初始化分享弹出框
     */
    private void initShareDialog() {

        this.setCanceledOnTouchOutside(true); //手指触碰到外界取消
        this.setCancelable(true);             //可取消 为true
        Window window = this.getWindow();      // 得到dialog的窗体
        window.setGravity(Gravity.CENTER);
        window.setWindowAnimations(R.style.ActionSheetDialogAnimation);

        View view = View.inflate(context, R.layout.dialog_logout, null); //获取布局视图
        view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        view.findViewById(R.id.sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }
        });
        window.setContentView(view);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);//设置横向全屏

    }
}


