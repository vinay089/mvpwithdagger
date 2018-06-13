package com.mvp_model.View.ui.listview;

import android.content.Context;
import android.widget.TextView;

import com.mvp_model.R;
import com.mvp_model.datamanager.model.UserInfo;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Position;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.ArrayList;

/**
 * Created by Vinay Gupta on 27-05-2018.
 */

@Layout(R.layout.row_contact)
public class ContactPlaceHolder {

    Context mContaxt;
    ArrayList<UserInfo> mlist;

    @View(R.id.name_tv)
    TextView nameTv;

    @View(R.id.number_tv)
    TextView numberTv;

    @View(R.id.email_tv)
    TextView emailTv;

    @Position
    int position;

    ContactPlaceHolder(Context context, ArrayList<UserInfo> list){

        mContaxt = context;
        mlist = list;
    }

    @Resolve
    public void resolved(){

        UserInfo mUserInfo = mlist.get(position);

        nameTv.setText(mUserInfo.getName());
        numberTv.setText(mUserInfo.getNumber());
        emailTv.setText(mUserInfo.getEmail());
    }
}
