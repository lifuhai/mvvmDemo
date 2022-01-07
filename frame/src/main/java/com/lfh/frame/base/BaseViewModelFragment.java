package com.lfh.frame.base;

import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;

public  class BaseViewModelFragment<T extends ViewBinding> extends BaseFragment<T>{

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

    private void error(String error) {

    }
}
