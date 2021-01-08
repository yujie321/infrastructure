package com.example.infrastructure.fragment;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.example.infrastructure.R;
import com.example.infrastructure.model.ISplashModel;
import com.example.infrastructure.model.impl.SplashModel;
import com.example.infrastructure.view.ISplashView;
import com.example.toollib.base.BaseFragment;

import butterknife.BindView;

/**
 * 启动过渡
 */
public class SplashFragment extends BaseFragment<ISplashModel> implements ISplashView {

    @BindView(R.id.tvVersion)
    TextView tvVersion;

    private boolean libraryExists = true;

    public static SplashFragment newInstance() {
        Bundle args = new Bundle();
        SplashFragment fragment = new SplashFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_splash;
    }

    @Override
    protected ISplashModel initModule() {
        return new SplashModel();
    }

    @Override
    public void initView() {
        startHomeFragment();
    }

    @Override
    public void startHomeFragment() {
        startFragmentAndDestroyCurrent(LoginFragment.newInstance());
    }

    @Override
    public void startActiveDeviceFragment() {
        //startFragmentAndDestroyCurrent(ActiveDeviceFragment.newInstance());
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
