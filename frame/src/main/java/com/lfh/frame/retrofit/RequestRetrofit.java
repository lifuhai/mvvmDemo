package com.lfh.frame.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
* @author:  lfh
* @date:  2022/1/6
* @note:      创建 RequestRetrofit 执行头
*/
public class RequestRetrofit {
    private static IRequestService requestService;

    static {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .client(HttpClientHelper.getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        requestService = retrofit.create(IRequestService.class);
    }

    public static IRequestService getInstance() {
        return requestService;
    }
}
