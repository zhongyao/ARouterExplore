package com.hongri.arouter.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hongri.arouter.R;
import com.hongri.arouter.bean.ManualBean;
import com.hongri.arouter.common.Constant;
import com.hongri.arouter.fragment.SimpleDialogFragment;

import static com.hongri.arouter.common.Constant.PATH_ACTIVITY_SIMPLE;
import static com.hongri.arouter.common.Constant.PATH_FRAGMENT_SIMPLE;

//在支持的路由页面添加注解
@Route(path = PATH_ACTIVITY_SIMPLE)
public class SimpleActivity extends BaseActivity {

    private TextView textView;
    private Button showFragment;
    @Autowired(name = "name")
    String name;

    @Autowired(name = "age")
    int age;

    @Autowired(name = "bean")
    ManualBean manualBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        textView = findViewById(R.id.text);
        showFragment = findViewById(R.id.showFragment);
        textView.setText("姓名：" + name + " 年龄：" + age + " ManualBean对象：" + manualBean);

        showFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = (Fragment) ARouter.getInstance().build(PATH_FRAGMENT_SIMPLE).navigation(SimpleActivity.this, new NavigationCallback() {

                    @Override
                    public void onFound(Postcard postcard) {
                        //路由目标被发现时调用
                        Log.d(Constant.TAG, "onFound-");

                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        //路由目标被丢失时调用
                        Log.d(Constant.TAG, "onLost-");
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        //路由目标到达时调用
                        Log.d(Constant.TAG, "onArrival-");
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        //路由目标被拦截后调用
                        Log.d(Constant.TAG, "onInterrupt-");
                    }
                });
                if (fragment instanceof SimpleDialogFragment) {
                    Log.d(Constant.TAG, "fragment.hashCode():" + fragment.hashCode());
//                    ((SimpleDialogFragment) fragment).onAttach(getApplicationContext());
                    ((SimpleDialogFragment) fragment).requestData(SimpleActivity.this, "mSimpleDialogFragment");

//                    ((SimpleDialogFragment) fragment).show(getSupportFragmentManager(), "mSimpleDialogFragment");
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        setResult(RESULT_OK);
    }
}