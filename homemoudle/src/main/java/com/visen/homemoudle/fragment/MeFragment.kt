package com.visen.homemoudle.fragment

import android.os.Bundle
import com.visen.homemoudle.R
import com.visen.homemoudle.base.fragment.MyBaseFragment
import com.visen.homemoudle.databinding.FragmentMeBinding
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel

/**
 * 作者: yanyy
 * 时间: 2021/9/20 13:46
 * 描述: 精选栏目
 */


class MeFragment : MyBaseFragment<BaseViewModel, FragmentMeBinding>() {


    override fun layoutId(): Int {
        return R.layout.fragment_me
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun createObserver() {

    }


}