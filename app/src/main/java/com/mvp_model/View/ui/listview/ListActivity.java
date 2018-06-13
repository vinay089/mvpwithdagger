package com.mvp_model.View.ui.listview;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.mvp_model.R;
import com.mvp_model.View.ui.base.BaseActivity;
import com.mvp_model.View.ui.createcontact.CreateContactActivity;
import com.mvp_model.datamanager.model.DataManager;
import com.mvp_model.datamanager.model.UserInfo;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ListActivity extends BaseActivity implements ListMVPView {

    @Inject
    ListMVPPresenter <ListMVPView> presenter;

//    @BindView(R.id.listview_contacts)
//    PlaceHolderView placeholderView;


    @BindView(R.id.listview_contacts)
    ListView listView;

    @Inject
    DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpUnBinder(ButterKnife.bind(this));

        getActivityModule().inject(this);


//        mListInterface = new ListPresenter(mDataManager);

        presenter.onAttach(this);
        ArrayList<UserInfo> list = presenter.loadContact();

//        placeholderView.addView(new ContactPlaceHolder(this, list));
        ListAdapter listAdapter = new ListAdapter(list, ListActivity.this);
        listView.setAdapter(listAdapter);

    }

    @Override
    public void hideKeyboard() {

    }

    @OnClick(R.id.fab)
    public void fabButton(){
        startActivity(new Intent(this, CreateContactActivity.class));
    }

    @Override
    public boolean checkGalleryPermission() {
        return (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED);

    }

    @Override
    public void loadContactLsit(ArrayList<UserInfo> list) {

    }

    @Override
    public void onDestroy() {
        presenter.deAttach();
        super.onDestroy();
    }
}
