package com.onwordiesquire.mobile.giphyroulette.data.sources.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.onwordiesquire.mobile.giphyroulette.BuildConfig;
import com.onwordiesquire.mobile.giphyroulette.data.model.RandomDataModel;
import com.onwordiesquire.mobile.giphyroulette.util.MyGsonTypeAdapterFactory;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by michelonwordi on 10/27/16.
 */

public interface GiphyApiService {

    String ENDPOINT = "http://api.giphy.com/";

    @GET("v1/gifs/random")
    Observable<RandomDataModel> randomRoulette(@Query("api_key") String apiKey);


    class HELPER {

        public static GiphyApiService newGiphyApiService() {
            OkHttpClient client = null;
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            } else {
                client = new OkHttpClient.Builder().build();

            }

            Gson gson = new GsonBuilder().registerTypeAdapterFactory(MyGsonTypeAdapterFactory.create())
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();

            return retrofit.create(GiphyApiService.class);
        }

    }

}
