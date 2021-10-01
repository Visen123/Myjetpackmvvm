package com.visen.homemoudle.net

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.visen.homemoudle.utils.GlideRoundTransform
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *  .
 * date: On 2017/9/15
 * 用于添加扩展方法
 */
inline fun Any.deBug(msg: String) = Log.e("${this.javaClass.simpleName}------->", msg)

inline fun Activity.glide(path: String, view: ImageView) = Glide.with(this).load(path).into(view)!!

inline fun Fragment.glide(path: String, view: ImageView) = Glide.with(this).load(path).into(view)!!

inline fun glide(context: Context, path: String, view: ImageView) =
    Glide.with(context).load(path).into(view)

inline fun glide(context: Context, path: Int, view: ImageView) =
    Glide.with(context).load(path).into(view)

inline fun glideRound(context: Context, path: Int, view: ImageView) =
    Glide.with(context).load(path).transform(
        GlideRoundTransform(5)
    ).into(view)

inline fun glideRound(context: Context, path: String, view: ImageView) =
    Glide.with(context).load(path).transform(GlideRoundTransform(5)).into(view)

inline fun glideRound(context: Context, path: Int, view: ImageView, value: Int) =
    Glide.with(context).load(path).transform(GlideRoundTransform(value)).into(view)

inline fun glideRound(context: Context, path: String, view: ImageView, value: Int) =
    Glide.with(context).load(path).transform(GlideRoundTransform(value)).into(view)


inline fun isEmtry(s: String): Boolean = TextUtils.isEmpty(s)

inline fun isEmtry(s: TextView): Boolean = TextUtils.isEmpty(s.text)

inline fun <T> runRxLambda(
    observable: Observable<T>,
    crossinline next: (T) -> Unit,
    crossinline error: (e: Throwable?) -> Unit,
    noinline completed: () -> Unit = { Log.e("completed", "completed") }
) {
    observable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(object : Observer<T> {
            override fun onComplete() {
                completed()
            }

            override fun onError(e: Throwable) {
                error(e)
            }

            override fun onNext(value: T) {
                try {
                    next(value)
                } catch (e: Exception) {
                    error(null)
                }
            }

            override fun onSubscribe(d: Disposable) {
            }
        })
}

inline fun cTry(block: () -> Unit) {
    try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
        Log.e("ctry_error", e.message.toString())
    }
}