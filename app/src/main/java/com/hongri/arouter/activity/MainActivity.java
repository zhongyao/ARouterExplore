package com.hongri.arouter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hongri.arouter.R;
import com.hongri.arouter.bean.ManualBean;

import static com.hongri.arouter.common.Constant.PATH_ACTIVITY_MAIN;
import static com.hongri.arouter.common.Constant.PATH_ACTIVITY_SIMPLE;
import static com.hongri.arouter.common.Constant.REQUEST_CODE;
import static com.hongri.arouter.common.Constant.TAG;

//在支持的路由页面添加注解
@Route(path = PATH_ACTIVITY_MAIN)
public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 1、界面传参数调整【单端传递】
                 */
//                ARouter.getInstance().
//                        build(PATH_ACTIVITY_SIMPLE).
//                        withString("name", "jack").
//                        withInt("age", 18).
//                        withParcelable("bean", new ManualBean("tom", 21)).
//                        navigation();

                //【通过Bundle传递】
                Bundle bundle = new Bundle();
                bundle.putString("name", "hongri");
                bundle.putInt("age", 20);
                bundle.putParcelable("bean", new ManualBean("tom", 22));
                ARouter.getInstance().
                        build(PATH_ACTIVITY_SIMPLE).
                        with(bundle).
                        navigation();

                /**
                 * 2、界面跳转动画
                 */
//                ARouter.getInstance().build(PATH_ACTIVITY_SIMPLE).withTransition(R.anim.slid_in_left, R.anim.slid_in_left).navigation();

                /**
                 * 3、使用URI进行跳转
                 */
                //TODO 有问题 -- 待调试
//                Uri uri = Uri.parse(URI_ACTIVITY_SIMPLE);
//                ARouter.getInstance().build(uri).navigation();

                /**
                 * 4、监听路由过程
                 */
//                ARouter.getInstance().build(PATH_ACTIVITY_SIMPLE).navigation(MainActivity.this, new NavigationCallback() {
//                    @Override
//                    public void onFound(Postcard postcard) {
//                        //路由目标被发现时调用
//                        Log.d(Constant.TAG, "onFound");
//
//                    }
//
//                    @Override
//                    public void onLost(Postcard postcard) {
//                        //路由目标被丢失时调用
//                        Log.d(Constant.TAG, "onLost");
//                    }
//
//                    @Override
//                    public void onArrival(Postcard postcard) {
//                        //路由目标到达时调用
//                        Log.d(Constant.TAG, "onArrival");
//                    }
//
//                    @Override
//                    public void onInterrupt(Postcard postcard) {
//                        //路由目标被拦截后调用
//                        Log.d(Constant.TAG, "onInterrupt");
//                    }
//                });

                /**
                 * 5、ARouter实现startActivityForResult()
                 */
//                ARouter.getInstance().
//                        build(Constant.PATH_ACTIVITY_SIMPLE).
//                        navigation(MainActivity.this, REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE:
                Log.d(TAG, "onActivityResult -- 收到了上个页面的数据：" + data);
                break;
            default:
                break;
        }
    }
}