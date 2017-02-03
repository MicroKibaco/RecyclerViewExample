package com.asiainfo.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:小木箱 邮箱:yangzy3@asiainfo.com 创建时间:2017年02月03日10点59分 描述:
 */
public class StaggeredAdapter extends SimpleAdapter {

    private Context mContext;
    private List<String> mDatas;
    private List<Integer> mHights;
    private LayoutInflater mInflater;

    public StaggeredAdapter(Context context, List<String> listStr) {
        super(context, listStr);
        this.mContext = context;
        this.mDatas = listStr;
        this.mInflater = LayoutInflater.from(context);
        mHights = new ArrayList<>();
        for (int i = 0; i < mDatas.size(); i++) {
            mHights.add((int) (100 + Math.random() * 300));
        }
    }



    @Override
    public void onBindViewHolder(StaggeredAdapter.MyViewHolder holder, int position) {

        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHights.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.ItemRecycle.setText(mDatas.get(position));
        setUpItemEvent(holder);

    }


}

