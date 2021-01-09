package com.example.infrastructure.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.example.toollib.base.BaseFragment;

import java.util.List;

public class HomeTableAdapter extends PagerAdapter {

    private String[] titles;
    private List<BaseFragment> baseFragmentList;

    public HomeTableAdapter(String[] titles, List<BaseFragment> baseFragmentList) {
        this.titles = titles;
        this.baseFragmentList = baseFragmentList;
    }

    @Override
    public int getCount() {
        return baseFragmentList.size();      //页卡数
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;       //官方推荐
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        container.addView(mViewList.get(position));           //添加页卡
//        return mViewList.get(position);
        return null;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        container.removeView(mViewList.get(position));         //删除页卡
    }

    public CharSequence getPageTitle(int position){
//        return mTitleLists.get(position);             //页卡标题
        return null;
    }
}
