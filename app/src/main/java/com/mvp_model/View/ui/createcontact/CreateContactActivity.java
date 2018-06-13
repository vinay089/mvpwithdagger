package com.mvp_model.View.ui.createcontact;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.mvp_model.R;
import com.mvp_model.View.ui.base.BaseActivity;
import com.mvp_model.View.ui.listview.ListActivity;
import com.mvp_model.datamanager.model.DataManager;
import com.mvp_model.datamanager.model.UserInfo;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateContactActivity extends BaseActivity implements ContactMVPView {

    @BindViews({R.id.editText, R.id.editText2, R.id.editText3})
    List<EditText> editTextList;

//    CreateContactMVPPresenter<ContactMVPView> contactInstance;

    @Inject
    CreateContactMVPPresenter<ContactMVPView> mPresenter;

    @Inject
    DataManager dataManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        setUpUnBinder(ButterKnife.bind(this));

        getActivityModule().inject(this);
//        mPresenter = new CreateContactPresenter(dataManager);
        mPresenter.onAttach(this);
    }

    @Override
    public void hideKeyboard() {

    }

    @OnClick(R.id.button)
    public void onButtonClick(){

        showDialog(CreateContactActivity.this);

        if(checkEmptyField()){

            hideDialog();
            Toast.makeText(CreateContactActivity.this, "Empty fields", Toast.LENGTH_LONG).show();
        } else {

            String name = editTextList.get(0).getText().toString().trim();
            String phone = editTextList.get(1).getText().toString().trim();
            String email = editTextList.get(2).getText().toString().trim();

            mPresenter.saveContact(new UserInfo(name, phone, email));
            startListActivity();
        }

    }

    @Override
    public boolean checkEmptyField() {

        for(EditText editText : editTextList) {
            if (editText.getText().toString().trim().isEmpty())
                return true;
        }

        return false;
    }

    @Override
    public void startListActivity() {

        finish();
        startActivity (new Intent(this, ListActivity.class));
    }

    @Override
    public void onDestroy() {
        mPresenter.deAttach();
        super.onDestroy();
    }

}
