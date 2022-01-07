package com.lfh.mvvmdemo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lfh.frame.base.BaseFragment;
import com.lfh.frame.base.BaseViewModel;
import com.lfh.frame.base.BaseViewModelFragment;
import com.lfh.mvvmdemo.R;
import com.lfh.mvvmdemo.databinding.FragmentFirstBinding;
import com.lfh.mvvmdemo.viewmodel.TestViewModel;

/**
* @author:  lfh
* @date:  2022/1/7
* @note:    viewmodel  之间共享数据
*/
public class FirstFragment extends BaseViewModelFragment<FragmentFirstBinding> {

    private   String TAG = "FirstFragment";

    @Override
    protected void initView() {
        super.initView();
        TestViewModel baseViewModel = ViewModelProviders.of(getActivity()).get(TestViewModel.class);
        baseViewModel.liveData.observe(getActivity(), new Observer<Object>() {
            @Override
            public void onChanged(Object o) {
                Log.e(TAG, "initViewccccccccc: "+o.toString() );

                binding.tvFirst.setText(o.toString());
            }
        });
    }
}