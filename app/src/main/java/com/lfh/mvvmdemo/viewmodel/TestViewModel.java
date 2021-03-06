package com.lfh.mvvmdemo.viewmodel;

import androidx.lifecycle.MutableLiveData;


import com.lfh.frame.base.BaseViewModel;
import com.lfh.frame.retrofit.NetCallBack;
import com.lfh.frame.retrofit.RequestRetrofit;
import com.lfh.mvvmdemo.mode.IRequestService;
import com.lfh.mvvmdemo.mode.Test;

import java.util.Map;

public class TestViewModel extends BaseViewModel {

    public MutableLiveData<Object> liveData = new MutableLiveData<>();
    public MutableLiveData<Test> liveName = new MutableLiveData<>();

    public void test(Map<String, String> map) {
        loadData(RequestRetrofit.retrofit().create(IRequestService.class).updateUMDeviceToken(map), new NetCallBack<Object>() {
            @Override
            public void onSuccess(Object baseResponse) {
                liveData.setValue(baseResponse);
            }

        });

    }


    public void getName() {
        loadData(RequestRetrofit.retrofit().create(IRequestService.class).getBILLName(), new NetCallBack<Test>() {
            @Override
            public void onSuccess(Test o) {
                liveName.setValue(o);
            }
        });
    }


}
