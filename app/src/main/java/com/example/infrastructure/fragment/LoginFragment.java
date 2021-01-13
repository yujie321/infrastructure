package com.example.infrastructure.fragment;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.infrastructure.R;
import com.example.infrastructure.http.ServiceUrl;
import com.example.toollib.base.BaseFragment;
import com.example.toollib.data.IBaseModule;
import com.example.toollib.http.HttpResult;
import com.example.toollib.http.observer.BaseHttpRxObserver;
import com.example.toollib.http.util.RxUtils;
import com.example.toollib.weight.BtnToEditListenerUtils;
import com.example.toollib.weight.PasswordEditText;
import com.qmuiteam.qmui.layout.QMUIButton;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.btnLogin)
    QMUIButton btnLogin;
    @BindView(R.id.editUserNumber)
    EditText editUserNumber;
    @BindView(R.id.editUserPass)
    EditText editUserPass;

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
        BtnToEditListenerUtils.getInstance()
                .addEditView(editUserNumber)
                .addEditView(editUserPass)
                .setBtn(btnLogin)
                .build();
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
            case R.id.btnLogin: {
                String user = editUserNumber.getText().toString();
                String passwd = editUserPass.getText().toString();
                String encode = Base64.encodeToString(passwd.getBytes(), Base64.NO_WRAP);
                RxUtils.getObservable(ServiceUrl.getUserApi().login(user, encode))
                        .compose(bindToLifecycle())
                        .subscribe(new BaseHttpRxObserver<Object>(getActivity()) {
                            @Override
                            protected void onSuccess(Object object) {
                                startFragment(HomeFragment.newInstance());
                            }
                        });
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean isCustomView() {
        return false;
    }
}
