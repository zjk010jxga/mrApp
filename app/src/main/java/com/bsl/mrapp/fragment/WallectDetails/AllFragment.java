package com.bsl.mrapp.fragment.WallectDetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bsl.mrapp.R;
import com.bsl.mrapp.adapter.TradingAdapter;
import com.bsl.mrapp.base.Trading;

import java.util.ArrayList;
import java.util.List;

public class AllFragment extends Fragment  {
    private List<Trading> tradingList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_transaction_all,container,false);
        return rootView;

    }
    @Override
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
        initTrading();//初始化数据
        RecyclerView recyclerView =getActivity().findViewById(R.id.recycle_view);
        //recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        TradingAdapter adapter = new TradingAdapter(tradingList);
        recyclerView.setAdapter(adapter);

    }

    private void initTrading(){
        for(int i = 0; i < 2; i++){
            Trading withdrawal = new Trading("提现","+200","2018-04-06 13:37:08");
            tradingList.add(withdrawal);
            Trading withdrawal2 = new Trading("提现","+200","2018-04-06 13:37:08");
            tradingList.add(withdrawal2);
            Trading withdrawal3 = new Trading("提现","+200","2018-04-06 13:37:08");
            tradingList.add(withdrawal3);
            Trading topUp = new Trading("充值","-100","2018-04-06 13:37:08");
            tradingList.add(topUp);
            Trading envelope = new Trading("红包","+100","2018-04-06 13:37:08");
            tradingList.add(envelope);
            Trading envelope2 = new Trading("红包","+50","2018-04-06 13:37:08");
            tradingList.add(envelope2);
            Trading topUp2 = new Trading("充值","-100","2018-04-06 13:37:08");
            tradingList.add(topUp2);
            Trading withdrawal5 = new Trading("提现","+200","2018-04-06 13:37:08");
            tradingList.add(withdrawal5);
            Trading envelope3 = new Trading("红包","+50","2018-04-06 13:37:08");
            tradingList.add(envelope3);
            Trading envelope4 = new Trading("红包","+50","2018-04-06 13:37:08");
            tradingList.add(envelope4);

        }
    }
}
