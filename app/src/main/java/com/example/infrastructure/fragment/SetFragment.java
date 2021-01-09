package com.example.infrastructure.fragment;

import android.os.Bundle;

import com.example.infrastructure.R;
import com.example.toollib.base.BaseFragment;
import com.example.toollib.data.IBaseModule;

/**
 * 设置
 */
public class SetFragment extends BaseFragment {

    public static SetFragment newInstance() {
        Bundle args = new Bundle();
        SetFragment fragment = new SetFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected IBaseModule initModule() {
        return null;
    }

    @Override
    public void initView() {

    }

    @Override
    public int getContentView() {
        return R.layout.fragment_set;
    }

    @Override
    protected String getActivityTitle() {
        return null;
    }
}
