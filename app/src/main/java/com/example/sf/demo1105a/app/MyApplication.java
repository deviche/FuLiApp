package com.example.sf.demo1105a.app;

import android.app.Application;
import android.os.Environment;

import com.example.sf.demo1105a.utls.LogUtils;
import com.example.sf.demo1105a.utls.TimeUtils;
import com.example.sf.demo1105a.utls.ToastUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by sf on 2017/11/5 0005.
 */

public class MyApplication extends Application implements Thread.UncaughtExceptionHandler {
    private static MyApplication myApplication;
    public static  String currentGirls = "http://ww2.sinaimg.cn/large/610dc034jw1f5k1k4azguj20u00u0421.jpg";

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        //配置显示debug 的log 信息是否显示
        LogUtils.isDebug = true;
        //配置是否显示Toast
        ToastUtils.isShow = true;

    }

    public static MyApplication getInstance() {
        return myApplication;
    }

    //处理未捕获异常
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        saveExceptionLog(t,  e);
    }

    //保存log到本地 ，后期可能更要上传服务器或者第三方bug分析收集服务
    private void saveExceptionLog(Thread t, Throwable e)  {
        String logPath = Environment.getExternalStorageDirectory()+"/log";
        try {
            File file = new File(logPath);
            if (!file.exists()){
                file.mkdirs();
            }
            File log = new File (logPath,"error.txt");
            if (!log.exists()){
                log.createNewFile();
            }
            OutputStream outputStream = new FileOutputStream(log,true);
            outputStream.write(("\n\n---------------这是分割线--------"+ TimeUtils.showNow()).getBytes());
            // TODO: 2017/11/5 0005
            //换成其他输出流试试，注意用法
            PrintStream printStream = new PrintStream(outputStream);
            e.printStackTrace(printStream);
            //注意关流和顺序
            printStream.flush();
            outputStream.flush();
            outputStream.close();
            printStream.close();

        } catch (IOException er) {
            er.printStackTrace();
        }


    }

    public  static OkHttpClient defaultokhttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3,TimeUnit.SECONDS)
                .readTimeout(3,TimeUnit.SECONDS)
                .build();
        return  okHttpClient;
    }
}
