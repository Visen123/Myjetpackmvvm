package com.visen.homemoudle.mvvm.basepross;

/**
 * @作者 严益云
 * @创建日期 2020/12/1
 * 类名 BaseLoadPross.java
 */
public interface BaseLoadPross extends LoadPross {
    /**
     * 显示正在加载的进度框
     */
    void showLoading();

    /**
     * 隐藏正在加载进度框
     */
    void hideLoading();


}
