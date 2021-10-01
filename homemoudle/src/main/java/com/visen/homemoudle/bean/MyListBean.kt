package com.visen.homemoudle.bean

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 类名:  MyListBean
 * 作者:  yanyiyun
 * 时间:  2021/9/28 11:44
 * 描述:
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class MyListBean(
    val addtime: String,
    val author: String,
    val bads: Int,
    val classname: String,
    val dpcount: Int,
    val dpfen: String,
    val goods: Int,
    val headurl: String,
    val hits: String,
    val id: String,
    val sd: String,
    val sht: String,
    val summary: String,
    val title: String,
    val userid: String,
    val xw: String
) : Parcelable

