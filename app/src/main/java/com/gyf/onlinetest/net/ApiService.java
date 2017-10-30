package com.gyf.onlinetest.net;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

/**
 * Created by geyifeng on 2017/10/24.
 */

public interface ApiService {
    @GET("online_interview")
    Observable<ResponseBody> getBus();
}
