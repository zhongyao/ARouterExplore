package com.hongri.arouter.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hongri.arouter.R;

import static com.hongri.arouter.common.Constant.PATH_FRAGMENT_SIMPLE;

/**
 * @author：hongri
 * @date：3/23/22
 * @description：
 */
@Route(path = PATH_FRAGMENT_SIMPLE)
public class SimpleDialogFragment extends DialogFragment {

    private static final String TAG = "SimpleDialogFragment";
    private TextView title;

    public void requestData(Activity activity, String TAG) {
        Log.d(TAG, "requestData --- hashCode:" + hashCode());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        show(((FragmentActivity)activity).getSupportFragmentManager(), TAG);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
        Log.d(TAG, "SimpleDialogFragment --- hashCode:" + hashCode());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_simple, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.text);
        title.setText("重新赋值了");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public int show(@NonNull FragmentTransaction transaction, @Nullable String tag) {
        Log.d(TAG, "show");
        return super.show(transaction, tag);
    }

}


