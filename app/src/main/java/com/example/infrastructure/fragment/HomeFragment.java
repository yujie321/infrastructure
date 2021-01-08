package com.example.infrastructure.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.infrastructure.MainActivity;
import com.example.infrastructure.R;
import com.example.infrastructure.data.AlarmRecordVo;
import com.example.infrastructure.model.IHomeModel;
import com.example.toollib.base.BaseListFragment;

import butterknife.BindView;

public class HomeFragment extends BaseListFragment {
    @BindView(R.id.ll_home_navigation_top)
    LinearLayout llHomeNavigationTop;
    @BindView(R.id.lv_left_menu)
    ListView lvLeftMenu;
    @BindView(R.id.dl_left)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.tl_custom)
    Toolbar toolbar;

    private static long DOUBLE_CLICK_TIME = 0L;
    private ActionBarDrawerToggle mDrawerToggle;
    private String[] lvs = {"Android", "iOS", "Python", "Html5", "Java"};
    private ArrayAdapter arrayAdapter;



    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void initView() {
        super.initView();
        startFragment(AlarmFragment.newInstance());
        toolbar.setTitle("Drawerlayout");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ff3423")); //设置标题颜色
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, lvs);
        lvLeftMenu.setAdapter(arrayAdapter);
        lvLeftMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    //返回键监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_MENU && mDrawerLayout != null) {
            if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            } else {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
            return true;
        } else if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            } else {
                if ((System.currentTimeMillis() - DOUBLE_CLICK_TIME)  > 2000) {
                    DOUBLE_CLICK_TIME = System.currentTimeMillis();
                } else {
                    //finish();
                }
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected IHomeModel initModule() {
        return null;
    }

    @Override
    protected String getActivityTitle() {
        return null;
    }

    @Override
    public boolean isCustomView() {
        return false;
    }
}
