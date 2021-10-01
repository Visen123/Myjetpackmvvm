package com.visen.homemoudle.utils

import android.app.Activity
import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo
import android.content.Context
import android.os.Process
import java.util.*

/**
 * on 2016/1/25.
 */
class AppManager private constructor() {
    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity?) {
        if (activityStack == null) {
            activityStack = Stack()
        }
        activityStack!!.add(activity)
    }

    fun removeActivity(activity: Activity?) {
        if (activityStack != null && activityStack!!.contains(activity)) {
            activityStack!!.remove(activity)
        }
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    val currentActivity: Activity?
        get() {
            if (activityStack == null || activityStack!!.size == 0) {
                return null
            }
            val activity = activityStack!!.lastElement()
            if (activity!!.isFinishing) {
                removeActivity(activity)
                return currentActivity
            }
            return activity
        }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishCurrentActivity() {
        var activity = activityStack!!.lastElement()
        if (activity != null) {
            activity.finish()
            activity = null
        }
    }

    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity: Activity?) {
        var activity = activity
        if (activity != null) {
            activityStack!!.remove(activity)
            activity.finish()
            activity = null
        }
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        var i = 0
        val size = activityStack!!.size
        while (i < size) {
            if (null != activityStack!![i]) {
                activityStack!![i]!!.finish()
            }
            i++
        }
        activityStack!!.clear()
    }

    /**
     * 退出应用程序
     */
    fun exitApp(context: Context) {
        try {
            finishAllActivity()
            val activityMgr = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            activityMgr.restartPackage(context.packageName)
            //context.stopService(new Intent(context, PlayService.class));
        } catch (e: Exception) {
            Process.killProcess(Process.myPid()) //获取PID
            System.exit(0) //常规java、c#的标准退出法，返回值为0代表正常退出
            e.printStackTrace()
        }
    }

    companion object {
        private var activityStack: Stack<Activity?>? = null
        private var instance: AppManager? = null

        /**
         * 单一实例
         */
        val appManager: AppManager?
            get() {
                if (instance == null) {
                    instance = AppManager()
                }
                return instance
            }

        //获取正在运行的activity名称
        val runningActivityName: String
            get() {
                val activityManager =
                    appManager!!.currentActivity!!.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
                return activityManager.getRunningTasks(1)[0].topActivity!!.className
            }

        //返回是否是remoteService
        fun isRemoteService(context: Context): Boolean {
            val pid = Process.myPid()
            val processAppName = getAppName(context, pid)
            return processAppName == null || !processAppName.equals(
                context.packageName,
                ignoreCase = true
            )
        }

        fun getAppName(context: Context, pid: Int): String? {
            var processName: String? = null
            val am = context.getSystemService(Activity.ACTIVITY_SERVICE) as ActivityManager
            val l: List<*> = am.runningAppProcesses
            val i = l.iterator()
            val pm = context.packageManager
            while (i.hasNext()) {
                val info = i.next() as RunningAppProcessInfo
                try {
                    if (info.pid == pid) {
                        processName = info.processName
                        return processName
                    }
                } catch (e: Exception) {
                    // Log.d("Process", "Error>> :"+ e.toString());
                }
            }
            return processName
        }
    }
}