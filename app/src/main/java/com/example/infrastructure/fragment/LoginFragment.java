package com.example.infrastructure.fragment;

import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.infrastructure.R;
import com.example.infrastructure.data.AlarmRecordVo;
import com.example.toollib.base.BaseFragment;
import com.example.toollib.data.IBaseModule;
import com.qmuiteam.qmui.layout.QMUIButton;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment implements View.OnClickListener{
    @BindView(R.id.btnLogin)
    QMUIButton btnLogin;

    public static LoginFragment newInstance() {
        
        Bundle args = new Bundle();
        
        LoginFragment fragment = new LoginFragment();
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
        return R.layout.fragment_login;
    }

    @Override
    protected String getActivityTitle() {
        return null;
    }

    @OnClick({R.id.btnLogin})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:{
                startFragment(HomeFragment.newInstance());
                break;
            }
            default:
                break;
        }
    }
}
