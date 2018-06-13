package com.mvp_model.View.ui.createcontact;

import com.mvp_model.View.ui.base.BaseMVPPresenter;
import com.mvp_model.datamanager.model.UserInfo;
import com.mvp_model.di.PerActivity;

@PerActivity
public interface CreateContactMVPPresenter<V extends ContactMVPView> extends BaseMVPPresenter<V> {

    void saveContact(UserInfo userInfo);

    void errorWhileSaving();
}
