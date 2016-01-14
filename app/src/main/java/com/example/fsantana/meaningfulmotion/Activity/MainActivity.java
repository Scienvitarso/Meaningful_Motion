package com.example.fsantana.meaningfulmotion.Activity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.fsantana.meaningfulmotion.Adapters.MyAdapter;
import com.example.fsantana.meaningfulmotion.Beans.Person;
import com.example.fsantana.meaningfulmotion.R;

import java.util.LinkedList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class MainActivity extends AppCompatActivity  {

    public static final String AVATAR_ID = "AVATAR_ID " + MainActivity.class.getName();
    public static final String TITLE_ID = "TITLE_ID" + MainActivity.class.getName();
    public static final String SUBTITLE_ID = "SUBTITLE_ID" + MainActivity.class.getName();

    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private List<Person> mPersonList;
    MyAdapter.LayoutType layoutType = MyAdapter.LayoutType.LIST_LAYOUT;

    private AnimatedVectorDrawable mGridToList;
    private AnimatedVectorDrawable mListToGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setAnimatedDrawable();
        setRecyclerView();
    }

    private void setAnimatedDrawable() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mListToGrid = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_list_to_grid);
            mGridToList = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_grid_to_list);
        }
    }

    private void setRecyclerView() {
        mPersonList = new LinkedList<>();
        mRecyclerView = (RecyclerView) findViewById(R.id.contatc_list_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, mPersonList);
        SlideInLeftAnimator slideInLeftAnimator = new SlideInLeftAnimator();
        slideInLeftAnimator.setAddDuration(1000);
        mRecyclerView.setItemAnimator(slideInLeftAnimator);
        mRecyclerView.setAdapter(myAdapter);
        addItem(myAdapter);
    }

    private void addItem(MyAdapter adapter) {

        adapter.addItem(new Person("Fernanda Yukari", "Batata com bacon e cheddar", R.drawable.fernanda));
        adapter.addItem(new Person("Mylena Natsumi Maeda", "Batata com bacon", R.drawable.mylena));
        adapter.addItem(new Person("Bruna Yukimy", "Batata frita", R.drawable.bruna));
    }

    private void clearItens(MyAdapter adapter) {
        adapter.clearItens();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_change_view) {
            toogleViewLayoutManager(item);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void toogleViewLayoutManager(MenuItem item) {

        MyAdapter adapterGridLayout = (MyAdapter)mRecyclerView.getAdapter();
        if(adapterGridLayout.getLayoutType() == MyAdapter.LayoutType.GRID_LAYOUT){

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                item.setIcon(mListToGrid);
                mListToGrid.start();
            }
            adapterGridLayout.setLayoutType(MyAdapter.LayoutType.LIST_LAYOUT);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                item.setIcon(mGridToList);
                mGridToList.start();
            }
            adapterGridLayout.setLayoutType(MyAdapter.LayoutType.GRID_LAYOUT);
            mRecyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(),2));
        }
    }
}
