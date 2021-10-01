package com.visen.homemoudle.bean

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 类名:  WZBean
 * 作者:  yanyiyun
 * 时间:  2021/9/28 11:38
 * 描述:
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class WZBean(
    var getstate: String,
    var action: String,
    var pageindex: Int,
    var pagesize: Int,
    var pagecount: Int,
    var rows: Int,
    var lists: Int,
    var time: String,
    var list: ArrayList<MyListBean>
) : Parcelable
