package com.mvp_model.View.ui.listview;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;

import com.mvp_model.View.ui.base.BasePresenter;
import com.mvp_model.datamanager.model.DataManager;
import com.mvp_model.datamanager.model.UserInfo;
import com.mvp_model.utils.Constants;

import java.util.ArrayList;

import javax.inject.Inject;

public class ListPresenter<V extends ListMVPView> extends BasePresenter<V> implements ListMVPPresenter<V> {

    @Inject
    public ListPresenter(DataManager dataManager){
        super(dataManager);
    }

    @Override
    public ArrayList<UserInfo> loadContact() {

        return getmDataManager().getUser();
    }

    @Override
    public void setAdapter(ArrayList<UserInfo> userlist) {

    }

    @Override
    public void onItemClick() {

    }

    @Override
    public void onLongItemClick() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void Ok() {

    }

    @Override
    public void askRunTimePermission(Context context) {
        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Constants.GALLERY_RUNTIMEPERMISSION);
    }

}
