package visen.yanyy.jetpackmvvm.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel

/**
 * 类名:  BaseVmDbFragment
 * 作者:  yanyiyun
 * 时间:  2021/9/20 13:03
 * 描述:
 */
abstract class BaseVmDbFragment<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmFragment<VM>() {
    //该类绑定的ViewDataBinding
    lateinit var mDatabind: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDatabind = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        mDatabind.lifecycleOwner = this
        return mDatabind.root
    }
}