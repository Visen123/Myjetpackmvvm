package com.visen.homemoudle.base.viewmodel

import com.kunminx.architecture.ui.callback.UnPeekLiveData
import com.visen.homemoudle.base.event.CacheUtil
import com.visen.homemoudle.base.event.SettingUtil
import com.visen.homemoudle.base.event.UserInfo
import visen.yanyy.jetpackmvvm.base.appContext
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel
import visen.yanyy.jetpackmvvm.callback.livedata.event.EventLiveData

/**
 * 类名:  AppViewModelss
 * 作者:  yanyiyun
 * 时间:  2021/9/21 0:37
 * 描述:
 */
class AppViewModel : BaseViewModel() {
    //App的账户信息
    var userInfo = UnPeekLiveData.Builder<UserInfo>().setAllowNullValue(true).create()

    //App主题颜色 中大型项目不推荐以这种方式改变主题颜色，比较繁琐耦合，且容易有遗漏某些控件没有设置主题色
    var appColor = EventLiveData<Int>()

    //App 列表动画
    var appAnimation = EventLiveData<Int>()

    init {
        //默认值保存的账户信息，没有登陆过则为null
        userInfo.value = CacheUtil.getUser()
        //默认值颜色
        appColor.value = SettingUtil.getColor(appContext)
        //初始化列表动画
        appAnimation.value = SettingUtil.getListMode()
    }
}