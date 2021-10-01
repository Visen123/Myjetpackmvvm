package com.visen.homemoudle.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kingja.loadsir.core.LoadService
import com.visen.homemoudle.R
import com.visen.homemoudle.base.fragment.MyBaseFragment
import com.visen.homemoudle.databinding.FragmentToutiaoBinding
import com.visen.homemoudle.ext.bindViewPager2
import com.visen.homemoudle.ext.init
import com.visen.homemoudle.ext.loadServiceInit
import com.visen.homemoudle.ext.showLoading
import com.visen.homemoudle.viewmodel.TouTiaoViewModel
import kotlinx.android.synthetic.main.fragment_toutiao.*

class TouTiaoFragment : MyBaseFragment<TouTiaoViewModel, FragmentToutiaoBinding>() {

    //界面状态管理者
    private lateinit var loadsir: LoadService<Any>

    // private var mList= arrayListOf("美文","小说","推荐","最新","每日一文")
    private val touTiaoViewModel: TouTiaoViewModel by viewModels()

    //fragment集合
    var fragments: ArrayList<Fragment> = arrayListOf()

    //标题集合
    var mDataList: ArrayList<String> = arrayListOf()


    override fun layoutId(): Int {
        return R.layout.fragment_toutiao
    }

    override fun initView(savedInstanceState: Bundle?) {
        //状态页配置
        loadsir = loadServiceInit(view_pager) {
            //点击重试时触发的操作
            loadsir.showLoading()
            touTiaoViewModel.getTitle()

        }
        //初始化viewpager2
        view_pager.init(this, fragments)
        //初始化 magic_indicator
        magic_indicator.bindViewPager2(view_pager, mDataList)

    }

    override fun createObserver() {
        touTiaoViewModel.wenzhangTitle.observe(viewLifecycleOwner, Observer {
            fragments.clear()
            mDataList.clear()
            mDataList.addAll(it)
            it.forEachIndexed { index, data ->
                fragments.add(WenZhangFragment.newInstance(index))
            }

            magic_indicator.navigator.notifyDataSetChanged()
            view_pager.adapter?.notifyDataSetChanged()
            view_pager.offscreenPageLimit = fragments.size
            loadsir.showSuccess()
        })

        /*   mList.forEach { data ->
               fragments.add(WenZhangFragment())
           }
           magic_indicator.navigator.notifyDataSetChanged()
           view_pager.adapter?.notifyDataSetChanged()
           view_pager.offscreenPageLimit = fragments.size
           loadsir.showSuccess()*/
    }

    override fun lazyLoadData() {
        loadsir.showLoading()
        touTiaoViewModel.getTitle()
    }


}