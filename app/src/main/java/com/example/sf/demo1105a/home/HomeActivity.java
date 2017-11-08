package com.example.sf.demo1105a.home;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.sf.demo1105a.R;
import com.example.sf.demo1105a.about.AboutActivity;
import com.example.sf.demo1105a.app.ActivityManager;
import com.example.sf.demo1105a.app.AppActivity;
import com.example.sf.demo1105a.app.BaseFragment;
import com.example.sf.demo1105a.girl.GirlFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppActivity {
    private long exitTime = 0;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    @Override
    public BaseFragment getFirstFragment() {
        return GirlsFragment.getInstance();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_home;
    }

    //注意本应用中有 girls_fragment（主页） 和girl_fragment（主页点进去的详情页） 注意区分
    @Override
    protected int getFragmentContentId() {
        return R.id.girls_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
    }

    public void initView() {
        toolbar.setTitle(R.string.toolbar);
        setSupportActionBar(toolbar);

    }

    @OnClick(R.id.fab)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Uri uri = Uri.parse("mailto:18231195685@sina.cn");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(Intent.createChooser(intent, "请选择我的邮箱应用"));
                break;
            default:
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //这里为什么&&上ACTION_DOWN
        if (KeyEvent.KEYCODE_BACK == keyCode && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                //这里 snackbar 用floatingActionButton 生成？？？
                Snackbar.make(floatingActionButton, "再按一次返回键退出", Snackbar.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                // 原代码中 System.exit(0); 强制退出有问题
                //System.exit(0);
                ActivityManager.getInstance().AppExit(this);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
