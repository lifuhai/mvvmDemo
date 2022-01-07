package com.lfh.frame.retrofit;


/**
* @author:  lfh
* @date:  2022/1/6
* @note:    返回成功回调
*/
public interface NetCallBack<T> {
    void onSuccess(T t);
}
