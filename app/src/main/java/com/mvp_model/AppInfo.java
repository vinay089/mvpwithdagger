package com.mvp_model;

import android.app.Application;
import android.content.Context;

import com.mvp_model.datamanager.model.DataManager;
import com.mvp_model.di.component.ApplicationComponent;
import com.mvp_model.di.component.DaggerApplicationComponent;
import com.mvp_model.di.module.ApplicationModule;

import javax.inject.Inject;

public class AppInfo extends Application{

    protected ApplicationComponent applicationComponent;

    public static AppInfo get(Context context) {

        return (AppInfo) context.getApplicationContext();
    }

    @Inject
    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                                    .builder()
                                    .applicationModule(new ApplicationModule(this))
                                    .build();

        applicationComponent.inject(this);

    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
