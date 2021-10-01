package com.visen.homemoudle.base.activity

import android.content.res.Resources
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.visen.homemoudle.base.log.dismissLoadingExt
import com.visen.homemoudle.base.log.showLoadingExt
import me.jessyan.autosize.AutoSizeCompat
import visen.yanyy.jetpackmvvm.base.activity.BaseVmDbActivity
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel

/**
 * 类名:  MyBaseActivity
 * 作者:  yanyiyun
 * 时间:  2021/9/19 16:02
 * 描述:
 * 加载进度弹窗
 *
 */
abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmDbActivity<VM, DB>() {
    abstract override fun layoutId(): Int

    abstract override fun initView(savedInstanceState: Bundle?)

    /**
     * 创建liveData观察者
     */
    override fun createObserver() {}

    override fun showLoading(message: String) {
        showLoadingExt(message)
    }

    override fun dismissLoading() {
        dismissLoadingExt()
    }

    /* */
    /**
     * 在任何情况下本来适配正常的布局突然出现适配失效，适配异常等问题，只要重写 Activity 的 getResources() 方法
     */
    override fun getResources(): Resources {
        AutoSizeCompat.autoConvertDensityOfGlobal(super.getResources())
        return super.getResources()
    }
}