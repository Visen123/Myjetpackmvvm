package com.visen.homemoudle.base.loadCallBack

import com.kingja.loadsir.callback.Callback
import com.visen.homemoudle.R


class EmptyCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_empty
    }

}