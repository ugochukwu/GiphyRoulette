package com.onwordiesquire.mobile.giphyroulette.common.util.injection.component;


import com.onwordiesquire.mobile.giphyroulette.common.util.injection.module.AppTestModule;
import com.onwordiesquire.mobile.giphyroulette.injection.components.AppComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by michelonwordi on 10/26/16.
 */
@Singleton
@Component(modules = AppTestModule.class)
public interface TestAppComponent extends AppComponent {
}
