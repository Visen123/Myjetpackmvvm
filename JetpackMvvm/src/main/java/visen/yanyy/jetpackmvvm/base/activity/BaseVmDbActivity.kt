package visen.yanyy.jetpackmvvm.base.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel

/**
 * 类名:  BaseVmDatabindActivity
 * 作者:  yanyiyun
 * 时间:  2021/9/20 12:55
 * 描述:
 */
abstract class BaseVmDbActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmActivity<VM>() {
    lateinit var mDatabind: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        userDataBinding(true)
        super.onCreate(savedInstanceState)
    }

    /**
     * 创建DataBinding
     */
    override fun initDataBind() {
        mDatabind = DataBindingUtil.setContentView(this, layoutId())
        mDatabind.lifecycleOwner = this
    }
}