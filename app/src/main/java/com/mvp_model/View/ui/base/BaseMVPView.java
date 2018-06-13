package com.mvp_model.View.ui.base;


import android.content.Context;

public interface BaseMVPView {

    void hideDialog();
    void showDialog(Context context);
    void onError();
    void hideKeyboard();

}
