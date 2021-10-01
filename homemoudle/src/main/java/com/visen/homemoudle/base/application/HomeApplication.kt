package com.visen.homemoudle.base.application

import android.text.TextUtils
import androidx.multidex.MultiDex
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir
import com.tencent.mmkv.MMKV
import com.visen.homemoudle.BuildConfig
import com.visen.homemoudle.base.loadCallBack.EmptyCallback
import com.visen.homemoudle.base.loadCallBack.ErrorCallback
import com.visen.homemoudle.base.loadCallBack.LoadingCallback
import com.visen.homemoudle.base.viewmodel.AppViewModel
import com.visen.homemoudle.utils.SPUtil
import visen.yanyy.jetpackmvvm.base.BaseApp
import visen.yanyy.jetpackmvvm.ext.util.jetpackMvvmLog
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

/**
 * 类名:  HomeApplication
 * 作者:  yanyiyun
 * 时间:  2021/9/13 20:34
 * 描述:
 */

//Application全局的ViewModel，里面存放了一些账户信息，基本配置信息等
val appViewModel: AppViewModel by lazy { HomeApplication.appViewModelInstance }

class HomeApplication : BaseApp() {

    companion object {
        lateinit var instance: HomeApplication
        lateinit var appViewModelInstance: AppViewModel
    }

    override fun onCreate() {
        super.onCreate()
        SPUtil.init(this)
        MMKV.initialize(this.filesDir.absolutePath + "/mmkv")
        instance = this
        appViewModelInstance = getAppViewModelProvider().get(AppViewModel::class.java)
        MultiDex.install(this)
        //界面加载管理 初始化
        LoadSir.beginBuilder()
            .addCallback(LoadingCallback())//加载
            .addCallback(ErrorCallback())//错误
            .addCallback(EmptyCallback())//空
            .setDefaultCallback(SuccessCallback::class.java)//设置默认加载状态页
            .commit()
        jetpackMvvmLog = BuildConfig.DEBUG

    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    fun getProcessName(pid: Int): String? {
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(FileReader("/proc/$pid/cmdline"))
            var processName = reader.readLine()
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim { it <= ' ' }
            }
            return processName
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        } finally {
            try {
                reader?.close()
            } catch (exception: IOException) {
                exception.printStackTrace()
            }

        }
        return null
    }

}