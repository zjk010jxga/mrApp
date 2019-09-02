package com.bsl.mrapp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bsl.mrapp.R;
import com.bsl.mrapp.adapter.MyLockAdapter;
import com.bsl.mrapp.base.Lock;

import java.util.ArrayList;
import java.util.List;

public class DeleteLockDialog extends Dialog {
    public List<Lock> MyLockList = new ArrayList<>();
    public Context context;
    public DeleteLockDialog(Context context, int style) {
        super(context, style);
        this.context =context;
        initShareDialog();
    }
    public void btnShowDialog(){
        showDialog();// 单击按钮后 调用显示视图的 showDialog 方法

    }

    /**
     * 显示弹出层方法
     */
    private void  showDialog(){
        if (this ==null){
            initShareDialog();

        }
        this.show();
    }

    /**
     * 初始化弹出层
     */
    private void initShareDialog(){
        this.setCanceledOnTouchOutside(true);//手指触发外边界取消
        this.setCancelable(true);//可取消
        Window window = this.getWindow();//得到dialog窗体
        window.setGravity(Gravity.CENTER);//将dialog居中显示
        window.setWindowAnimations(R.style.ActionSheetDialogAnimation);//获取dialog弹出，消失动画
        View view = View.inflate(context, R.layout.dialog_delete_authorization, null); //获取布局视图
        view.findViewById(R.id.rb_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        view.findViewById(R.id.bt_delete).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                MyLockAdapter myLockAdapter = new MyLockAdapter(MyLockList);
                MyLockList.remove(myLockAdapter);
                myLockAdapter.notifyDataSetChanged();
                dismiss();
            }
        });



        window.setContentView(view);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);//设置横向全屏


    }
}
