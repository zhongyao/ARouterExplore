package com.hongri.arouter;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

public class HomeApplication extends Application {
    private static final String TAG = "HomeApplication";
    private boolean isDebugARouter = true;
    private long beginTime, endTime;

    @Override
    public void onCreate() {
        super.onCreate();

        if (isDebugARouter) {
            //下面两行代码必须写到init之前，否则无效
            ARouter.openLog();
            ARouter.openDebug();
        }

        beginTime = System.currentTimeMillis();
        //官方建议在Application中初始化
        ARouter.init(this);
        endTime = System.currentTimeMillis();
        Log.d(TAG, "ARouter--init--spendTime:" + (endTime - beginTime));
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //注入释放
        ARouter.getInstance().destroy();
    }
}
