package com.onwordiesquire.mobile.giphyroulette;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.onwordiesquire.mobile.giphyroulette.injection.components.AppComponent;
import com.onwordiesquire.mobile.giphyroulette.injection.components.DaggerAppComponent;
import com.onwordiesquire.mobile.giphyroulette.injection.module.AppModule;

import timber.log.Timber;

/**
 * Created by michelonwordi on 10/27/16.
 */

public class GiphyApp extends Application {

    public AppComponent component;
    private static GiphyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        this.app = this;
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        Stetho.initializeWithDefaults(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static GiphyApp get() {
        return app;
    }

    public static GiphyApp get(Context context) {
        return (GiphyApp) context.getApplicationContext();
    }

    public AppComponent getComponent() {
        return component;
    }

    public void setComponent(AppComponent component) {
        this.component = component;
    }
}
