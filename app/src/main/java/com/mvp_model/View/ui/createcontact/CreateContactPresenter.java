package com.mvp_model.View.ui.createcontact;

import com.mvp_model.View.ui.base.BasePresenter;
import com.mvp_model.datamanager.model.DataManager;
import com.mvp_model.datamanager.model.UserInfo;

import javax.inject.Inject;

public class CreateContactPresenter <V extends ContactMVPView> extends BasePresenter<V>
        implements CreateContactMVPPresenter<V> {

    @Inject
    public CreateContactPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void saveContact(UserInfo userInfo) {

//        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseInstance(createContactActivity);
        getMVPPresenterInstance().hideDialog();
        long id = getmDataManager().insertUserInfo(userInfo);


        if(id < 0)
            errorWhileSaving();
    }

    @Override
    public void errorWhileSaving() {

        getMVPPresenterInstance().hideDialog();
    }

}
