package com.mvp_model.di.module;

import android.app.Application;
import android.content.Context;

import com.mvp_model.di.ApplicationContext;
import com.mvp_model.di.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application mApplication){
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }


    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "contacts";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 1;
    }

}
