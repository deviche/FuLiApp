package com.example.sf.demo1105a.data.source.remote;

import com.example.sf.demo1105a.data.bean.GirlsBean;
import com.example.sf.demo1105a.data.source.GirlsDataSource;
import com.example.sf.demo1105a.http.GirlSRetrfit;
import com.example.sf.demo1105a.http.GirlsService;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sf on 2017/11/7 0007.
 */

public class RemoteGirlsDataSourc implements GirlsDataSource {
    @Override
    public void getGirl(LoadGirlCallBack loadGirlCallBack) {
        getGirls(1, 1, loadGirlCallBack);
    }

    @Override
    public void getGirls(int page, int size, final LoadGirlCallBack loadGirlCallBack) {
        // TODO: 2017/11/7 0007  网络请求数据
        GirlSRetrfit.getRetrofit()
                .create(GirlsService.class)
                .getGirls("福利", size, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GirlsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        loadGirlCallBack.onDataNotAvailable();
                    }

                    @Override
                    public void onNext(GirlsBean girlsBean) {
                        loadGirlCallBack.onGirlLoaded(girlsBean);
                    }
                });

    }
}
