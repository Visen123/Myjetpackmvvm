package com.visen.homemoudle.mvvm.view;


import com.visen.homemoudle.mvvm.basepross.BaseLoadPross;

/**
 * @作者 严益云
 * @创建日期 2021/1/6
 * 类名 SuccessView.java
 * 成功回调接口数据—》提供给界面更新数据使用
 */
public interface SuccessView<V> extends BaseLoadPross {
    void onSuccess(V data);
}
