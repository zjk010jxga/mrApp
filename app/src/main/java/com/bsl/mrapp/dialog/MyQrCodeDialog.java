package com.bsl.mrapp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bsl.mrapp.R;
import com.bsl.mrapp.tools.ToastCustom;

public class MyQrCodeDialog extends Dialog {
    private Context context;

    public MyQrCodeDialog(@NonNull Context context, int style) {
        super(context, style);
        this.context = context;
        initShareDialog();
    }
    //按钮 单击事件
    public void btnShowDialog() {
        showDialog();// 单击按钮后 调用显示视图的 showDialog 方法，
    }

    /**
     * 显示弹出框
     */
    private void showDialog() {
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
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.ActionSheetDialogAnimation);

        View view = View.inflate(context, R.layout.dialog_my_qr_code, null); //获取布局视图
        view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        view.findViewById(R.id.save_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastCustom.getInstance(context).show(R.string.tv_toast,ToastCustom.TIME);
                dismiss();
            }
        });
        window.setContentView(view);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);//设置横向全屏
    }
}
