package com.bsl.mrapp.tools;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bsl.mrapp.R;
import com.bsl.mrapp.adapter.AuthorizedAdapter;
import com.bsl.mrapp.base.Authorized;

import java.util.List;


public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> implements View.OnClickListener {
    private List<Authorized> mList;
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView in;


        public ViewHolder(@NonNull View view) {
            super(view);

        }
    }

    @NonNull
    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.ViewHolder viewHolder, int i) {

    }



    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onClick(View v) {

    }


}
