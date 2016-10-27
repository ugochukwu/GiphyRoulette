package com.onwordiesquire.mobile.giphyroulette.injection.components;


import com.onwordiesquire.mobile.giphyroulette.presentation.gifgallery.MainActivity;
import com.onwordiesquire.mobile.giphyroulette.data.DataManager;
import com.onwordiesquire.mobile.giphyroulette.data.sources.remote.GiphyApiService;
import com.onwordiesquire.mobile.giphyroulette.injection.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by michelonwordi on 10/23/16.
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    void inject(MainActivity activity);


    //expose data manager to downstream components
    DataManager dataManager();

    GiphyApiService apiService();
}
