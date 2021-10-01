# Myjetpackmvvm
Android app完美架构：Jetpack+kotlin+MVVM+Retrofit+okhttp+dataBing+协程
- **基于MVVM模式集成谷歌官方推荐的JetPack组件库：LiveData、ViewModel、Lifecycle、Navigation组件**
- **使用kotlin语言，添加大量拓展函数，简化代码**
- **加入Retrofit网络请求,协程，帮你简化各种操作，让你快速请求网络**

### 网络请求：Retrofit+okhttp+协程
  实例见MainActivityXieCheng这个类
  示例如下：
  协程中 Retrofit http协议网络接口地址写法：（前面要加suspend挂起）
     // TODO: 推荐阅读文章
     这里Urls.CGMW_ALL_EDITORTJ是文章列表接口地址，即改为自己接口地址即可
      @GET(Urls.CGMW_ALL_EDITORTJ + "{page}.txt")
      suspend fun getAllWZ(@Path("page") page: Int): WenZhanDataBean

 kotlin协程如下：
 /**
  * net request 不校验请求结果数据是否是成功
  * @param block 请求体方法
  * @param resultState 请求回调的ResultState数据
  * @param isShowDialog 是否显示加载框
  * @param loadingMessage 加载框提示内容
  */
 fun <T> BaseViewModel.requestNoCheck(
     block: suspend () -> T,
     resultState: MutableLiveData<ResultState<T>>,
     isShowDialog: Boolean = false,
     loadingMessage: String = "请求网络中..."
 ): Job {
     return viewModelScope.launch {
         runCatching {
             if (isShowDialog) resultState.value = ResultState.onAppLoading(loadingMessage)
             //请求体
             block()
         }.onSuccess {
             resultState.paresResult(it)
         }.onFailure {
             it.message?.loge()
             resultState.paresException(it)
         }
     }
 }

### 网络请求：Retrofit+okhttp+RXjava
 实例见MainActivityRxjava这个类
 示例如下：

   Retrofit+okhttp+gson构建如下:

    public MyRetrofit() {
        TrustManagerFactory trustManagerFactory = null;
        try {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }

        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        }
        X509TrustManager trustManager = (X509TrustManager) trustManagers[0];
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{trustManager}, null);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        oc = new OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .connectTimeout(TIME, TimeUnit.MILLISECONDS)
                .readTimeout(TIME, TimeUnit.MILLISECONDS)
                .writeTimeout(TIME, TimeUnit.MILLISECONDS)
                .sslSocketFactory(sslSocketFactory, trustManager)
                .addNetworkInterceptor(OkhttpLoggerInterceptor.build())
                .addInterceptor(new HeaderInterceptor(false))
                .build();
        gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(oc)
                .build();
    }


    Retrofit http协议网络接口地址写法：
      // TODO: 阅读文章
       这里Urls.CGMW_ALL_EDITORTJ是文章列表接口地址，即改为自己接口地址即可
      @GET(Urls.CGMW_ALL_EDITORTJ + "{page}.txt")
      Observable<WenZhanBean> getStudyURL(@Path("page") int page);
    RXjava写法：
       /**
           * 基础网络请求
           *
           * @param observable
           * @param observer
           * @param <T>
           */
          public static <T> void networkRequest(Observable<T> observable, Observer<T> observer) {
              observable.compose(RxSchedulers.<T>io_main())
                      .subscribe(observer);
          }

### 架构 Jetpack+kotlin+MVVM+Retrofit+okhttp+dataBing+协程
具体做法请参考：com.visen.homemoudle.activity.MainActivity这个类文件
jetpack里navigation
要在fragment控件里加入
 1、android:name="visen.yanyy.jetpackmvvm.navigation.NavHostFragmentHideShow"
 2、  app:defaultNavHost="true"
 3、app:navGraph="@navigation/main_navation"

 如下所示：
       <fragment android:id="@+id/host_fragment"
                  android:name="visen.yanyy.jetpackmvvm.navigation.NavHostFragmentHideShow"
                  android:layout_width="match_parent"
                  android:layout_height="match_parent"
                  app:defaultNavHost="true"
                  app:navGraph="@navigation/main_navation" />


   实现导航调用方法：
    val nav = Navigation.findNavController(this@MainActivity, R.id.host_fragment)

### 注意：使用该请求方式时需要注意，如果该ViewModel并不是跟Activity/Fragment绑定的泛型ViewModel，而是
    val mainViewModel:MainViewModel by viewModels()
    或者
    val mainViewModel：MainViewModel by activityViewModels()
    获取的
    如果请求时要弹出loading，你需要在Activity | Fragment中添加以下代码：
    ### addLoadingObserve(viewModel)

### 打印日志开关
设置全局jetpackMvvmLog变量 是否打开请求日志，默认false不打印，如需要打印日志功能，请设值为 true