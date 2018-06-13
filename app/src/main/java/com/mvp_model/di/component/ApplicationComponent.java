package com.mvp_model.di.component;

import android.app.Application;

import com.mvp_model.AppInfo;
import com.mvp_model.datamanager.DatabaseHelper;
import com.mvp_model.datamanager.model.DataManager;
import com.mvp_model.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AppInfo appInfo);

    DataManager getDataManager();

    Application getApplication();

    DatabaseHelper getDatabaseHelper();

}
