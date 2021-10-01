package com.visen.homemoudle.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kingja.loadsir.core.LoadService
import com.visen.homemoudle.R
import com.visen.homemoudle.base.fragment.MyBaseFragment
import com.visen.homemoudle.bean.MyListBean
import com.visen.homemoudle.databinding.FragmentWzDetailBinding
import com.visen.homemoudle.ext.CHsData
import com.visen.homemoudle.ext.initClose
import com.visen.homemoudle.ext.loadServiceInit
import com.visen.homemoudle.ext.showLoading
import com.visen.homemoudle.viewmodel.WenZhanDetailViewModel
import kotlinx.android.synthetic.main.fragment_wz_detail.*
import kotlinx.android.synthetic.main.include_toolbar.*
import visen.yanyy.jetpackmvvm.ext.nav
import visen.yanyy.jetpackmvvm.ext.util.toHtml

/**
 * 作者: yanyy
 * 时间: 2021/9/20 13:46
 * 描述: 文章详情
 */


class WenZhangDetailFragment : MyBaseFragment<WenZhanDetailViewModel, FragmentWzDetailBinding>() {

    private val wenZhanDetailViewModel: WenZhanDetailViewModel by viewModels()

    //界面状态管理者
    private lateinit var loadsir: LoadService<Any>
    private var id = "0"
    private var titles = ""

    override fun layoutId(): Int {
        return R.layout.fragment_wz_detail
    }


    override fun initView(savedInstanceState: Bundle?) {
        arguments?.run {
            getParcelable<MyListBean>(CHsData.DetailData)?.let {
                titles = it.title
                id = it.id

            }
        }
        loadsir = loadServiceInit(wzdetail_scrollview) {
            //点击重试时触发的操作
            loadsir.showLoading()
            wenZhanDetailViewModel.getDetailData(id)
        }
        toolbar.run {
            initClose(titles) {
                nav().navigateUp()
            }
        }


    }

    override fun createObserver() {
        wenZhanDetailViewModel.detailDatas.observe(viewLifecycleOwner, Observer {
            wzdetail_title.text = it.title
            wzdetail_author.text = it.author
            wzdetail_time.text = it.addtime
            wzdetail_source.text = it.source
            wzdetail_tv.text = it.content.toHtml()
            loadsir.showSuccess()

        })
    }

    override fun lazyLoadData() {
        loadsir.showLoading()
        wenZhanDetailViewModel.getDetailData(id)
    }


}