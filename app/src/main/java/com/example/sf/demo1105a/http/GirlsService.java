package com.example.sf.demo1105a.http;

import com.example.sf.demo1105a.data.bean.GirlsBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by sf on 2017/11/7 0007.
 */

public interface GirlsService {
    @GET("api/data/{type}/{count}/{page}")
    Observable<GirlsBean> getGirls(
            @Path("type") String type,
            @Path("count") int count,
            @Path("page") int page
    );
}
