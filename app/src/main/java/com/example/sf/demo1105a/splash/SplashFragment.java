package com.example.sf.demo1105a.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.sf.demo1105a.R;
import com.example.sf.demo1105a.app.ActivityManager;
import com.example.sf.demo1105a.app.BaseFragment;
import com.example.sf.demo1105a.home.HomeActivity;
import com.example.sf.demo1105a.utls.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by sf on 2017/11/7 0007.
 */

public class SplashFragment extends BaseFragment implements SplashContract.View {

    @BindView(R.id.splash)
    ImageView mSplashImg;
    private ScaleAnimation scaleAnimation;
    private Unbinder unbinder;
    private SplashPresenter splashPresenter;

    @Override
    protected void initView(View view, Bundle bundle) {
        unbinder = ButterKnife.bind(this, view);
        splashPresenter = new SplashPresenter(SplashFragment.this);
        initAnim();
    }

    private void initAnim() {
        scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, Animation.RELATIVE_TO_SELF, Animation.RELATIVE_TO_SELF);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(2000);
        mSplashImg.setImageResource(R.drawable.welcome);
        mSplashImg.startAnimation(scaleAnimation);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(getActivity(), HomeActivity.class));
                //结束当前fragment对应的splachActivity
                ActivityManager.getInstance().finishActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

    public static SplashFragment getInstance() {

        SplashFragment splashFragment = new SplashFragment();

        return splashFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_splash;
    }

    @Override
    public void showGirl() {

        Glide.with(getActivity())
                .load(R.drawable.welcome)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .animate(scaleAnimation)
                .into(mSplashImg);
    }

    @Override
    public void showGirl(String url) {
        Glide.with(getActivity())
                .load(url)
                .animate(scaleAnimation)
                .into(mSplashImg);
    }

    @Override
    public void onResume() {
        super.onResume();
        splashPresenter.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
