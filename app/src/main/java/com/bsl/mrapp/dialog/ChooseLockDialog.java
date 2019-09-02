package com.bsl.mrapp.dialog;
import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bsl.mrapp.R;
public class ChooseLockDialog extends Dialog {
    private Activity activity;
    public ChooseLockDialog(Activity activity,int style) {
        super(activity,style);
        this.activity = activity;
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
        View view = View.inflate(activity, R.layout.dialog_success_authorization, null); //获取布局视图
        view.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
               activity.finish();
            }
        });
        window.setContentView(view);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);//设置横向全屏


    }
}
