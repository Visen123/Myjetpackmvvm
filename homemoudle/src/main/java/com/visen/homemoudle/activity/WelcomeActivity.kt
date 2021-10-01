package com.visen.homemoudle.activity

import android.content.Intent
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.visen.homemoudle.R
import com.visen.homemoudle.adapter.WelcomeBannerAdapter
import com.visen.homemoudle.adapter.WelcomeBannerViewHolder
import com.visen.homemoudle.base.activity.BaseActivity
import com.visen.homemoudle.base.event.CacheUtil
import com.visen.homemoudle.base.event.SettingUtil
import com.visen.homemoudle.databinding.ActivityWelcomeBinding
import com.zhpan.bannerview.BannerViewPager
import kotlinx.android.synthetic.main.activity_welcome.*
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel
import visen.yanyy.jetpackmvvm.ext.view.gone
import visen.yanyy.jetpackmvvm.ext.view.visible

/**
 * 作者　:yanyy
 * 时间　: 2020/2/22
 * 描述　:欢迎界面
 */
@Suppress("DEPRECATED_IDENTITY_EQUALS")
class WelcomeActivity : BaseActivity<BaseViewModel, ActivityWelcomeBinding>() {

    private var resList = arrayOf("哈哈", "开心", "欢迎")

    private lateinit var mViewPager: BannerViewPager<String, WelcomeBannerViewHolder>

    override fun layoutId() = R.layout.activity_welcome

    override fun initView(savedInstanceState: Bundle?) {
        //防止出现按Home键回到桌面时，再次点击重新进入该界面bug
        if (intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT !== 0) {
            finish()
            return
        }
        mDatabind.click = ProxyClick()
        welcome_baseview.setBackgroundColor(SettingUtil.getColor(this))
        mViewPager = findViewById(R.id.banner_view)
        if (CacheUtil.isFirst()) {
            //是第一次打开App 显示引导页
            welcome_image.gone()
            mViewPager.apply {
                adapter = WelcomeBannerAdapter()
                setLifecycleRegistry(lifecycle)
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        if (position == resList.size - 1) {
                            welcomeJoin.visible()
                        } else {
                            welcomeJoin.gone()
                        }
                    }
                })
                create(resList.toList())
            }
        } else {
            //不是第一次打开App 0.3秒后自动跳转到主页
            welcome_image.visible()
            mViewPager.postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                //带点渐变动画
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }, 300)
        }
    }

    inner class ProxyClick {
        fun toMain() {
            CacheUtil.setFirst(false)
            startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
            finish()
            //带点渐变动画
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }

}