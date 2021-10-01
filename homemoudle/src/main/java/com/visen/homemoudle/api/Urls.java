package com.visen.homemoudle.api;


import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 严益云 on 2020/12/01.
 */

public class Urls {

    // TODO: 阅读列表文章
    public static final String CGMW_ALL_EDITORTJ = "txtjson/classgroup/cgmw_all_editortj_";

    public static final String SWURL = "txtjson/classgroup/cgmw_sanwen_editortj_";

    //todo 开发环境
    public static final String BASE_URL = "http://www.duwenz.com/";

    /**
     * 获取完整地址
     *
     * @param curl 主地址
     * @param file 需要拼接的相对地址
     * @return 返回完整链接
     */
    public static String getBaseUrl(String curl, String file) {
        if (file == null || file.startsWith("http")) {
            return file;
        }
        String q = "";
        try {
            URL url = new URL(new URL(curl), file);
            q = url.toExternalForm();
        } catch (MalformedURLException e) {

        }
        if (q.indexOf("#") != -1) {
            q = q.replaceAll("^(.+?)#.*?$", "$1");
        }
        return q;
    }


    public static String getURL(String url) {
        String mURL = BASE_URL;
        if (url == null || url.startsWith("http")) {
            mURL = url;
        } else {
            mURL = BASE_URL + url;
        }
        return mURL;
    }


}