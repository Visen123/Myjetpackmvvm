package com.visen.homemoudle.activity

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.blankj.utilcode.util.ToastUtils
import com.visen.homemoudle.R
import com.visen.homemoudle.base.activity.BaseActivity
import com.visen.homemoudle.base.application.appViewModel
import com.visen.homemoudle.databinding.ActivityMainBinding
import com.visen.homemoudle.utils.StatusBarUtil
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel

class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {
    var exitTime = 0L
    override fun layoutId() = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val nav = Navigation.findNavController(this@MainActivity, R.id.host_fragment)
                if (nav.currentDestination != null && nav.currentDestination!!.id != R.id.mainfragment) {
                    //如果当前界面不是主页，那么直接调用返回即可
                    nav.navigateUp()
                } else {
                    //是主页
                    if (System.currentTimeMillis() - exitTime > 2000) {
                        ToastUtils.showShort("再按一次退出程序")
                        exitTime = System.currentTimeMillis()
                    } else {
                        finish()
                    }
                }
            }
        })

        appViewModel.appColor.value?.let {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
            supportActionBar?.setBackgroundDrawable(ColorDrawable(it))
            StatusBarUtil.setColor(this, it, 0)
        }

    }


    override fun createObserver() {
        appViewModel.appColor.observeInActivity(this, Observer {
            supportActionBar?.setBackgroundDrawable(ColorDrawable(it))
            StatusBarUtil.setColor(this, it, 0)
        })
    }


}