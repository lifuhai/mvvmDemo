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

import com.lfh.frame.base.BaseViewModelFragment;
import com.lfh.mvvmdemo.R;
import com.lfh.mvvmdemo.databinding.FragmentSecondBinding;
import com.lfh.mvvmdemo.mode.Test;
import com.lfh.mvvmdemo.viewmodel.SecondViewModel;
import com.lfh.mvvmdemo.viewmodel.TestViewModel;

import java.util.List;


public class SecondFragment extends BaseViewModelFragment<FragmentSecondBinding> {


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SecondViewModel testViewModel = ViewModelProviders.of(getActivity()).get(SecondViewModel.class);
        addViewModel(testViewModel);
        testViewModel.liveName.observe(getActivity(), new Observer<Test>() {
            @Override
            public void onChanged(Test test) {

                cancelLoading();
                List<Test.DataBean.UsersordersBean> usersorders = test.getData().getUsersorders();
                for (int i = 0; i < usersorders.size(); i++) {
                    Log.e("TAG", "onChanged: " + usersorders.get(i).get_id());
                }
            }
        });
        binding.tvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initLoading("");
                testViewModel.getName();
            }
        });
    }


    @Override
    protected void initData() {
//        super.initData();
    }

    @Override
    protected void onError(String error) {
        super.onError(error);
        Log.e("TAG", "onError: " + error);
        cancelLoading();

    }
}