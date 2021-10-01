package visen.yanyy.jetpackmvvm.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import visen.yanyy.jetpackmvvm.base.viewmodel.BaseViewModel
import visen.yanyy.jetpackmvvm.ext.getVmClazz
import visen.yanyy.jetpackmvvm.network.manager.NetState
import visen.yanyy.jetpackmvvm.network.manager.NetworkStateManager

/**
 * 类名:  BaseDatabindActivity
 * 作者:  yanyiyun
 * 时间:  2021/9/19 13:50
 * 描述:
 */
abstract class BaseDatabindActivity<VM : BaseViewModel, DB : ViewDataBinding> :
    AppCompatActivity() {
    lateinit var databing: DB
    lateinit var mViewModel: VM
    abstract fun layoutId(): Int

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun showLoading(message: String = "请求网络中...")

    abstract fun dismissLoading()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        init(savedInstanceState)

    }

    private fun init(savedInstanceState: Bundle?) {
        mViewModel = createViewModel()
        registerUiChange()
        initView(savedInstanceState)
        createObserver()
        NetworkStateManager.instance.mNetworkStateCallback.observeInActivity(this, Observer {
            onNetworkStateChanged(it)
        })
    }

    /**
     * 创建viewModel
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVmClazz(this))
    }

    /**
     * 网络变化监听 子类重写
     */
    open fun onNetworkStateChanged(netState: NetState) {}

    /**
     * 创建LiveData数据观察者
     */
    abstract fun createObserver()

    /**
     * 注册UI 事件
     */
    private fun registerUiChange() {
        //显示弹窗
        mViewModel.loadingChange.showDialog.observeInActivity(this, Observer {
            showLoading(it)
        })
        //关闭弹窗
        mViewModel.loadingChange.dismissDialog.observeInActivity(this, Observer {
            dismissLoading()
        })
    }

    /**
     * 将非该Activity绑定的ViewModel添加 loading回调 防止出现请求时不显示 loading 弹窗bug
     * @param viewModels Array<out BaseViewModel>
     */
    protected fun addLoadingObserve(vararg viewModels: BaseViewModel) {
        viewModels.forEach { viewModel ->
            //显示弹窗
            viewModel.loadingChange.showDialog.observeInActivity(this, Observer {
                showLoading(it)
            })
            //关闭弹窗
            viewModel.loadingChange.dismissDialog.observeInActivity(this, Observer {
                dismissLoading()
            })
        }
    }


    private fun initDataBinding() {
        databing = DataBindingUtil.setContentView(this, layoutId())
        databing.lifecycleOwner = this
    }
}