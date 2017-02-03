package com.asiainfo.recyclerview.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.asiainfo.recyclerview.R;
import com.asiainfo.recyclerview.adapter.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private SimpleAdapter mAdapter;
    private Context mContext;
    private List<String> mDatas;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initView();
        initDatas();
    }

    private void initDatas() {

        mDatas = new ArrayList<>();

        for (int i = 'A'; i <= 'Z'; i++) {
            mDatas.add("" + (char) i);
        }

        mAdapter = new SimpleAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);

        //设置recycleView的布局管理
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);

        //设置recycleView的分隔线
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mRecyclerView.setLayoutManager(manager);

    }


    private void initView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recycleview);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.Listview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;

            case R.id.Gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;

            case R.id.action_hor_gridview:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(6,StaggeredGridLayoutManager.HORIZONTAL));

                break;

            case R.id.staggerGridview:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL));

                break;

            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
