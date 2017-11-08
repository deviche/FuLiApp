package com.example.sf.demo1105a.splash;

import com.example.sf.demo1105a.BasePresenter;
import com.example.sf.demo1105a.BaseView;

/**
 * Created by sf on 2017/11/6 0006.
 */

public interface SplashContract {

    interface  View extends BaseView<Presenter> {
        void showGirl();
        void  showGirl(String url);
    }

    interface  Presenter extends BasePresenter {}
}
