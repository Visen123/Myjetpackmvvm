package com.visen.homemoudle.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kingja.loadsir.core.LoadService
import com.visen.homemoudle.R
import com.visen.homemoudle.base.fragment.MyBaseFragment
import com.visen.homemoudle.bean.WenZhanDataBean
import com.visen.homemoudle.databinding.FragmentChoicenessBinding
import com.visen.homemoudle.ext.CHsData
import com.visen.homemoudle.ext.initClose
import com.visen.homemoudle.ext.loadServiceInit
import com.visen.homemoudle.ext.showLoading
import com.visen.homemoudle.viewmodel.WenZhanDetailViewModel
import kotlinx.android.synthetic.main.fragment_choiceness.*
import kotlinx.android.synthetic.main.include_toolbar.*
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel
import visen.yanyy.jetpackmvvm.ext.nav
import visen.yanyy.jetpackmvvm.ext.util.toHtml

/**
 * 作者: yanyy
 * 时间: 2021/9/20 13:46
 * 描述: 精选栏目
 */


class ChoicenessFragment : MyBaseFragment<BaseViewModel, FragmentChoicenessBinding>() {

    private val wenZhanDetailViewModel: WenZhanDetailViewModel by viewModels()

    //界面状态管理者
    private lateinit var loadsir: LoadService<Any>
    private var id = ""
    private var titles = ""
    override fun layoutId(): Int {
        return R.layout.fragment_choiceness
    }


    override fun initView(savedInstanceState: Bundle?) {
        arguments?.run {
            val listBean = getSerializable(CHsData.DetailData) as WenZhanDataBean.ListsBean
            listBean.let {
                id = it.id!!
                titles = it.title!!
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