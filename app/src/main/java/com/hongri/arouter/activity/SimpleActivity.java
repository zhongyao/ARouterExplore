package com.hongri.arouter.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hongri.arouter.R;
import com.hongri.arouter.bean.ManualBean;

import static com.hongri.arouter.common.Constant.PATH_ACTIVITY_SIMPLE;

//在支持的路由页面添加注解
@Route(path = PATH_ACTIVITY_SIMPLE)
public class SimpleActivity extends BaseActivity {

    private TextView textView;
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
        textView.setText("姓名：" + name + " 年龄：" + age + " ManualBean对象：" + manualBean);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setResult(RESULT_OK);
    }
}