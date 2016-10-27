package com.onwordiesquire.mobile.giphyroulette.common;

import android.content.Context;

import com.onwordiesquire.mobile.giphyroulette.GiphyApp;
import com.onwordiesquire.mobile.giphyroulette.common.util.injection.component.TestAppComponent;
import com.onwordiesquire.mobile.giphyroulette.common.util.injection.component.DaggerTestAppComponent;
import com.onwordiesquire.mobile.giphyroulette.common.util.injection.module.AppTestModule;
import com.onwordiesquire.mobile.giphyroulette.data.DataManager;
import com.onwordiesquire.mobile.giphyroulette.data.sources.remote.GiphyApiService;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by michelonwordi on 10/26/16.
 */

public class TestAppComponentRule implements TestRule {

    private final Context context;
    private final TestAppComponent testAppComponent ;

    public TestAppComponentRule(Context context) {
        this.context = context;
        testAppComponent = DaggerTestAppComponent.builder()
                .appTestModule(new AppTestModule(GiphyApp.get())).build();
    }

    public Context getContext() {
        return context;
    }

    public DataManager getMockDataManager() {
        return testAppComponent.dataManager();
    }



    public GiphyApiService getMockApi() {
        return testAppComponent.apiService();
    }

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                GiphyApp application = GiphyApp.get();
                application.setComponent(testAppComponent);
                base.evaluate();
                application.setComponent(null);
            }
        };
    }
}
