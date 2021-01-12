package com.example.infrastructure.fragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.infrastructure.R;
import com.example.infrastructure.data.AlarmInfo;
import com.example.infrastructure.data.AngleData;
import com.example.infrastructure.data.GiveAnAlarmTypeEnum;
import com.example.infrastructure.data.LocationData;
import com.example.infrastructure.data.TotalData;
import com.example.infrastructure.data.WindData;
import com.example.infrastructure.http.ServiceUrl;
import com.example.toollib.base.BaseFragment;
import com.example.toollib.data.IBaseModule;
import com.example.toollib.data.base.BaseCallback;
import com.example.toollib.http.HttpResult;
import com.example.toollib.http.observer.BaseHttpZipRxObserver;
import com.example.toollib.http.util.RxUtils;
import com.example.toollib.util.AmountUtil;
import com.example.toollib.util.ToastUtil;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

/**
 * 首页
 */
public class FirstFragment extends BaseFragment {


    @BindView(R.id.layout_for_test)
    QMUILinearLayout layoutForTest;
    @BindView(R.id.linearWindSpeed)
    QMUILinearLayout linearWindSpeed;
    @BindView(R.id.layoutPull)
    QMUILinearLayout layoutPull;
    @BindView(R.id.layoutAngle)
    QMUILinearLayout layoutAngle;
    @BindView(R.id.tvAngleData)
    TextView tvAngleData;
    @BindView(R.id.ivWindLevel)
    ImageView ivWindLevel;
    @BindView(R.id.ivAngle)
    ImageView ivAngle;
    @BindView(R.id.ivPullLevel)
    ImageView ivPullLevel;
    @BindView(R.id.tvWindDirection)
    TextView tvWindDirection;
    @BindView(R.id.tvWindSpeed)
    TextView tvWindSpeed;
    @BindView(R.id.tvAlarminfo)
    TextView tvAlarminfo;
    @BindView(R.id.tvName)
    TextView tvName;

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
        layoutForTest.setRadiusAndShadow(18,
                QMUIDisplayHelper.dp2px(getContext(), 14),
                0.25f);
        linearWindSpeed.setRadiusAndShadow(18,
                QMUIDisplayHelper.dp2px(getContext(), 14),
                0.25f);
        layoutPull.setRadiusAndShadow(18,
                QMUIDisplayHelper.dp2px(getContext(), 14),
                0.25f);
        layoutAngle.setRadiusAndShadow(18,
                QMUIDisplayHelper.dp2px(getContext(), 14),
                0.25f);

        EventBus.getDefault().register(this);

        getData();
    }

    private void getData() {
        //风速风向
        Observable<HttpResult<WindData>> windZip = RxUtils.getObservableZip(
                ServiceUrl.getUserApi().getWindData().subscribeOn(Schedulers.io()));
        //倾角
        Observable<HttpResult<AngleData>> angleZip = RxUtils.getObservableZip(
                ServiceUrl.getUserApi().getAngleData().subscribeOn(Schedulers.io()));
        Observable<Object> observable = Observable.zip(windZip, angleZip, new BiFunction<HttpResult<WindData>, HttpResult<AngleData>, Object>() {
            @Override
            public Object apply(HttpResult<WindData> windDataHttpResult, HttpResult<AngleData> angleDataHttpResult) {
                TotalData totalData = new TotalData();
                totalData.setWindData(windDataHttpResult.getData());
                totalData.setAngleData(angleDataHttpResult.getData());
                return totalData;
            }
        }).compose(bindToLifecycle());
        BaseHttpZipRxObserver instance = BaseHttpZipRxObserver.getInstance();
        instance.setContext(getActivity());
        instance.httpZipObserver(observable, new BaseCallback() {
            @Override
            public void onSuccess(Object object) {
                TotalData totalData = (TotalData)object;
                setAngle(totalData.getAngleData());
                setWind(totalData.getWindData());
            }

            @Override
            public void onFail(Object obj) {
                super.onFail(obj);
                ToastUtil.showShort(obj.toString());
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvents(String msg) {
        JSONObject obj = JSON.parseObject(msg);
        Integer topic = obj.getInteger("topic");
        if (topic == 1) {
            LocationData locationData = obj.getObject("content", LocationData.class);
        } else if (topic == 2) {
            AlarmInfo alarmInfo = obj.getObject("content", AlarmInfo.class);
            setAlarmInfo(alarmInfo);
        } else if (topic == 3) {
            AngleData angleData = obj.getObject("content", AngleData.class);
            setAngle(angleData);
        } else if (topic == 4) {
            WindData windData = obj.getObject("content", WindData.class);
            setWind(windData);
        }
    }

    private void setWind(WindData windData) {
        tvWindDirection.setText(windData.getWindDirectionName());
        tvWindSpeed.setText(getString(R.string.wind_speed, String.valueOf(AmountUtil.getDoubleValue(windData.getWindSpeed() , 2))));
    }

    private void setAngle(AngleData angleData) {
        tvAngleData.setText(getString(R.string.angle_data, String.valueOf(AmountUtil.getDoubleValue(angleData.getXAngle() , 2)),
                String.valueOf(AmountUtil.getDoubleValue(angleData.getYAngle() , 2))));

    }

    private void setAlarmInfo(AlarmInfo alarmInfo) {
        tvAlarminfo.setText(alarmInfo.getSceneName());
        int giveAnAlarmId = alarmInfo.getGiveAnAlarmId();
        int giveAlarmLevel = alarmInfo.getGiveAlarmLevel();
        if(giveAnAlarmId == GiveAnAlarmTypeEnum.SPEED_DIRECTION_TYPE_ID.getId()){
            switch (giveAlarmLevel){
                case 4:
                    ivWindLevel.setImageResource(R.mipmap.ic_windlevel1);
                    break;
                case 3:
                    ivWindLevel.setImageResource(R.mipmap.ic_windlevel2);
                    break;
                case 2:
                    ivWindLevel.setImageResource(R.mipmap.ic_windlevel3);
                    break;
                case 1:
                    ivWindLevel.setImageResource(R.mipmap.ic_windlevel4);
                    break;
                default:
                    break;
            }
        } else if(giveAnAlarmId == GiveAnAlarmTypeEnum.INCLINATION_SENSOR_TYPE_ID.getId()) {
            switch (giveAlarmLevel){
                case 4:
                    ivAngle.setImageResource(R.mipmap.ic_anglelevel1);
                    break;
                case 3:
                    ivAngle.setImageResource(R.mipmap.ic_anglelevel2);
                    break;
                case 2:
                    ivAngle.setImageResource(R.mipmap.ic_anglelevel3);
                    break;
                case 1:
                    ivAngle.setImageResource(R.mipmap.ic_anglelevel4);
                    break;
                default:
                    break;
            }
        }   else if(giveAnAlarmId == GiveAnAlarmTypeEnum.PULL_DIRECTION_TYPE_ID.getId()) {
            switch (giveAlarmLevel){
                case 4:
                    ivPullLevel.setImageResource(R.mipmap.ic_pulllevel1);
                    break;
                case 3:
                    ivPullLevel.setImageResource(R.mipmap.ic_pulllevel2);
                    break;
                case 2:
                    ivPullLevel.setImageResource(R.mipmap.ic_pulllevel3);
                    break;
                case 1:
                    ivPullLevel.setImageResource(R.mipmap.ic_pulllevel4);
                    break;
                default:
                    break;
            }
        }

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
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
