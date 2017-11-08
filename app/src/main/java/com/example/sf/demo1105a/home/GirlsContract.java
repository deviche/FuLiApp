package com.example.sf.demo1105a.home;

import com.example.sf.demo1105a.BasePresenter;
import com.example.sf.demo1105a.BaseView;
import com.example.sf.demo1105a.data.bean.GirlsBean;

import java.util.List;

/**
 * Created by sf on 2017/11/7 0007.
 */

public interface GirlsContract {
    interface  View extends BaseView{
        // TODO: 2017/11/7 0007  接口填充数据
        void refresh(List<GirlsBean.ResultsEntity> datas);
        void load(List<GirlsBean.ResultsEntity> datas);
        void showError();
        void showNomal();
    }
    interface Presenter extends BasePresenter{
        void getGirls(int page,int size,boolean isRefresh);
    }

}
