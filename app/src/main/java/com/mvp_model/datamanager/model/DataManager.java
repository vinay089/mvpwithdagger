package com.mvp_model.datamanager.model;

import android.content.Context;

import com.mvp_model.datamanager.DatabaseHelper;
import com.mvp_model.di.ApplicationContext;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private Context mContext;
    private DatabaseHelper mDbHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DatabaseHelper dbHelper) {
        mContext = context;
        mDbHelper = dbHelper;
    }

    public Long insertUserInfo(UserInfo user) {
        return mDbHelper.insertData(user);
    }

    public ArrayList<UserInfo> getUser() {
        return mDbHelper.getAllUser();
    }
}
