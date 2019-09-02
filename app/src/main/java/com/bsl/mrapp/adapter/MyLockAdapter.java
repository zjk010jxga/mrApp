package com.bsl.mrapp.adapter;




import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bsl.mrapp.Activity.Lock.AuthorizedTheLockActivity;
import com.bsl.mrapp.Activity.Lock.MyLockActivity;
import com.bsl.mrapp.R;
import com.bsl.mrapp.base.Authorized;
import com.bsl.mrapp.base.Lock;
import com.bsl.mrapp.dialog.CancelAuthorizedDialog;
import com.bsl.mrapp.dialog.DeleteLockDialog;

import java.util.List;

public class MyLockAdapter extends RecyclerView.Adapter<MyLockAdapter.ViewHolder> implements View.OnClickListener {
    private List<Lock> mMyLockList;//数据源
    public Context context;//联系上下文





    /**
     * 创建一个ViewHolder继承 RecyclerView.ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private  ImageView iv;
        private  Button bt;
        private  TextView lockId;
        public ViewHolder(View view) {
            super(view);
            iv = view.findViewById(R.id.iv_lock);
            lockId = view.findViewById(R.id.tv_lock_id);
            bt = view.findViewById(R.id.bt_delete);
            bt.setOnClickListener(MyLockAdapter.this);
        }
    }
    public MyLockAdapter (List<Lock> LockList){
        mMyLockList = LockList;
    }
    @NonNull
    @Override
    public MyLockAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_lock,parent,false);
        MyLockAdapter.ViewHolder holder = new MyLockAdapter.ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Lock lock = mMyLockList.get(position);
        holder.lockId.setText(lock.getLockId());
        holder.bt.setTag(position);







    }
    //item里面有多个控件可以点击（item+item内部控件）
    public enum ViewName {
        ITEM,
        PRACTISE
    }
    //自定义一个回调接口来实现Click和LongClick事件
    public interface OnItemClickListener  {
        void onItemClick(View v, ViewName viewName, int position);
        void onItemLongClick(View v);
    }

    private OnItemClickListener mOnItemClickListener;//声明自定义的接口

    //定义方法并传给外面的使用者
    public void setOnItemClickListener(OnItemClickListener  listener) {
        this.mOnItemClickListener  = listener;
    }



    @Override
    public int getItemCount() {
        return mMyLockList.size();
    }
    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();   //getTag()获取数据
        if(mOnItemClickListener != null){
            switch (v.getId()){
                case R.id.rv_authorized:
                    mOnItemClickListener.onItemClick(v,ViewName.PRACTISE,position);
                    break;
                default:
                    mOnItemClickListener.onItemClick(v,ViewName.ITEM,position);
                    break;

            }
        }

    }
}



