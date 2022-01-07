package com.lfh.mvvmdemo.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.lfh.frame.base.BaseViewModel;
import com.lfh.frame.retrofit.NetCallBack;
import com.lfh.frame.retrofit.RequestRetrofit;
import com.lfh.mvvmdemo.mode.IRequestService;
import com.lfh.mvvmdemo.mode.Test;

import java.util.Map;

public class SecondViewModel extends BaseViewModel {

    public MutableLiveData<Test> liveName = new MutableLiveData<>();

    public void getName() {
        loadData(RequestRetrofit.retrofit().create(IRequestService.class).getBILLName(), new NetCallBack<Test>() {
            @Override
            public void onSuccess(Test o) {
                liveName.setValue(o);
            }
        });
    }


}
