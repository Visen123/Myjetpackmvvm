package com.visen.homemoudle.fragment

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import com.just.agentweb.AgentWeb
import com.visen.homemoudle.R
import com.visen.homemoudle.base.fragment.MyBaseFragment
import com.visen.homemoudle.databinding.FragmentWebBinding
import com.visen.homemoudle.ext.CHsData.Companion.WEB_URL
import kotlinx.android.synthetic.main.fragment_web.*
import kotlinx.android.synthetic.main.include_toolbar.*
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel
import visen.yanyy.jetpackmvvm.ext.nav

/**
 * 作者: yanyy
 * 时间: 2021/9/28 13:46
 * 描述: 网页
 */

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class WebFragment : MyBaseFragment<BaseViewModel, FragmentWebBinding>() {

    private var mAgentWeb: AgentWeb? = null

    private var preWeb: AgentWeb.PreAgentWeb? = null

    override fun layoutId(): Int {
        return R.layout.fragment_web
    }

    override fun initView(savedInstanceState: Bundle?) {
        toolbar.run {
            /*initClose("网页"){
                nav().navigateUp()
            }*/
            title = "我的博客"
        }
        preWeb = AgentWeb.with(this)
            .setAgentWebParent(web_linear, LinearLayout.LayoutParams(-1, -1))
            .useDefaultIndicator()
            .createAgentWeb()
            .ready()
    }

    override fun lazyLoadData() {
        //加载网页
        mAgentWeb = preWeb?.go(WEB_URL)
        requireActivity().onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    mAgentWeb?.let { web ->
                        if (web.webCreator.webView.canGoBack()) {
                            web.webCreator.webView.goBack()
                        } else {
                            nav().navigateUp()
                        }
                    }
                }
            })
    }


    override fun onPause() {
        mAgentWeb?.webLifeCycle?.onPause()
        super.onPause()
    }

    override fun onResume() {
        mAgentWeb?.webLifeCycle?.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        mAgentWeb?.webLifeCycle?.onDestroy()
        mActivity.setSupportActionBar(null)
        super.onDestroy()
    }


}