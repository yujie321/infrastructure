package com.example.infrastructure.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.infrastructure.MainActivity;
import com.example.infrastructure.R;
import com.example.infrastructure.adapter.ExamplePagerAdapter;
import com.example.infrastructure.adapter.HomeCommonNavigatorAdapter;
import com.example.infrastructure.adapter.QDListSectionAdapter;
import com.example.infrastructure.data.AlarmInfo;
import com.example.infrastructure.data.Project;
import com.example.infrastructure.data.ProjectManagement;
import com.example.infrastructure.data.SectionHeader;
import com.example.infrastructure.data.SectionItem;
import com.example.infrastructure.http.ServiceUrl;
import com.example.infrastructure.model.IHomeModel;
import com.example.toollib.base.BaseFragment;
import com.example.toollib.http.observer.BaseHttpRxObserver;
import com.example.toollib.http.util.RxUtils;
import com.qmuiteam.qmui.widget.section.QMUISection;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.dl_left)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.tl_custom)
    Toolbar toolbar;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.view_pager)
    ViewPager viewpager;
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;

    private static long DOUBLE_CLICK_TIME = 0L;
    @BindView(R.id.section_layout)
    QMUIStickySectionLayout mSectionLayout;

    private RecyclerView.LayoutManager mLayoutManager;
    private ActionBarDrawerToggle mDrawerToggle;

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
        toolbar.setTitle("");
        if (getActivity() != null){
            ((MainActivity) getActivity()).setSupportActionBar(toolbar);
            ActionBar supportActionBar = ((MainActivity) getActivity()).getSupportActionBar();
            if (supportActionBar != null){
                supportActionBar.setHomeButtonEnabled(true); //设置返回键可用
                supportActionBar.setDisplayHomeAsUpEnabled(true);
            }
        }

        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getProject();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        initTabs();
        int childCount = toolbar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            //  找到标题的View
            if (view instanceof TextView) {
                tvTitle = (TextView) view;
                // 设置居中
                tvTitle.setGravity(Gravity.CENTER);
                tvTitle.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
                break;
            }
        }
    }

    private void getProject() {
        RxUtils.getObservable(ServiceUrl.getUserApi().getProjectList(1, 30))
                .subscribe(new BaseHttpRxObserver<List<Project>>() {
                    @Override
                    protected void onSuccess(List<Project> projectList) {
                        if (projectList == null) {
                            projectList = new ArrayList<>();
                        }
                        setProject(projectList);
                    }
                });
    }
    private QDListSectionAdapter mAdapter;

    private void setProject(List<Project> projectList) {
        mLayoutManager = createLayoutManager();
        mSectionLayout.setLayoutManager(mLayoutManager);
        mAdapter = createAdapter();
        mAdapter.setCallback(new QMUIStickySectionAdapter.Callback<SectionHeader, SectionItem>() {
            @Override
            public void loadMore(QMUISection<SectionHeader, SectionItem> section, boolean loadMoreBefore) {

            }

            @Override
            public void onItemClick(QMUIStickySectionAdapter.ViewHolder holder, int position) {
                //点击
            }

            @Override
            public boolean onItemLongClick(QMUIStickySectionAdapter.ViewHolder holder, int position) {
                return false;
            }
        });
        mSectionLayout.setAdapter(mAdapter, true);
        ArrayList<QMUISection<SectionHeader, SectionItem>> list = analysisData(projectList);
        mAdapter.setData(list);
    }

    private QDListSectionAdapter createAdapter() {
        return new QDListSectionAdapter();
    }

    private RecyclerView.LayoutManager createLayoutManager() {
        return new LinearLayoutManager(getContext()) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
    }

    @NonNull
    private ArrayList<QMUISection<SectionHeader, SectionItem>> analysisData(List<Project> projectList) {
        return createSectionList(projectList);
    }

    private ArrayList<QMUISection<SectionHeader, SectionItem>> createSectionList(List<Project> projectList){
        ArrayList<QMUISection<SectionHeader, SectionItem>> list = new ArrayList<>();
        for (Project project : projectList) {
            list.add(createSection(project));
        }
        return list;
    }

    private QMUISection<SectionHeader, SectionItem> createSection(Project project) {
        SectionHeader header = new SectionHeader(project.getCompanyName());
        ArrayList<SectionItem> contents = new ArrayList<>();
        List<ProjectManagement> projectManagementList = project.getProjectManagementList();
        for (ProjectManagement projectManagement : projectManagementList) {
            contents.add(new SectionItem(projectManagement.getProjectName()));
        }
        QMUISection<SectionHeader, SectionItem> section = new QMUISection<>(header, contents, false);
        section.setExistAfterDataToLoad(false);
        return section;
    }

    private String[] title;
    private void initTabs() {
        String[] titleName = new String[]{"首页", "报警", "我的"};
        title = new String[]{"首 页", "告 警 信 息", "我 的"};
        List<String> mDataTitleName = Arrays.asList(titleName);
        //未选中
        Integer[] titleImgUnChecked = new Integer[]{R.mipmap.ic_first, R.mipmap.ic_alarm, R.mipmap.ic_mine};
        List<Integer> mDataTitleImgUnChecked = Arrays.asList(titleImgUnChecked);
        //选中
        Integer[] titleImgSelection = new Integer[]{R.mipmap.ic_first_select, R.mipmap.ic_alarm_select, R.mipmap.ic_mine_select};
        List<Integer> mDataTitleImgSelection = Arrays.asList(titleImgSelection);
        //fragment
        List<BaseFragment> fragmentList = new ArrayList<>();
        fragmentList.add(FirstFragment.newInstance());
        fragmentList.add(AlarmFragment.newInstance());
        fragmentList.add(SetFragment.newInstance());
        ExamplePagerAdapter mExamplePagerAdapter = new ExamplePagerAdapter(getChildFragmentManager(), fragmentList, mDataTitleName);
        viewpager.setAdapter(mExamplePagerAdapter);
        initMagicIndicator(mDataTitleName, mDataTitleImgUnChecked, mDataTitleImgSelection);


        tvTitle.setText(title[0]);
    }

    private void initMagicIndicator(List<String> mDataTitleName, List<Integer> mDataTitleImgUnChecked, List<Integer> mDataTitleImgSelection) {
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdjustMode(true);
        HomeCommonNavigatorAdapter homeCommonNavigatorAdapter = new HomeCommonNavigatorAdapter(
                mDataTitleName, mDataTitleImgUnChecked, mDataTitleImgSelection, viewpager);
        commonNavigator.setAdapter(homeCommonNavigatorAdapter);
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewpager);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                tvTitle.setText(title[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
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
                if ((System.currentTimeMillis() - DOUBLE_CLICK_TIME) > 2000) {
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

    @Override
    protected boolean translucentFull() {
        return true;
    }
}
