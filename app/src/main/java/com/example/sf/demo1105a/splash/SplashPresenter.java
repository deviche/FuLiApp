package com.example.sf.demo1105a.splash;

import com.example.sf.demo1105a.app.MyApplication;
import com.example.sf.demo1105a.data.bean.GirlsBean;
import com.example.sf.demo1105a.data.source.GirlsDataSource;
import com.example.sf.demo1105a.data.source.GirlsResponsitory;
import com.example.sf.demo1105a.utls.LogUtils;

/**
 * Created by sf on 2017/11/7 0007.
 */

public class SplashPresenter implements SplashContract.Presenter {
    private SplashContract.View view;
    private GirlsResponsitory girlsResponsitory;

    public SplashPresenter(SplashContract.View view) {
        this.view = view;
        this.girlsResponsitory = new GirlsResponsitory();
    }

    @Override
    public void start() {

        girlsResponsitory.getGirl(new GirlsDataSource.LoadGirlCallBack() {
            @Override
            public void onGirlLoaded(GirlsBean girlsBean) {
                // TODO: 2017/11/7 0007  显示
                view.showGirl(girlsBean.getResults().get(0).getUrl());
                MyApplication.currentGirls = girlsBean
                        .getResults().get(0).getUrl();

            }

            @Override
            public void onDataNotAvailable() {
                view.showGirl();
            }
        });
    }
}
