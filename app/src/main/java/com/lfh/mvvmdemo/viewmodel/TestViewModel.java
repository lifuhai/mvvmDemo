package com.lfh.mvvmdemo.viewmodel;

import androidx.lifecycle.MutableLiveData;


import com.lfh.frame.base.BaseViewModel;
import com.lfh.frame.retrofit.NetCallBack;
import com.lfh.frame.retrofit.RequestRetrofit;

import java.util.Map;

public class TestViewModel extends BaseViewModel {

   public MutableLiveData <Object>liveData=new MutableLiveData<>();
   public MutableLiveData <Object>liveName=new MutableLiveData<>();

    public void test(Map<String,String>map) {
        loadData(RequestRetrofit.getInstance().updateUMDeviceToken(map), new NetCallBack<Object>() {
            @Override
            public void onSuccess(Object baseResponse) {
                liveData.setValue(baseResponse);
            }

        });

    }


    public  void  getName(Map<String,String>map){
        loadData(RequestRetrofit.getInstance().getBILLName(map), new NetCallBack<Object>() {
            @Override
            public void onSuccess(Object o) {
                liveName.setValue(o);
            }
        });
    }




}
