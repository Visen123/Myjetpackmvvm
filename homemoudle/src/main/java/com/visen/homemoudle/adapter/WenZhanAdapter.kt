package com.visen.homemoudle.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.visen.homemoudle.R
import com.visen.homemoudle.bean.WenZhanBean
import com.visen.homemoudle.utils.GlideImage

/**
 * 类名:  WenZhanAdapter4
 * 作者:  yanyiyun
 * 时间:  2021/9/13 23:15
 * 描述:
 */
class WenZhanAdapter(layoutResId: Int, data: MutableList<WenZhanBean.ListBean>?) :
    BaseQuickAdapter<WenZhanBean.ListBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(holder: BaseViewHolder, item: WenZhanBean.ListBean) {
        holder.setText(R.id.tv_cy_title, item.getTitle())
        holder.setText(R.id.tv_cy_time, item.getSht())
        val img: ImageView = holder.getView(R.id.item_img)
        GlideImage.LoaderNetHead(context, item.getHeadurl(), img)
    }
}