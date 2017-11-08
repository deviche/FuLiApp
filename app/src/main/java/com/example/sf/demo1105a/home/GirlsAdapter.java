package com.example.sf.demo1105a.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.sf.demo1105a.data.bean.GirlsBean;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by sf on 2017/11/7 0007.
 */

public class GirlsAdapter extends RecyclerArrayAdapter<GirlsBean.ResultsEntity>{


    public GirlsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new GirlsViewHolder(parent);
    }

    @Override
    public void OnBindViewHolder(final BaseViewHolder holder, final int position) {
        super.OnBindViewHolder(holder, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onMyItemClickListener!=null){
                    onMyItemClickListener.onItemClickListener(position,holder);
                }
            }
        });
    }

    // TODO: 2017/11/7 0007 所有recyclerview 都需要自己实现条目的点击事件
    public  onMyItemClickListener onMyItemClickListener;
    public interface onMyItemClickListener{
        void onItemClickListener(int position,BaseViewHolder holder);
    }

    public void setOnMyItemClickListener(GirlsAdapter.onMyItemClickListener onMyItemClickListener) {
        this.onMyItemClickListener = onMyItemClickListener;
    }
}
