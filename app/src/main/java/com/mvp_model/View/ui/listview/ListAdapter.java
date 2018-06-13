package com.mvp_model.View.ui.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mvp_model.R;
import com.mvp_model.datamanager.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindViews;

public class ListAdapter extends BaseAdapter {

    ArrayList<UserInfo> list;
    LayoutInflater inflter;

    ListAdapter(ArrayList list, Context context) {
        this.list = list;
        inflter = (LayoutInflater.from(context));
    }

    @BindViews({R.id.name_tv, R.id.number_tv, R.id.email_tv})
    List<TextView> textViews;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView nameTv=null, phoneTv=null, emailTv = null;

        if(view == null){
            view = inflter.inflate(R.layout.row_contact, viewGroup, false);

            nameTv = view.findViewById(R.id.name_tv);
            phoneTv = view.findViewById(R.id.number_tv);
            emailTv = view.findViewById(R.id.email_tv);
        }

        UserInfo info = list.get(i);

        nameTv.setText(info.getName());
        phoneTv.setText(info.getNumber());
        emailTv.setText(info.getEmail());

        return view;
    }

}
