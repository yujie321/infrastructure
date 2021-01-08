package com.example.infrastructure.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.infrastructure.R;
import com.example.toollib.base.BaseFragment;
import com.example.toollib.data.IBaseModule;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUIViewPager;
import com.qmuiteam.qmui.widget.tab.QMUITab;
import com.qmuiteam.qmui.widget.tab.QMUITabBuilder;
import com.qmuiteam.qmui.widget.tab.QMUITabSegment;

import butterknife.BindView;
import butterknife.OnClick;

public class FirstFragment extends BaseFragment {
    @BindView(R.id.pager)
    ViewPager mViewPager;
    @BindView(R.id.tabs)
    QMUITabSegment mTabSegment;

    //private HashMap<Pager, HomeController> mPages;

    public static FirstFragment newInstance() {

        Bundle args = new Bundle();

        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected IBaseModule initModule() {
        return null;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_first;
    }

    @Override
    public void initView() {
        initTabs();
        initPagers();
    }

    private void initTabs() {

        QMUITabBuilder builder = mTabSegment.tabBuilder();
        builder.setTypeface(null, Typeface.DEFAULT_BOLD);
        builder.setSelectedIconScale(1.2f)
                .setTextSize(QMUIDisplayHelper.sp2px(getContext(), 13), QMUIDisplayHelper.sp2px(getContext(), 15))
                .setDynamicChangeIconColor(false);
        QMUITab component = builder
                .setNormalDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.icon_tabbar_component))
                .setSelectedDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.icon_tabbar_component_selected))
                .setText("Components")
                .build(getContext());
        QMUITab util = builder
                .setNormalDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.icon_tabbar_util))
                .setSelectedDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.icon_tabbar_util_selected))
                .setText("Helper")
                .build(getContext());
        QMUITab lab = builder
                .setNormalDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.icon_tabbar_lab))
                .setSelectedDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.icon_tabbar_lab_selected))
                .setText("Lab")
                .build(getContext());

        mTabSegment.addTab(component)
                .addTab(util)
                .addTab(lab);
    }

    private void initPagers() {

//        HomeController.HomeControlListener listener = new HomeController.HomeControlListener() {
//            @Override
//            public void startFragment(BaseFragment fragment) {
//                HomeFragment.this.startFragment(fragment);
//            }
//        };
//
//        mPages = new HashMap<>();
//
//        HomeController homeComponentsController = new HomeComponentsController(getActivity());
//        homeComponentsController.setHomeControlListener(listener);
//        mPages.put(Pager.COMPONENT, homeComponentsController);
//
//        HomeController homeUtilController = new HomeUtilController(getActivity());
//        homeUtilController.setHomeControlListener(listener);
//        mPages.put(Pager.UTIL, homeUtilController);
//
//        HomeController homeLabController = new HomeLabController(getActivity());
//        homeLabController.setHomeControlListener(listener);
//        mPages.put(Pager.LAB, homeLabController);
//
//        mViewPager.setAdapter(mPagerAdapter);
//        mTabSegment.setupWithViewPager(mViewPager, false);
    }

    @Override
    protected String getActivityTitle() {
        return null;
    }

    @OnClick({R.id.pager, R.id.tabs})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pager:
                break;
            case R.id.tabs:
                break;
        }
    }
}
