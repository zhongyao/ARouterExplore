package com.hongri.arouter.interceptor;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.hongri.arouter.common.Constant;

//priority越小，优先级越高，就越先执行
@Interceptor(priority = 1)
public class UseIInterceptor implements IInterceptor {

    @Override
    public void init(Context context) {
        Log.d(Constant.TAG, "UseIInterceptor 拦截器 init");
    }

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        String name = Thread.currentThread().getName();
        Log.d(Constant.TAG, "UseIInterceptor 拦截器 process:" + " 线程名称：" + name + " ---> start");
        callback.onContinue(postcard);
        Log.d(Constant.TAG, "UseIInterceptor 拦截器 process:" + " 线程名称：" + name + " ---> end");
    }

}
