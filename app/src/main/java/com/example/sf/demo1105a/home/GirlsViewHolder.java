package com.example.sf.demo1105a.home;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.sf.demo1105a.R;
import com.example.sf.demo1105a.data.bean.GirlsBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by sf on 2017/11/7 0007.
 */

class GirlsViewHolder extends BaseViewHolder<GirlsBean.ResultsEntity> {
    private ImageView  imageView;
    public GirlsViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_girl);
        imageView= $(R.id.girl_img);
    }

    @Override
    public void setData(GirlsBean.ResultsEntity data) {
        super.setData(data);
        //这里getContext 怎么运行
        Glide.with(getContext())
                .load(data.getUrl())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }
}
