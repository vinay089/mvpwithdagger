package com.mvp_model.View.ui.base;

public interface BaseMVPPresenter<V extends BaseMVPView> {

    void onAttach(V baseMVPView);

    void deAttach();

}
