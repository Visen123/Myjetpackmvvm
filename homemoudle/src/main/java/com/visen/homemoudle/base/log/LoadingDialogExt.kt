package com.visen.homemoudle.base.log

import android.app.Activity
import android.os.Build
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.visen.homemoudle.R

/**
 * @date : 2020/6/28
 */

//loading框
private var loadingDialog: MaterialDialog? = null

/**
 * 打开等待框
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun AppCompatActivity.showLoadingExt(message: String = "请求网络中") {
    if (!this.isFinishing) {
        if (loadingDialog == null) {
            loadingDialog = MaterialDialog(this)
                .cancelable(true)
                .cancelOnTouchOutside(false)
                .cornerRadius(12f)
                .customView(R.layout.layout_custom_progress_dialog_view)
                .lifecycleOwner(this)
            loadingDialog?.getCustomView()?.run {
                this.findViewById<TextView>(R.id.loading_tips).text = message
            }
        }
        loadingDialog?.show()
    }
}

/**
 * 打开等待框
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Fragment.showLoadingExt(message: String = "请求网络中") {
    activity?.let {
        if (!it.isFinishing) {
            if (loadingDialog == null) {
                loadingDialog = MaterialDialog(it)
                    .cancelable(true)
                    .cancelOnTouchOutside(false)
                    .cornerRadius(12f)
                    .customView(R.layout.layout_custom_progress_dialog_view)
                    .lifecycleOwner(this)
                loadingDialog?.getCustomView()?.run {
                    this.findViewById<TextView>(R.id.loading_tips).text = message
                }
            }
            loadingDialog?.show()
        }
    }
}

/**
 * 关闭等待框
 */
fun Activity.dismissLoadingExt() {
    loadingDialog?.dismiss()
    loadingDialog = null
}

/**
 * 关闭等待框
 */
fun Fragment.dismissLoadingExt() {
    loadingDialog?.dismiss()
    loadingDialog = null
}
