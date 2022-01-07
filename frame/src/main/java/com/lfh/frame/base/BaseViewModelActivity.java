package com.lfh.frame.base;

import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;

public class BaseViewModelActivity <T extends ViewBinding> extends  BaseActivity<T>{


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


    public void addViewModel(BaseViewModel baseViewModel){
        baseViewModel.liveError.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String error) {
                error(error);
            }
        });
    }

    protected void error(String error) {
        Log.e("TAG", "error: "+error );
    }
}
