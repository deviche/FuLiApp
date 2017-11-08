package com.example.sf.demo1105a.http;

import com.example.sf.demo1105a.app.Constants;
import com.example.sf.demo1105a.app.MyApplication;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sf on 2017/11/7 0007.
 */

public class GirlSRetrfit {
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (GirlSRetrfit.class) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.GANHUO_API)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(MyApplication.defaultokhttpClient())
                        .build();
                ;
            }
            //return retrofit;
        }
        return retrofit;
    }
}
