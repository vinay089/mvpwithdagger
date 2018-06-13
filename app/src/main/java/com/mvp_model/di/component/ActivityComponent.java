package com.mvp_model.di.component;

import com.mvp_model.View.ui.createcontact.CreateContactActivity;
import com.mvp_model.View.ui.listview.ListActivity;
import com.mvp_model.di.PerActivity;
import com.mvp_model.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(CreateContactActivity createContactActivity);
    void inject(ListActivity listActivity);
}
