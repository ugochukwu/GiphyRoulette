package com.onwordiesquire.mobile.giphyroulette.common.util.injection.module;

import android.app.Application;
import android.content.Context;

import com.onwordiesquire.mobile.giphyroulette.data.DataManager;
import com.onwordiesquire.mobile.giphyroulette.data.sources.remote.GiphyApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/**
 * Created by michelonwordi on 10/26/16.
 */
@Module
public class AppTestModule {

    public Application app;

    public AppTestModule(Application app) {
        this.app = app;
    }


    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return app;
    }

    @Provides
    @Singleton
    public GiphyApiService provideApi() {
        return mock(GiphyApiService.class);
    }

    @Provides
    @Singleton
    public DataManager providesDataManager() {
        return mock(DataManager.class);
    }


}
