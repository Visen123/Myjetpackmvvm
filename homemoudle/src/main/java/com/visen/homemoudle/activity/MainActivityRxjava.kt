package com.visen.homemoudle.activity

import NetRequests
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.visen.homemoudle.R
import com.visen.homemoudle.adapter.WenZhanAdapter
import com.visen.homemoudle.base.log.dismissLoadingExt
import com.visen.homemoudle.base.log.showLoadingExt
import com.visen.homemoudle.bean.WenZhanBean
import com.visen.homemoudle.mvvm.view.SuccessView
import com.visen.homemoudle.viewmodel.WenZhanViewMoel
import kotlinx.android.synthetic.main.activity_mainbasevm.*

class MainActivityRxjava : AppCompatActivity(), SuccessView<WenZhanBean> {
    var mList: MutableList<WenZhanBean.ListBean>? = arrayListOf()
    val adapter: WenZhanAdapter by lazy { WenZhanAdapter(R.layout.item_category_list, mList) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainbasevm)
        Log.e("脚后跟脚后跟=", "8679")
        val wenZhanViewMoel = WenZhanViewMoel.getInstance()
        wenZhanViewMoel.loadData(10, this)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter


    }

    fun btnClick(v: View) {
        load()
    }


    fun load() {
        NetRequests.getStartSleep(1, success = { w ->
            btn.text = w?.time;
        })
    }

    override fun showLoading() {
        showLoadingExt("加载中")

    }

    override fun hideLoading() {
        dismissLoadingExt()
    }

    override fun onSuccess(data: WenZhanBean?) {
        mList!!.addAll(data!!.list)
        recycler.adapter!!.notifyDataSetChanged()
    }


}