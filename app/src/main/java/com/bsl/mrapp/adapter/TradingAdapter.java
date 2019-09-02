package com.bsl.mrapp.adapter;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bsl.mrapp.R;
import com.bsl.mrapp.base.Trading;

import java.util.List;

public class TradingAdapter extends RecyclerView.Adapter<TradingAdapter.ViewHolder> {
    private List<Trading> mTradingList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tradingType;
        TextView tradingNum;
        TextView tradingTime;
        public ViewHolder(View view){
            super(view);
            tradingType = view.findViewById(R.id.from_type);
            tradingNum  = view.findViewById(R.id.num);
            tradingTime = view.findViewById(R.id.time);
        }
    }
    public TradingAdapter(List<Trading> TradingList){

        mTradingList = TradingList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycel,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Trading trading = mTradingList.get(position);
        holder.tradingType.setText(trading.getType());
        holder.tradingNum.setText(trading.getNum());
        holder.tradingTime.setText(trading.getTime());
        if (trading.getType().equals("提现") ){
            holder.tradingNum.setTextColor(Color.parseColor("#00C984"));
        }
        else if (trading.getType().equals("充值")){
            holder.tradingNum.setTextColor(Color.parseColor("#FF4343"));
        }
        else if(trading.getType().equals("红包") && trading.getNum().contains("+")){
            holder.tradingNum.setTextColor(Color.parseColor("#00C984"));
        }
        else if(trading.getType().equals("红包") && trading.getNum().contains("-")){
            holder.tradingNum.setTextColor(Color.parseColor("#FF4343"));
        }
    }

    @Override
    public int getItemCount() {
        return mTradingList.size();
    }

}
