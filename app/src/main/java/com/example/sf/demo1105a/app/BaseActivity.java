package com.example.sf.demo1105a.app;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by sf on 2017/11/6 0006.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    //得到布局文件id
    protected abstract int getContentViewId();

    //得到布局里面fragment的id
    protected abstract int getFragmentContentId();

    // TODO: 2017/11/6 0006
    //注意特殊写法
    protected  <T extends  View> T $(int id){
        return  (T)super.findViewById(id);
    }

    @Override
    public void onClick(View v) {

    }
//添加frgament
    public  void addFragment(BaseFragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction().add(getFragmentContentId(),fragment,fragment.getClass()
                    .getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }
    //移除fragment
    public  void removeFragment(){
        if (getSupportFragmentManager().getBackStackEntryCount()>1){
            getSupportFragmentManager().popBackStack();
        }else
            finish();
    }

    //返回键事件


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (KeyEvent.KEYCODE_BACK == keyCode){
            if (getSupportFragmentManager().getBackStackEntryCount()==1){
                finish();
                return  true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
