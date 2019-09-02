package com.bsl.mrapp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bsl.mrapp.R;

import java.io.File;
import java.io.IOException;

public class BottomDialog extends Dialog  {
    private Context context;
    public static final  int TAKE_PHOTO = 1;
    public ImageView picture;
    private Uri imageUri;
    public BottomDialog dialog;


    public BottomDialog(@NonNull Context context, int style) {
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

        View view = View.inflate(context, R.layout.dialog_change_picture, null); //获取布局视图
        view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        view.findViewById(R.id.take_photo_text).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                //创建File对象，用于存储拍照后的图片
                File outputImage = new File(context.getExternalCacheDir(),"output_image.jpg");
                try {
                    if (outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
                if(Build.VERSION.SDK_INT >= 24){
                    FileProvider.getUriForFile(context,"com.example.cameraalbumtest.fileprovider",outputImage);
                }else {
                    imageUri = Uri.fromFile(outputImage);
                }
                //启动相机程序
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                context.startActivity(intent);
                dismiss();
            }
        });
        window.setContentView(view);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);//设置横向全屏


    }
}


