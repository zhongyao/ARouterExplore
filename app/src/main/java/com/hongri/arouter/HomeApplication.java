package com.hongri.arouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class HomeApplication extends Application {
    private boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();

        if (isDebugARouter) {
            //下面两行代码必须写到init之前，否则无效
            ARouter.openLog();
            ARouter.openDebug();
        }
        //官方建议在Application中初始化
        ARouter.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //注入释放
        ARouter.getInstance().destroy();
    }
}
