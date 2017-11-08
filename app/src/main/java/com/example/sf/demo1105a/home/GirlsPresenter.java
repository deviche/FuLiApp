package com.example.sf.demo1105a.home;

import com.example.sf.demo1105a.data.bean.GirlsBean;
import com.example.sf.demo1105a.data.source.GirlsDataSource;
import com.example.sf.demo1105a.data.source.GirlsResponsitory;
import com.example.sf.demo1105a.home.GirlsContract;
import com.example.sf.demo1105a.utls.LogUtils;

/**
 * Created by sf on 2017/11/7 0007.
 */

public class GirlsPresenter implements GirlsContract.Presenter {
    public static final String TAG = "GirlsPresenter";
    private GirlsContract.View view;
    private GirlsResponsitory girlsResponsitory;

    public GirlsPresenter(GirlsContract.View view) {
        this.view = view;
        girlsResponsitory = new GirlsResponsitory();
    }

    @Override
    public void start() {

        getGirls(1, 20, true);
    }

    @Override
    public void getGirls(int page, int size, final boolean isRefresh) {
        girlsResponsitory.getGirls(page, size, new GirlsDataSource.LoadGirlCallBack() {

            @Override
            public void onGirlLoaded(GirlsBean girlsBean) {
                if (isRefresh) {
                    view.refresh(girlsBean.getResults());
                } else {
                    view.load(girlsBean.getResults());
                }
                view.showNomal();
            }

            @Override
            public void onDataNotAvailable() {
                //这里需要判断？
                if (isRefresh){
                    view.showError();
                }
            }
        });
    }
}
