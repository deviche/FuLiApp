package com.example.sf.demo1105a.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewStub;

import com.example.sf.demo1105a.R;
import com.example.sf.demo1105a.app.BaseFragment;
import com.example.sf.demo1105a.data.bean.GirlsBean;
import com.example.sf.demo1105a.utls.LogUtils;
import com.example.sf.demo1105a.utls.ToastUtils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by sf on 2017/11/7 0007.
 */

public class GirlsFragment extends BaseFragment implements GirlsContract.View, SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnLoadMoreListener {
    public static final String TAG = "GirlsFragment";
    @BindView(R.id.girls_recyclerview)
    EasyRecyclerView easyRecyclerView;
    @BindView(R.id.network_error_layout)
    ViewStub network_errLayout;
    private Unbinder binder;
    //与network_errLayout 什么关系
    private View network_err_view;

    private GirlsAdapter girlsAdapter;
    private GirlsContract.Presenter presenter;
    private ArrayList<GirlsBean.ResultsEntity> data;
    private int page = 1;
    private int size = 20;

    @Override
    protected void initView(View view, Bundle bundle) {
        binder = ButterKnife.bind(this, view);
        presenter = new GirlsPresenter(this);
        initRecyclerview();
        //初始化网络数据
        presenter.start();
    }

    private void initRecyclerview() {

        data = new ArrayList();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        easyRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        //这里getContext 怎么运行

        girlsAdapter = new GirlsAdapter(getContext());
        easyRecyclerView.setAdapterWithProgress(girlsAdapter);
        girlsAdapter.setMore(R.layout.load_more_layout, this);
        girlsAdapter.setNoMore(R.layout.no_more_layout);
        girlsAdapter.setError(R.layout.error_layout);

        girlsAdapter.setOnMyItemClickListener(new GirlsAdapter.onMyItemClickListener() {
            @Override
            public void onItemClickListener(int position, BaseViewHolder holder) {
                ToastUtils.show(getContext(), "点击了" + position);
            }
        });

        easyRecyclerView.setRefreshListener(this);

    }

    public static GirlsFragment getInstance() {

        GirlsFragment girlsFragment = new GirlsFragment();
        return girlsFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    // TODO: 2017/11/7 0007 注意回调的写法
    @Override
    public void refresh(List<GirlsBean.ResultsEntity> datas) {
        data.clear();
        data.addAll(datas);
        girlsAdapter.clear();
        girlsAdapter.addAll(datas);
    }

    @Override
    public void load(List<GirlsBean.ResultsEntity> datas) {
        data.addAll(datas);
        girlsAdapter.addAll(datas);
    }

    @Override
    public void showError() {
        easyRecyclerView.showError();
        if (network_err_view != null) {
            network_err_view.setVisibility(View.VISIBLE);
            return;
        }
        //什么意思 前面加return 后面没有非空判断
        network_err_view = network_errLayout.inflate();
    }

    @Override
    public void showNomal() {
        if (network_err_view != null) {
            network_err_view.setVisibility(View.GONE);
        }
    }

    @Override
    public void onRefresh() {
        presenter.getGirls(1, size, true);
        //这里赋值初始化
        page = 1;
    }

    @Override
    public void onLoadMore() {
         if (data.size()%20 ==0){
             page++;
             //加载更多不是在刷新
             presenter.getGirls(page,size,false);
         }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binder.unbind();
    }
}
