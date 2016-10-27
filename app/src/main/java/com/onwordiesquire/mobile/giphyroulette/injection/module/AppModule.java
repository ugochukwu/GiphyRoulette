package com.onwordiesquire.mobile.giphyroulette.injection.module;

import android.app.Application;
import android.content.Context;

import com.onwordiesquire.mobile.giphyroulette.data.sources.remote.GiphyApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by michelonwordi on 10/23/16.
 */
@Module
public class AppModule {

    public Application app;

    public AppModule(Application app)
    {
        this.app = app;
    }


    @Provides
    @Singleton
    public Application provideApplication()
    {
        return app;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return app;
    }

    @Provides
    @Singleton
    public GiphyApiService provideApi()
    {
        return  GiphyApiService.HELPER.newGiphyApiService();
    }
}
