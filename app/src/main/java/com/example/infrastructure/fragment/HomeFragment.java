package com.example.infrastructure.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.infrastructure.MainActivity;
import com.example.infrastructure.R;
import com.example.infrastructure.model.IHomeModel;
import com.example.toollib.base.BaseFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.ll_home_navigation_top)
    LinearLayout llHomeNavigationTop;
    @BindView(R.id.lv_left_menu)
    ListView lvLeftMenu;
    @BindView(R.id.dl_left)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.tl_custom)
    Toolbar toolbar;
    @BindView(R.id.view_pager)
    ViewPager viewpager;
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;

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
    public int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected IHomeModel initModule() {
        return null;
    }

    @Override
    public void initView() {
        //startFragment(AlarmFragment.newInstance());
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

        initTabs();
    }
    private List<BaseFragment> list;
    private void initTabs() {
        list = new ArrayList<>();
        list.add(FirstFragment.newInstance());
        list.add(AlarmFragment.newInstance());
        list.add(SetFragment.newInstance());


//        magicIndicator.setBackgroundColor(Color.BLACK);
//        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
//        commonNavigator.setAdjustMode(true);
//        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
//
//            @Override
//            public int getCount() {
//                return list.size();
//            }
//
//            @Override
//            public IPagerTitleView getTitleView(Context context, final int index) {
//                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);
//
//                // load custom layout
//                View customLayout = LayoutInflater.from(context).inflate(R.layout.simple_pager_title_layout, null);
//                final ImageView titleImg = (ImageView) customLayout.findViewById(R.id.title_img);
//                final TextView titleText = (TextView) customLayout.findViewById(R.id.title_text);
//                titleImg.setImageResource(R.mipmap.ic_launcher);
//                titleText.setText(mDataList.get(index));
//                commonPagerTitleView.setContentView(customLayout);
//
//                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {
//
//                    @Override
//                    public void onSelected(int index, int totalCount) {
//                        titleText.setTextColor(Color.WHITE);
//                    }
//
//                    @Override
//                    public void onDeselected(int index, int totalCount) {
//                        titleText.setTextColor(Color.LTGRAY);
//                    }
//
//                    @Override
//                    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
//                        titleImg.setScaleX(1.3f + (0.8f - 1.3f) * leavePercent);
//                        titleImg.setScaleY(1.3f + (0.8f - 1.3f) * leavePercent);
//                    }
//
//                    @Override
//                    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
//                        titleImg.setScaleX(0.8f + (1.3f - 0.8f) * enterPercent);
//                        titleImg.setScaleY(0.8f + (1.3f - 0.8f) * enterPercent);
//                    }
//                });
//
//                commonPagerTitleView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        mViewPager.setCurrentItem(index);
//                    }
//                });
//
//                return commonPagerTitleView;
//            }
//
//            @Override
//            public IPagerIndicator getIndicator(Context context) {
//                return null;
//            }
//        });
//        magicIndicator.setNavigator(commonNavigator);
//        ViewPagerHelper.bind(magicIndicator, mViewPager);
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
    protected String getActivityTitle() {
        return null;
    }

    @Override
    public boolean isCustomView() {
        return false;
    }
}
