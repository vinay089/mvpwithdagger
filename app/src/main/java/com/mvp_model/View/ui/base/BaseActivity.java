package com.mvp_model.View.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mvp_model.AppInfo;
import com.mvp_model.di.component.ActivityComponent;
import com.mvp_model.di.component.DaggerActivityComponent;
import com.mvp_model.di.module.ActivityModule;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity
        implements BaseMVPView {

    private Unbinder unbinder;

    private ActivityComponent mActivityComponent;

    ProgressDialog progressDialog;
    public void setUpUnBinder(Unbinder unBinder) {
        this.unbinder = unBinder;
    }

    @Override
    protected void onCreate(@Nullable Bundle onSaveInstance) {
        super.onCreate(onSaveInstance);

        mActivityComponent = DaggerActivityComponent
                .builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(AppInfo.get(this).getComponent())
                .build();

    }

    @Override
    public void onDestroy() {

        if(unbinder != null)
            unbinder.unbind();

        super.onDestroy();
    }

    public ActivityComponent getActivityModule(){
        return mActivityComponent;
    }

    @Override
    public void hideDialog() {
        Log.d("created at", "base activity");

        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.cancel();
        }
    }

    @Override
    public void showDialog(Context context) {

        hideDialog();
        progressDialog = ProgressDialog.show(context, null, "Please wait", true, false);
        Log.d("created at", "base activity");
    }

    @Override
    public void onError() {

    }
}
