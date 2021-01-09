package com.example.infrastructure.fragment;

import android.os.Bundle;

import com.example.infrastructure.R;
import com.example.toollib.base.BaseFragment;
import com.example.toollib.data.IBaseModule;

/**
 * 首页
 */
public class FirstFragment extends BaseFragment {

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
    }

    @Override
    protected String getActivityTitle() {
        return null;
    }

}
