import android.text.TextUtils
import com.visen.homemoudle.api.HomeApi
import com.visen.homemoudle.bean.WenZhanBean
import com.visen.homemoudle.net.RetrofitFactory
import com.visen.homemoudle.net.runRxLambda
import com.visen.homemoudle.utils.GsonUtil


object NetRequests {
    // TODO: 2020/4/01
    fun getStartSleep(page: Int, success: (WenZhanBean?) -> Unit) {
        runRxLambda(RetrofitFactory.getServices(HomeApi::class.java).getSWURL(page), {
            val json = String(it.bytes())
            if (!TextUtils.isEmpty(json)) {
                //val obj = JSONObject(json)
                val meiWenModel = GsonUtil.buildGson().fromJson(json, WenZhanBean::class.java)
                success(meiWenModel)
            }

        }, {
            success(null)
        })

    }
}