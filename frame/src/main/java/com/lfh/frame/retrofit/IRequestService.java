package com.lfh.frame.retrofit;

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


    @FormUrlEncoded
    @POST("cntmiService2/WebService")
    Observable<Object> getBILLName(@FieldMap Map<String,String>map);
}
