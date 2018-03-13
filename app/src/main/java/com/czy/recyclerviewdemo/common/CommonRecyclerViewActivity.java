package com.czy.recyclerviewdemo.common;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.czy.library.common.CommonRecyclerViewHolder;
import com.czy.library.decoration.CommonItemDecoration;
import com.czy.recyclerviewdemo.BaseActivity;
import com.czy.recyclerviewdemo.R;
import com.czy.recyclerviewdemo.adapter.NewCommonAdapter;
import com.czy.recyclerviewdemo.model.New;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 作者：叶应是叶
 * 时间：2017/12/21 22:02
 * 说明：单布局
 */
public class CommonRecyclerViewActivity extends BaseActivity {

    private List<New> newList;

    private NewCommonAdapter newCommonAdapter;

    private int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_recycler_view);
        initData();//初始化数据

        RecyclerView rv_commonDataList = (RecyclerView) findViewById(R.id.rv_commonDataList);

        rv_commonDataList.setLayoutManager(new LinearLayoutManager(this));
        //如果需要水平的，则选择下面的setlayoutManager
        //rv_commonDataList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        // 如果是表格的形式 这位下面这种，后面的3表示3列
        //rv_commonDataList.setLayoutManager(new GridLayoutManager(this,3));

        newCommonAdapter = new NewCommonAdapter(this, newList);
        newCommonAdapter.setClickListener(new CommonRecyclerViewHolder.OnClickListener() {
            @Override
            public void onClick(int position) {
                toast("点击" + "\n" + newList.get(position).getTitle() + "\n" + newList.get(position).getContent());
            }
        });
        newCommonAdapter.setLongClickListener(new CommonRecyclerViewHolder.OnLongClickListener() {
            @Override
            public void onLongClick(int position) {
                toast("长按" + "\n" + newList.get(position).getTitle() + "\n" + newList.get(position).getContent());
            }
        });
        rv_commonDataList.setAdapter(newCommonAdapter);
        CommonItemDecoration commonItemDecoration = new CommonItemDecoration(ContextCompat.getDrawable(this, R.drawable.divider), LinearLayoutManager.VERTICAL);

        rv_commonDataList.addItemDecoration(commonItemDecoration);
    }

    private void initData() {
        newList = new ArrayList<>();
        newList.add(new New(index++, "AHi", "你来自哪里"));
        newList.add(new New(index++, "B叶应是叶", "好久不见"));
        newList.add(new New(index++, "F叶", "该下班了吧"));
        newList.add(new New(index++, "EYe", "真是好玩啊"));
        newList.add(new New(index++, "CleavesC", "不知火舞"));
        newList.add(new New(index++, "Clove", "我爱你"));
        newList.add(new New(index++, "D你好啊", "来来来"));
        newList.add(new New(index++, "ZleavesC", "咩咩咩咩喵喵喵喵"));
        newList.add(new New(index++, "H嗨", "我呜呜呜呜"));
        newList.add(new New(index++, "O天空之城", "很好听的歌啊"));
        sort();
    }

    // Collections.sort(List, new Compareator()) 用来对集合里面的数据进行排列，根据自己的规则
    private void sort() {
        Collections.sort(newList, new Comparator<New>() {
            @Override
            public int compare(New o1, New o2) {
                Log.i(""+o1.getTitle().charAt(0),"--"+o2.getTitle().charAt(0));
                // 大于0表示正序, 小于0表示逆序
                if (o1.getTitle().charAt(0) == o2.getTitle().charAt(0)) {
                    return 0;
                }
                return o1.getTitle().charAt(0) - o2.getTitle().charAt(0);
            }
        });
    }

    public void addData(View view) {
        newList.add(0, new New(index++, "叶应是叶 " + index, "leavesC"));
        sort();
        newCommonAdapter.setData(newList);
    }

    public void removeData(View view) {
        if (newList.size() > 0) {
            newList.remove(0);
            sort();
            newCommonAdapter.setData(newList);
        }
    }

    public void exchangeData(View view) {
        if (newList.size() >= 4) {
            New project0 = newList.get(0);
            New project1 = newList.get(1);
            New project2 = newList.get(3);
            newList.remove(project0);
            newList.remove(project1);
            newList.remove(project2);
            newList.add(0, project2);
            newList.add(0, project1);
            newList.add(0, project0);
            sort();
            newCommonAdapter.setData(newList);
        }
    }

    public void alterData(View view) {
        if (newList.size() > 0) {
            newList.get(0).setTitle("hi " + index++);
            sort();
            newCommonAdapter.setData(newList);
        }
    }

}
