package com.example.sf.demo1105a.data.source;

import com.example.sf.demo1105a.data.bean.GirlsBean;

/**
 * Created by sf on 2017/11/7 0007.
 */

public interface GirlsDataSource {
    interface  LoadGirlCallBack{
        void onGirlLoaded(GirlsBean girlsBean);
        void onDataNotAvailable();
    }
    void getGirl(LoadGirlCallBack loadGirlCallBack);
    void getGirls(int page,int size,LoadGirlCallBack loadGirlCallBack);
}
