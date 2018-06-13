package com.mvp_model.View.ui.listview;


import android.content.Context;

import com.mvp_model.View.ui.base.BaseMVPPresenter;
import com.mvp_model.datamanager.model.UserInfo;
import com.mvp_model.di.PerActivity;

import java.util.ArrayList;

@PerActivity
public interface ListMVPPresenter<V extends ListMVPView> extends BaseMVPPresenter<V> {

    ArrayList<UserInfo> loadContact();

    void setAdapter(ArrayList<UserInfo> userlist);

    void onItemClick();
    void onLongItemClick();

    void cancel();
    void Ok();

    void askRunTimePermission(Context context);

    }
