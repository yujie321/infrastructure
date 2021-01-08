package com.example.infrastructure.fragment;

import android.os.Bundle;

import com.example.infrastructure.R;
import com.example.toollib.base.BaseFragment;
import com.example.toollib.data.IBaseModule;

public class RecordDetailFragment extends BaseFragment {
    public static RecordDetailFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RecordDetailFragment fragment = new RecordDetailFragment();
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
        return R.layout.fragment_record_detail;
    }

    @Override
    protected String getActivityTitle() {
        return null;
    }
}
