package com.example.sf.demo1105a.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.sf.demo1105a.utls.LogUtils;

import java.util.List;


/**
 * Created by sf on 2017/11/6 0006.
 */

public abstract class AppActivity extends BaseActivity {
    //获取堆栈中第一个fragnment
    public abstract BaseFragment getFirstFragment();

    //获取intent 处理
    protected void handleIntent(Intent intent) {
    }

    @Override
    protected int getContentViewId() {
        return 0;
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        if (null != getIntent()) {
            handleIntent(getIntent());
        }
        //避免添加重复fragmnt
        // TODO: 2017/11/7 0007
        // 不加下面一句有问题？？fragments 非空，但是下面打印不出来什么
        //if (null == getSupportFragmentManager().getFragments()) 原来代码默认为空
        /*List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for (int i = 0; i <fragments.size() ; i++) {
            LogUtils.e(fragments.get(i).getClass().getSimpleName());
        }*/


        if (null != getSupportFragmentManager().getFragments()) {
            BaseFragment fragment = getFirstFragment();
            if (fragment != null) {
                addFragment(fragment);
            }
        }

        ActivityManager.getInstance().addActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().finishActivity(this);
    }
}
