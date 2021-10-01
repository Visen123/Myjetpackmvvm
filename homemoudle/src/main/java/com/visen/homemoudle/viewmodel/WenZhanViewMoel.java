package com.visen.homemoudle.viewmodel;

import androidx.lifecycle.ViewModel;

import com.visen.homemoudle.mvvm.model.WenZhanModel;
import com.visen.homemoudle.mvvm.view.SuccessView;


/**
 * @作者 严益云
 * @创建日期 2021/01/4
 * 文章业务逻辑类用rxjava方式
 */
public class WenZhanViewMoel extends ViewModel {

    private WenZhanModel mModel;
    private static WenZhanViewMoel modifyPasswordViewMoel;

    private WenZhanViewMoel() {
        if (mModel == null) {
            mModel = new WenZhanModel();
        }

    }

    public static WenZhanViewMoel getInstance() {
        if (modifyPasswordViewMoel == null) {
            modifyPasswordViewMoel = new WenZhanViewMoel();
        }
        return modifyPasswordViewMoel;
    }

    public void loadData(int p, SuccessView successview) {
        mModel.loadDataFromNet(p, successview);

    }

}
