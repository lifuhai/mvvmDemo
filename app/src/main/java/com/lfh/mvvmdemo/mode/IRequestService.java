package com.lfh.mvvmdemo.mode;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * @author lfh
 */
public interface IRequestService {

    /**
     *@param
     * @return
     */
    @GET("cntmiService2/UpdateVersion")
    Observable<Object> updateUMDeviceToken( @QueryMap Map<String,String>map);


    @GET("v1/app_usersorders/?users_id=61d553da2e3fadf10dfd6827")
    Observable<Test> getBILLName();
}
