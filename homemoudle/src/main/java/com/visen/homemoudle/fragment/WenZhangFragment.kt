package com.visen.homemoudle.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ConvertUtils
import com.kingja.loadsir.core.LoadService
import com.visen.homemoudle.R
import com.visen.homemoudle.adapter.MyWenZhanAdapter
import com.visen.homemoudle.api.ApiService
import com.visen.homemoudle.base.fragment.MyBaseFragment
import com.visen.homemoudle.bean.MyListBean
import com.visen.homemoudle.databinding.FragmentWenzhangBinding
import com.visen.homemoudle.ext.*
import com.visen.homemoudle.ext.CHsData.Companion.DetailData
import com.visen.homemoudle.utils.SpaceItemDecoration
import com.visen.homemoudle.viewmodel.WenZhanRequestViewModel
import com.yanzhenjie.recyclerview.SwipeRecyclerView
import kotlinx.android.synthetic.main.include_recyclerview.*
import visen.yanyy.jetpackmvvm.ext.nav
import visen.yanyy.jetpackmvvm.ext.navigateAction


class WenZhangFragment : MyBaseFragment<WenZhanRequestViewModel, FragmentWenzhangBinding>() {

    var mList: MutableList<MyListBean> = arrayListOf()

    //请求的ViewModel
    private val requestProjectViewModel: WenZhanRequestViewModel by viewModels()
    private val adapters: MyWenZhanAdapter by lazy {
        MyWenZhanAdapter(
            R.layout.item_category_list,
            mList
        )
    }

    //界面状态管理者
    private lateinit var loadsir: LoadService<Any>

    //recyclerview的底部加载view 因为在首页要动态改变他的颜色，所以加了他这个字段
    private lateinit var footView: DefineLoadMoreView
    private var type = 0

    override fun layoutId(): Int {
        return R.layout.fragment_wenzhang
    }

    override fun initView(savedInstanceState: Bundle?) {
        arguments?.let {
            type = it.getInt(ApiService.TYPES)
        }
        loadsir = loadServiceInit(swipeRefresh) {
            //点击重试时触发的操作
            loadsir.showLoading()
            requestProjectViewModel.getTypeWZData(type, true)
        }

        //初始化recyclerView
        recyclerView.init(LinearLayoutManager(context), adapters).let {
            //因为首页要添加轮播图，所以我设置了firstNeedTop字段为false,即第一条数据不需要设置间距
            it.addItemDecoration(SpaceItemDecoration(0, ConvertUtils.dp2px(8f), false))
            footView = it.initFooter(SwipeRecyclerView.LoadMoreListener {
                requestProjectViewModel.getTypeWZData(type, false)
            })
        }
        //初始化 SwipeRefreshLayout
        swipeRefresh.init {
            //触发刷新监听时请求数据
            requestProjectViewModel.getTypeWZData(type, true)
        }

        adapters.run {
            setOnItemClickListener { adapter, view, position ->
                nav().navigateAction(R.id.action_to_wenzhangdetail, Bundle().apply {
                    putParcelable(
                        DetailData,
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
            mywenzhangDataState.observe(viewLifecycleOwner, Observer { data ->
                loadListData(data, adapters, loadsir, recyclerView, swipeRefresh)
            })
        }


    }

    override fun lazyLoadData() {
        loadsir.showLoading()
        requestProjectViewModel.getTypeWZData(type, true)
    }


    companion object {
        fun newInstance(type: Int): WenZhangFragment {
            val args = Bundle()
            args.putInt(ApiService.TYPES, type)
            val fragment = WenZhangFragment()
            fragment.arguments = args
            return fragment

        }
    }

}