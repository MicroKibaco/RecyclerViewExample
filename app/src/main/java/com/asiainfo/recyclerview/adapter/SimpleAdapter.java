package com.asiainfo.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asiainfo.recyclerview.R;

import java.util.List;

/**
 * 作者:小木箱 邮箱:yangzy3@asiainfo.com 创建时间:2017年02月03日10点59分 描述:
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> mDatas;
    private LayoutInflater mInflater;

    public SimpleAdapter(Context context, List<String> listStr) {
        this.mContext = context;
        this.mDatas = listStr;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public SimpleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_recyleview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(SimpleAdapter.MyViewHolder holder, int position) {

        holder.ItemRecycle.setText(mDatas.get(position));

    }

    @Override
    public int getItemCount() {

        return mDatas.size();

    }

    public void addData(int position) {

        mDatas.add(position, "insert One");
        notifyItemInserted(position);
    }

    public void deleteData(int position) {

        mDatas.remove(position);
        notifyItemRemoved(position);

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ItemRecycle;

        public MyViewHolder(View itemView) {
            super(itemView);
            ItemRecycle = (TextView) itemView.findViewById(R.id.id_recycle_item);
        }

    }

}

