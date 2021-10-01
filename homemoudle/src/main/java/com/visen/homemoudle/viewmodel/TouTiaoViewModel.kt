package com.visen.homemoudle.viewmodel

import androidx.lifecycle.MutableLiveData
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel

/**
 * 类名:  TouTiaoViewModel
 * 作者:  yanyiyun
 * 时间:  2021/9/22 18:14
 * 描述:
 */
class TouTiaoViewModel : BaseViewModel() {

    //private var mList= arrayListOf("美文","小说","推荐","最新","每日一文")
    private val TITLES = arrayListOf("推荐", "散文", "感悟", "励志", "爱情")
    var wenzhangTitle = MutableLiveData<List<String>>()

    fun getTitle() {
        wenzhangTitle.value = TITLES
    }
}