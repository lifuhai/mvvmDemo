package com.lfh.frame.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.JsonSyntaxException;
import com.lfh.frame.retrofit.NetCallBack;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
/**
* @author:  lfh
* @date:  2022/1/7
* @note:    网络请求的具体实现
*/
public class BaseViewModel extends ViewModel {
    public MutableLiveData<String> liveError = new MutableLiveData<>();

    protected <T> void loadData(Observable<T> observable, NetCallBack<T> callBack) {

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull T t) {
                        callBack.onSuccess(t);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        liveError.setValue(getException(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public static String getException(Throwable e) {
        String msg = e.toString();
        if (e instanceof SocketTimeoutException) {
            msg = "网络不稳定，链接超时";
        } else if (e instanceof ConnectException) {
            msg = "网络不稳定,请稍后再试";
        } else if (e instanceof HttpException) {
            msg = "错误码" + ((HttpException) e).code() + " 请求失败";
        } else if (e instanceof UnknownHostException) {
            msg = "请保持网络通畅";
        } else if (e instanceof IllegalStateException) {
            msg = e.getMessage();
        } else if (e instanceof JsonSyntaxException) {
            msg = "数据解析出错";
        } else {
            msg = "接口请求失败"+e.getMessage();
        }
        e.printStackTrace();
        return msg;
    }

}
