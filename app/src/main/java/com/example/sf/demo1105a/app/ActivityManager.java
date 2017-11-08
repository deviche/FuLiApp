package com.example.sf.demo1105a.app;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * Created by sf on 2017/11/6 0006.
 */

public class ActivityManager {

    private static Stack<Activity> activityStack;
    private static ActivityManager instance;

    static {
        instance = new ActivityManager();
    }

    //私有化构造
    private ActivityManager() {
    }

    public static ActivityManager getInstance() {
        return instance;
    }

    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    //当前activity
    public Activity currentActivity() {
        if (activityStack != null) {
            Activity activity = activityStack.lastElement();
            return activity;
        }
        return null;
    }

    //结束当前activity
    public void finishActivity() {
        if (activityStack != null) {
            Activity activity = activityStack.lastElement();
            /*activity.finish();
            activity =null;*/
            finishActivity(activity);
        }
    }

    //结束指定的Activity
    public void finishActivity(Activity activity) {
        if (activityStack != null) {
            /*Activity activity = activityStack.lastElement();
            activity.finish();
            activity =null;*/
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    //结束指定字节码的Activity
    public void finishActivity(Class clazz) {
        if (activityStack != null) {
            for (Activity  activity:
                    activityStack ) {
                if (activity.getClass().equals(clazz)){
                    finishActivity(activity);
                    //加return 返回
                    return;
                }
            }
        }
    }

    //结束全部activity
    public void finishAllActivity(){
        if (activityStack !=null){


            //这里可能会出现并发修改异常
            for (int i =0,size=activityStack.size();i<size;i++){
                if (activityStack.get(i)!=null){
                    activityStack.get(i).finish();
                    /*activityStack.get(i)=null;
                    activityStack.remove(activityStack.get(i));*/
                }
            }
            /*activityStack.removeAllElements();*/
            activityStack.clear();
        }
    }

   // 退出应用程序
   // TODO: 2017/11/6 0006
    //这里处理的可能有问题 只关闭了Activity 没有处理其他组件，也没有保存日志和状态
    public  void AppExit(Context context){
        finishAllActivity();
        System.exit(0);
    }
}
