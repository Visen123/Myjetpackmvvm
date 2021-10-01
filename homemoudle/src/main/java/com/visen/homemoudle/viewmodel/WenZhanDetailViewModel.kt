package com.visen.homemoudle.viewmodel

import androidx.lifecycle.MutableLiveData
import com.visen.homemoudle.api.HttpRequestCoroutine
import com.visen.homemoudle.bean.WZDetailBean
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel
import visen.yanyy.jetpackmvvm.ext.requestNoCheck

/**
 * 类名:  WenZhanDetailViewModel
 * 作者:  yanyiyun
 * 时间:  2021/9/28 13:58
 * 描述:
 */
class WenZhanDetailViewModel : BaseViewModel() {
    var detailDatas = MutableLiveData<WZDetailBean>()

    fun getDetailData(id: String) {

        requestNoCheck(
            { HttpRequestCoroutine.getDetail(id) },
            {
                detailDatas.value = it
            }

        )
    }

}