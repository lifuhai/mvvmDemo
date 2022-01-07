package com.lfh.mvvmdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.lfh.frame.base.BaseViewModelActivity;
import com.lfh.mvvmdemo.databinding.ActivityMainBinding;
import com.lfh.mvvmdemo.viewmodel.TestViewModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lfh
 * @date: 2022/1/6
 * @note: mvvm  请求示例
 */
public class MainActivity extends BaseViewModelActivity<ActivityMainBinding> {

    private TestViewModel testViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hold(R.id.container);
        inflate.tvName.setText("cccccccccc");
        mVaryViewHelper.showLoadingView();
        initViewModel();

        inflate.tvName.postDelayed(new Runnable() {
            @Override
            public void run() {
                mVaryViewHelper.showDataView();
                Map<String, String> map = new HashMap<>();
                map.put("action", "getCurVersion");
                map.put("deviceid", "aa1d26623a1b668e");
                testViewModel.test(map);
            }
        }, 5000);

        inflate.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });


    }

    private void initPager() {
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        inflate.viewPager.setAdapter(adapter);
    }

    private void initViewModel() {
        testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
        addViewModel(testViewModel);
        testViewModel.liveData.observe(this, new Observer<Object>() {
            @Override
            public void onChanged(Object o) {
                Log.e("TAG", "onChanged: " + o.toString());
            }
        });
    }


    @Override
    protected void initData() {
        inflate.viewPager.setVisibility(View.VISIBLE);
        mVaryViewHelper.showDataView();
        inflate.tvName.setVisibility(View.GONE);
        initPager();

    }

    @Override
    protected void error(String error) {
        super.error(error);
        mVaryViewHelper.showErrorView();
    }
}