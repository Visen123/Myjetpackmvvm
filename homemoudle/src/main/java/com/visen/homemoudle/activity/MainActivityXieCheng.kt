package com.visen.homemoudle.activity

import NetRequests
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.visen.homemoudle.R
import com.visen.homemoudle.adapter.WenZhanAdapter4
import com.visen.homemoudle.base.log.dismissLoadingExt
import com.visen.homemoudle.base.log.showLoadingExt
import com.visen.homemoudle.bean.WenZhanDataBean
import com.visen.homemoudle.viewmodel.WenZhanRequestViewModel
import kotlinx.android.synthetic.main.activity_mainbasevm.*
import visen.yanyy.jetpackmvvm.base.activity.BaseVmActivity
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel
import visen.yanyy.jetpackmvvm.ext.parseState

class MainActivityXieCheng : BaseVmActivity<BaseViewModel>() {
    var mList: MutableList<WenZhanDataBean.ListsBean> = arrayListOf()

    //请求的ViewModel
    private val requestProjectViewModel: WenZhanRequestViewModel by viewModels()
    val adapter: WenZhanAdapter4 by lazy { WenZhanAdapter4(R.layout.item_category_list, mList) }


    fun btnClick(v: View) {
        load()
    }


    fun load() {
        NetRequests.getStartSleep(1, success = { w ->
            btn.text = w?.time;
        })
    }

    override fun layoutId(): Int {
        return R.layout.activity_mainbasevm
    }

    override fun initView(savedInstanceState: Bundle?) {
        requestProjectViewModel.getData(10)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
    }


    override fun createObserver() {
        requestProjectViewModel.wenzhangResult.observe(this, Observer { data ->
            parseState(data, {
                it.list?.let { it1 -> mList.addAll(it1) }
                adapter.notifyDataSetChanged()

            })
        })
    }

    override fun showLoading(message: String) {
        showLoadingExt(message)
    }

    override fun dismissLoading() {
        dismissLoadingExt()
    }

}


