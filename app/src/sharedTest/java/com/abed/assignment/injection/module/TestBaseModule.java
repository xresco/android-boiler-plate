package com.abed.assignment.injection.module;

import com.abed.assignment.controller.AnalyticsHelper;
import com.abed.assignment.controller.ApiHelper;
import com.abed.assignment.controller.EventBusHelper;
import com.abed.assignment.controller.LocalFileHelper;
import com.abed.assignment.controller.TestAnalyticsHelper;
import com.abed.assignment.controller.TestApiHelper;
import com.abed.assignment.controller.TestLocalFileHelper;
import com.abed.assignment.data.local.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Provide general dependencies.
 */
@Module
public class TestBaseModule {

    @Provides
    @Singleton
    RxBus provideEventBus() {
        return new RxBus();
    }

    @Provides
    @Singleton
    EventBusHelper provideEventBusHelper(RxBus bus) {
        return new EventBusHelper(bus);
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(EventBusHelper eventBusHelper) {
        return new TestApiHelper(null, eventBusHelper);
    }

    @Provides
    @Singleton
    LocalFileHelper provideLocalFileHelper() {
        return new TestLocalFileHelper();
    }

    @Provides
    @Singleton
    AnalyticsHelper provideAnalyticsHelper() {
        return new TestAnalyticsHelper();
    }

}