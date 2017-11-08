package com.example.sf.demo1105a.splash;

import android.view.View;

import com.example.sf.demo1105a.R;
import com.example.sf.demo1105a.app.AppActivity;
import com.example.sf.demo1105a.app.BaseFragment;
import com.example.sf.demo1105a.utls.LogUtils;

/**
 * Created by sf on 2017/11/5 0005.
 */

public class SplashActivity extends AppActivity {
    @Override
    public BaseFragment getFirstFragment() {
        return SplashFragment.getInstance();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.splash_fragment;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }
}
