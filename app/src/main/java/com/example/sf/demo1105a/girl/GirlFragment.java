package com.example.sf.demo1105a.girl;

import android.os.Bundle;
import android.view.View;

import com.example.sf.demo1105a.R;
import com.example.sf.demo1105a.app.BaseFragment;

/**
 * Created by sf on 2017/11/7 0007.
 */

public  class GirlFragment extends BaseFragment{
    @Override
    protected void initView(View view, Bundle bundle) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_girls;
    }

    public static BaseFragment getInstance (){
        GirlFragment girlFragment = new GirlFragment();
        return girlFragment;
    }
}
