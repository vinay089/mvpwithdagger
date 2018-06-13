package com.mvp_model.View.ui.listview;

import com.mvp_model.View.ui.base.BaseMVPView;
import com.mvp_model.datamanager.model.UserInfo;

import java.util.ArrayList;

public interface ListMVPView extends BaseMVPView {

    boolean checkGalleryPermission();

    void loadContactLsit(ArrayList<UserInfo> list);

}
