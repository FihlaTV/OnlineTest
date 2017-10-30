package com.gyf.onlinetest.net;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.gyf.onlinetest.MyApplication;
import com.gyf.onlinetest.model.bean.BusBean;
import com.gyf.onlinetest.utils.FileUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by geyifeng on 2017/10/24.
 */

public class RetrofitHttp {

    private static RetrofitHttp mInstance;
    private ApiService mApiService;
    private static final String BASE_URL = "http://lab.ninjachen.rocks:8080/";

    private RetrofitHttp() {
        mApiService = new Retrofit.Builder()
                .client(client())
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);
    }

    public static RetrofitHttp getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitHttp.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitHttp();
                }
            }
        }
        return mInstance;
    }

    private OkHttpClient client() {
        return new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .cache(new Cache(FileUtils.getDiskCacheDir(MyApplication.getContext()),
                        1024 * 1024 * 10))
                .addInterceptor(new CacheInterceptor())
                .addNetworkInterceptor(new CacheInterceptor())
                .build();
    }

    public void getBus(Observer<HashMap<String, ArrayList<BusBean>>> observer) {
        mApiService.getBus()
                .map(new Function<ResponseBody, HashMap<String, ArrayList<BusBean>>>() {
                    @Override
                    public HashMap<String, ArrayList<BusBean>> apply(@NonNull ResponseBody responseBody) throws Exception {
                        return parserBusJson(responseBody.string());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    private HashMap<String, ArrayList<BusBean>> parserBusJson(String json) {
        HashMap<String, ArrayList<BusBean>> busMap = new HashMap<>();
        JsonObject asJsonObject = new JsonParser().parse(json).getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = asJsonObject.entrySet();
        for (Map.Entry<String, JsonElement> entry : entries) {
            String key = entry.getKey();
            JsonArray asJsonArray = entry.getValue().getAsJsonArray();
            Gson gson = new Gson();
            ArrayList<BusBean> busList = new ArrayList<>();
            for (JsonElement jsonElement : asJsonArray) {
                BusBean busBean = gson.fromJson(jsonElement, BusBean.class);
                busList.add(busBean);
            }
            busMap.put(key, busList);
        }
        return busMap;
    }
}
