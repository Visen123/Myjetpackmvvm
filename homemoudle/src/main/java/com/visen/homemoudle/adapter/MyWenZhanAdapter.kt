package com.visen.homemoudle.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.visen.homemoudle.R
import com.visen.homemoudle.bean.MyListBean
import com.visen.homemoudle.utils.GlideImage

/**
 * 类名:  MyWenZhanAdapter
 * 作者:  yanyiyun
 * 时间:  2021/9/13 23:15
 * 描述:
 */
class MyWenZhanAdapter(layoutResId: Int, data: MutableList<MyListBean>) :
    BaseQuickAdapter<MyListBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(holder: BaseViewHolder, item: MyListBean) {
        holder.setText(R.id.tv_cy_title, item.title)
        holder.setText(R.id.tv_cy_time, item.sht)
        val img: ImageView = holder.getView(R.id.item_img)
        GlideImage.LoaderNetHead(context, item.headurl, img)
    }
}