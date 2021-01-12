package com.example.infrastructure.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.infrastructure.R;
import com.example.toollib.base.BaseFragment;
import com.example.toollib.data.IBaseModule;
import com.example.toollib.util.spf.SPUtils;
import com.example.toollib.util.spf.SpfConst;
import com.qmuiteam.qmui.layout.QMUIButton;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.infrastructure.application.InfrastructureApplication.BASE_URL;

/**
 * 设置
 */
public class SetFragment extends BaseFragment {

    @BindView(R.id.btnExit)
    QMUIButton btnExit;

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

    @OnClick({R.id.btnExit})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnExit: {
                popBackStack();
                break;
            }
        }
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_set;
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
