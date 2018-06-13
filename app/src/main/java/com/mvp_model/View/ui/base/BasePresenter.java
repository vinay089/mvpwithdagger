package com.mvp_model.View.ui.base;

import com.mvp_model.datamanager.model.DataManager;

import javax.inject.Inject;

public class BasePresenter<V extends BaseMVPView> implements BaseMVPPresenter<V>{

    private V baseMVPView;
    DataManager mDataManager;

    @Inject
    protected BasePresenter(DataManager dataManager){
        mDataManager = dataManager;
    }

    @Override
    public void onAttach(V baseMVPView) {

        this.baseMVPView = baseMVPView;
    }

    @Override
    public void deAttach() {

        baseMVPView = null;
    }

    public DataManager getmDataManager() {
        return mDataManager;
    }

    public V getMVPPresenterInstance(){
        return baseMVPView;
    }
}
