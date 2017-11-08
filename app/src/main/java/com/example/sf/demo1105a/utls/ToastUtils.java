package com.example.sf.demo1105a.utls;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by sf on 2017/11/5 0005.
 */

public class ToastUtils {
    public static   boolean isShow = true;
    public static  Toast toast;
    public static  void show(Context context,String msg){
        if (isShow){
            if (toast == null){
                toast = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
            }else {
                toast.setText(msg);
                toast.setDuration(Toast.LENGTH_SHORT);
            }
            toast.show();
        }
    }

    public static  void showLong(Context context,String msg){
        if (isShow){
            if (toast == null){
                toast = Toast.makeText(context,msg,Toast.LENGTH_LONG);
            }else {
                toast.setText(msg);
                toast.setDuration(Toast.LENGTH_LONG);
            }
            toast.show();
        }
    }

    public static  void canncel(Context context,String msg){
        if (isShow&&toast != null){
           toast.cancel();
        }
    }


}
