package com.example.sf.demo1105a.data.source;

import com.example.sf.demo1105a.data.source.local.LocalGirlDataSource;
import com.example.sf.demo1105a.data.source.remote.RemoteGirlsDataSourc;

/**
 * Created by sf on 2017/11/7 0007.
 */

public class GirlsResponsitory implements GirlsDataSource {
    private LocalGirlDataSource localGirlDataSource;
    private RemoteGirlsDataSourc remoteGirlsDataSourc;

    public GirlsResponsitory() {
        this.localGirlDataSource = new LocalGirlDataSource();
        this.remoteGirlsDataSourc = new RemoteGirlsDataSourc();
    }

    @Override
    public void getGirl(LoadGirlCallBack loadGirlCallBack) {
        remoteGirlsDataSourc.getGirl(loadGirlCallBack);
    }

    @Override
    public void getGirls(int page, int size, LoadGirlCallBack loadGirlCallBack) {
        remoteGirlsDataSourc.getGirls(page,size,loadGirlCallBack);
    }
}
