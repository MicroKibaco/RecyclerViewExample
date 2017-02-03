package com.asiainfo.recyclerview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.asiainfo.recyclerview.R;
import com.asiainfo.recyclerview.adapter.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

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
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //设置recycleView的布局管理
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);

        //设置recycleView的分隔线,开发过程中一般会选择自定义divier
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mRecyclerView.setLayoutManager(manager);

    }


    private void initView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recycleview);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.add:

                mAdapter.addData(1);

                break;

            case R.id.delete:

                mAdapter.deleteData(1);

                break;

            case R.id.Listview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;

            case R.id.Gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                break;

            case R.id.action_hor_gridview:
                // mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL));
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(6, StaggeredGridLayoutManager.HORIZONTAL));

                break;

            case R.id.staggerGridview:

                startActivity(new Intent(this, StaggeredGridLayoutActivity.class));

                break;

            default:
                break;

        }
        return true;
    }
}
