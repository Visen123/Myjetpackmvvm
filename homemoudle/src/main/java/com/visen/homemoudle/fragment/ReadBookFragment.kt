package com.visen.homemoudle.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ConvertUtils
import com.kingja.loadsir.core.LoadService
import com.visen.homemoudle.R
import com.visen.homemoudle.adapter.WenZhanAdapter4
import com.visen.homemoudle.base.fragment.MyBaseFragment
import com.visen.homemoudle.bean.WenZhanDataBean
import com.visen.homemoudle.databinding.FragmentReadbookBinding
import com.visen.homemoudle.ext.*
import com.visen.homemoudle.utils.SpaceItemDecoration
import com.visen.homemoudle.viewmodel.TouTiaoViewModel
import com.visen.homemoudle.viewmodel.WenZhanRequestViewModel
import com.yanzhenjie.recyclerview.SwipeRecyclerView
import kotlinx.android.synthetic.main.include_recyclerview.*
import visen.yanyy.jetpackmvvm.ext.nav
import visen.yanyy.jetpackmvvm.ext.navigateAction

class ReadBookFragment : MyBaseFragment<TouTiaoViewModel, FragmentReadbookBinding>() {
    var mList: MutableList<WenZhanDataBean.ListsBean> = arrayListOf()

    //请求的ViewModel
    private val requestProjectViewModel: WenZhanRequestViewModel by viewModels()
    private val adapters: WenZhanAdapter4 by lazy {
        WenZhanAdapter4(
            R.layout.item_category_list,
            mList
        )
    }

    //界面状态管理者
    private lateinit var loadsir: LoadService<Any>

    //recyclerview的底部加载view 因为在首页要动态改变他的颜色，所以加了他这个字段
    private lateinit var footView: DefineLoadMoreView

    override fun layoutId() = R.layout.fragment_readbook

    override fun initView(savedInstanceState: Bundle?) {
        loadsir = loadServiceInit(swipeRefresh) {
            //点击重试时触发的操作
            loadsir.showLoading()
            requestProjectViewModel.getSanWenData(true)
        }

        //初始化recyclerView
        recyclerView.init(LinearLayoutManager(context), adapters).let {
            //因为首页要添加轮播图，所以我设置了firstNeedTop字段为false,即第一条数据不需要设置间距
            it.addItemDecoration(SpaceItemDecoration(0, ConvertUtils.dp2px(8f), false))
            footView = it.initFooter(SwipeRecyclerView.LoadMoreListener {
                requestProjectViewModel.getSanWenData(false)
            })
        }
        //初始化 SwipeRefreshLayout
        swipeRefresh.init {
            //触发刷新监听时请求数据
            requestProjectViewModel.getSanWenData(true)
        }

        adapters.run {
            setOnItemClickListener { adapter, view, position ->
                nav().navigateAction(R.id.action_to_choiceness, Bundle().apply {
                    putSerializable(
                        CHsData.DetailData,
                        adapters.data[position]
                    )
                })
            }
        }


    }

    override fun createObserver() {
        requestProjectViewModel.run {
            //监听全局的列表动画改编
            adapters.setAdapterAnimation(2)
            projectDataState.observe(viewLifecycleOwner, Observer { data ->
                loadListData(data, adapters, loadsir, recyclerView, swipeRefresh)
            })
        }

    }

    override fun lazyLoadData() {
        loadsir.showLoading()
        requestProjectViewModel.getSanWenData(true)
    }
}