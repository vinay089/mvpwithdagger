package com.mvp_model.di.module;

import android.app.Activity;
import android.content.Context;

import com.mvp_model.View.ui.createcontact.ContactMVPView;
import com.mvp_model.View.ui.createcontact.CreateContactMVPPresenter;
import com.mvp_model.View.ui.createcontact.CreateContactPresenter;
import com.mvp_model.View.ui.listview.ListMVPPresenter;
import com.mvp_model.View.ui.listview.ListMVPView;
import com.mvp_model.View.ui.listview.ListPresenter;
import com.mvp_model.di.ActivityContext;
import com.mvp_model.di.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {


    private Activity mActivity;

    public ActivityModule(Activity mActivity){
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return mActivity;
    }

    @Provides
    Activity provideActivity(){
        return mActivity;
    }

    @Provides
    @PerActivity
    ListMVPPresenter<ListMVPView> listViewPresenter(ListPresenter<ListMVPView> presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    CreateContactMVPPresenter<ContactMVPView> createContactPresenter(CreateContactPresenter<ContactMVPView> presenter){
        return presenter;
    }
}
