package com.onwordiesquire.mobile.giphyroulette.data;

import com.onwordiesquire.mobile.giphyroulette.data.model.RandomDataModel;
import com.onwordiesquire.mobile.giphyroulette.data.sources.remote.GiphyApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by michelonwordi on 10/27/16.
 */
@Singleton
public class DataManager {

    GiphyApiService apiService;
    @Inject
    public DataManager(GiphyApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<RandomDataModel> getRandomGif(String apikey)
    {
        return apiService.randomRoulette(apikey);
    }

}
