package com.visen.homemoudle.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.visen.homemoudle.R
import com.visen.homemoudle.adapter.WenZhanAdapter4
import com.visen.homemoudle.base.activity.BaseActivity
import com.visen.homemoudle.bean.WenZhanDataBean
import com.visen.homemoudle.databinding.ActivityTestBinding
import com.visen.homemoudle.viewmodel.WenZhanRequestViewModel
import kotlinx.android.synthetic.main.activity_test.*
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel
import visen.yanyy.jetpackmvvm.ext.parseState

class TestDbActivity : BaseActivity<BaseViewModel, ActivityTestBinding>() {
    var mList: MutableList<WenZhanDataBean.ListsBean> = arrayListOf()

    //请求的ViewModel
    private val requestProjectViewModel: WenZhanRequestViewModel by viewModels()
    val adapter: WenZhanAdapter4 by lazy { WenZhanAdapter4(R.layout.item_category_list, mList) }

    override fun layoutId() = R.layout.activity_test

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


}