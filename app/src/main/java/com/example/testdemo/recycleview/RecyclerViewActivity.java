package com.example.testdemo.recycleview;

import android.app.Activity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.testdemo.R;
import com.example.testdemo.recycleview.GridSpacingItemDecoration;
import com.example.testdemo.recycleview.MyAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends Activity implements MyAdapter.OnItemClickListener, MyAdapter.OnItemLongClickListener{

    private RecyclerView mRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView(),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
    }

    private MyAdapter adapter;

    private View getContentView() {
        //step1 Get reference or define to your RecyclerView
        mRecycleView = new RecyclerView(this);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecycleView.setLayoutManager(layoutManager);

        //step2 Create an Adapter and add it
        adapter = new MyAdapter(getData());
        mRecycleView.setAdapter(adapter);

        //step 3 Create zero or more ItemDecorations as needed and add them
        mRecycleView.addItemDecoration(new GridSpacingItemDecoration(2,10,true));

        //step 4 Create an ItemAnimator if needed and add it
        mRecycleView.setItemAnimator(new DefaultItemAnimator());

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        mRecycleView.setHasFixedSize(true);

        //step 5 Create zero or more listeners as needed and add them
        mRecycleView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener(){
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                super.onTouchEvent(rv, e);
            }
        });
        adapter.setOnItemClickListener(this);
        return mRecycleView;
    }

    List<Integer> resIds;

    private List<Integer> getData() {
        resIds = new ArrayList<>();
        resIds.add(R.drawable.meizhi001);
        resIds.add(R.drawable.meizhi002);
        resIds.add(R.drawable.meizhi003);
        resIds.add(R.drawable.meizhi004);
        resIds.add(R.drawable.meizhi005);
        resIds.add(R.drawable.meizhi006);
        resIds.add(R.drawable.meizhi007);
        resIds.add(R.drawable.meizhi008);
        resIds.add(R.drawable.meizhi009);
        resIds.add(R.drawable.meizhi010);
        resIds.add(R.drawable.meizhi011);
        resIds.add(R.drawable.meizhi012);
        resIds.add(R.drawable.meizhi013);
        resIds.add(R.drawable.meizhi014);
        resIds.add(R.drawable.meizhi015);
        return resIds;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_recylerview,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.add:
//                resIds.add(0,resIds.get(new Random().nextInt(resIds.size())));
//                adapter.notifyItemInserted(0);
//                break;
//            case R.id.del:
//                resIds.remove(0);
//                adapter.notifyItemRemoved(0);
//                break;
//            case R.id.resort:
//                Collections.shuffle(resIds);
//                adapter.notifyItemRangeChanged(0,adapter.getItemCount());
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onClick(RecyclerView.ViewHolder VH, int position) {
        Toast.makeText(this,"click position:" + position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongClick(RecyclerView.ViewHolder VH, int position) {
        Toast.makeText(this,"longClick position:" + position,Toast.LENGTH_SHORT).show();
    }
}