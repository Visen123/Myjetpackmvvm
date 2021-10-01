package com.visen.homemoudle.viewmodel

import androidx.lifecycle.MutableLiveData
import com.visen.homemoudle.api.HttpRequestCoroutine
import com.visen.homemoudle.bean.MyListBean
import com.visen.homemoudle.bean.WenZhanDataBean
import com.visen.homemoudle.ext.ListDataUiState
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel
import visen.yanyy.jetpackmvvm.ext.requestNoCheck
import visen.yanyy.jetpackmvvm.state.ResultState

/**
 * 作者　: yanyy
 * 时间　: 2019/12/23
 * 描述　:文章的请求ViewModel用协程的方式
 */
class WenZhanRequestViewModel : BaseViewModel() {

    //页码
    private var pageNo = 1
    private var pagecount = 1

    //方式1  自动脱壳过滤处理请求结果，判断结果是否成功
    var wenzhangResult = MutableLiveData<ResultState<WenZhanDataBean>>()
    var projectDataState: MutableLiveData<ListDataUiState<WenZhanDataBean.ListsBean>> =
        MutableLiveData()
    var mywenzhangDataState: MutableLiveData<ListDataUiState<MyListBean>> = MutableLiveData()
    fun getData(page: Int) {
        requestNoCheck(
            { HttpRequestCoroutine.getWenZhanData(page) }, wenzhangResult,
            true,
            "正在加载数据中..."
        )
    }


    fun getSanWenData(isRefresh: Boolean, isNew: Boolean = false) {
        if (pageNo > pagecount) {
            pageNo = 1
        }
        requestNoCheck({ HttpRequestCoroutine.getSanWenWZ(pageNo) }, {
            //请求成功
            pageNo++
            pagecount = it.pagecount
            val listDataUiState =
                ListDataUiState(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = false,
                    hasMore = pageNo <= it.pagecount,
                    isFirstEmpty = false,
                    listData = it.list
                )
            projectDataState.value = listDataUiState
        }, {
            //请求失败
            val listDataUiState =
                ListDataUiState(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = arrayListOf<WenZhanDataBean.ListsBean>()
                )
            projectDataState.value = listDataUiState
        })
    }


    fun getWZData(isRefresh: Boolean) {
        if (pageNo > pagecount) {
            pageNo = 1
        }
        requestNoCheck({ HttpRequestCoroutine.getGanWuWZ(pageNo) }, {
            //请求成功
            pageNo++
            pagecount = it.pagecount
            val listDataUiState =
                ListDataUiState(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = false,
                    hasMore = pageNo <= it.pagecount,
                    isFirstEmpty = false,
                    listData = it.list
                )
            mywenzhangDataState.value = listDataUiState
        }, {
            //请求失败
            val listDataUiState =
                ListDataUiState(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = arrayListOf<MyListBean>()
                )
            mywenzhangDataState.value = listDataUiState
        })
    }

    fun getTypeWZData(type: Int, isRefresh: Boolean) {
        if (pageNo > pagecount) {
            pageNo = 1
        }
        requestNoCheck({ HttpRequestCoroutine.getTypeWZ(type, pageNo) }, {
            //请求成功
            pageNo++
            pagecount = it.pagecount
            val listDataUiState =
                ListDataUiState(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = false,
                    hasMore = pageNo <= it.pagecount,
                    isFirstEmpty = false,
                    listData = it.list
                )
            mywenzhangDataState.value = listDataUiState
        }, {
            //请求失败
            val listDataUiState =
                ListDataUiState(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = arrayListOf<MyListBean>()
                )
            mywenzhangDataState.value = listDataUiState
        })
    }

}