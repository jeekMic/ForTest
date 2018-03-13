package com.czy.recyclerviewdemo;

import android.os.Bundle;
import android.view.View;

import com.czy.recyclerviewdemo.common.CommonMultiRecyclerViewActivity;
import com.czy.recyclerviewdemo.common.CommonRecyclerViewActivity;
import com.czy.recyclerviewdemo.snap.SnapRecyclerViewActivity;
import com.czy.recyclerviewdemo.wrap.WrapRecyclerViewActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		Log.i("hello"," world");
		Log.i("hello"," world from demo");
		Log.i("hello"," world from demo2");
    }

    // 绑定点击事件
    public void startCommonRecyclerView(View view) {
        startActivity(CommonRecyclerViewActivity.class);
    }

    public void startCommonMultiRecyclerView(View view) {
        startActivity(CommonMultiRecyclerViewActivity.class);
    }

    public void startWrapRecyclerView(View view) {
        startActivity(WrapRecyclerViewActivity.class);
    }

    public void startSnapRecyclerView(View view) {
        startActivity(SnapRecyclerViewActivity.class);
    }

}
