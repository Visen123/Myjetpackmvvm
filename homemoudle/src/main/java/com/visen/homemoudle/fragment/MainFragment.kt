package com.visen.homemoudle.fragment

import android.os.Bundle
import com.visen.homemoudle.R
import com.visen.homemoudle.base.fragment.MyBaseFragment
import com.visen.homemoudle.databinding.FragmentMainBinding
import com.visen.homemoudle.ext.init
import com.visen.homemoudle.ext.initMain
import com.visen.homemoudle.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * 作者: yanyy
 * 时间: 2021/9/30 17:52
 * 描述:
 */


class MainFragment : MyBaseFragment<MainViewModel, FragmentMainBinding>() {


    override fun layoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        //初始化viewpager2
        mainViewpager.initMain(this)
        //初始化 bottomBar
        mainBottom.init {
            when (it) {
                R.id.menu_main -> mainViewpager.setCurrentItem(0, false)
                R.id.menu_project -> mainViewpager.setCurrentItem(1, false)
                R.id.menu_system -> mainViewpager.setCurrentItem(2, false)
                R.id.menu_me -> mainViewpager.setCurrentItem(3, false)
            }
        }
    }


}