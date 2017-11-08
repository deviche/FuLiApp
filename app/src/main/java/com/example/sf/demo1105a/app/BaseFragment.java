package com.example.sf.demo1105a.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sf.demo1105a.splash.SplashContract;
import com.example.sf.demo1105a.utls.LogUtils;

/**
 * Created by sf on 2017/11/6 0006.
 */

public abstract class BaseFragment extends Fragment  {
    protected BaseActivity mActivity;

    protected abstract void initView(View view, Bundle bundle);

    public BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (BaseActivity) activity;
    }

    public void addFragment(BaseFragment fragment){
        getHoldingActivity().addFragment(fragment);
    }

    // TODO: 2017/11/7 0007  注意写法
    public void removeFragment(){
        getHoldingActivity().removeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(),container,false);
        initView(view,savedInstanceState);
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected abstract  int getLayoutId() ;
}
