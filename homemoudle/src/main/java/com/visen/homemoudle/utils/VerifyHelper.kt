package com.visen.homemoudle.utils

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import android.widget.CheckBox
import android.widget.TextView
import java.util.regex.Pattern

/**
 * @作者 严益云
 * @创建日期 2020/11/24
 * 验证手机号，验证码，昵称，邮箱，姓名等
 */
object VerifyHelper {
    /**
     * 验证手机格式
     */
    fun judgePhoneNumber(phone: String): Boolean {
//        String telRegex = "[1][34578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        val telRegex = "[1]\\d{10}" //"[1]"代表第1位为数字1，\\d{10}"代表后面是可以是0～9的数字，有10位。
        return phone.matches(Regex(telRegex))
    }

    /**
     * 验证合法密碼
     *
     * @return
     */
    fun checkPassWord(character: String?): Boolean {
        var flag = false
        flag = try {
            val check = "[a-zA-Z0-9_.]{3,20}"
            val regex = Pattern.compile(check)
            val matcher = regex.matcher(character)
            matcher.matches()
        } catch (e: Exception) {
            false
        }
        return flag
    }

    /**
     * 手机验证密碼格式
     *
     * @return
     */
    fun checkVerifyPassWord(character: String?): Boolean {
        var flag = false
        flag = try {
            val check = "[0-9]{6}"
            val regex = Pattern.compile(check)
            val matcher = regex.matcher(character)
            matcher.matches()
        } catch (e: Exception) {
            false
        }
        return flag
    }

    /**
     * 验证手机号码
     *
     * @return
     */
    fun checkMobileNumber(mobileNumber: String?): Boolean {
        var flag = false
        flag = try {
            val regex = Pattern
                .compile("^(((13[0-9])|(14[0-9])|(15([0-9]))|(17[0-9])|(18[0-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$")
            val matcher = regex.matcher(mobileNumber)
            matcher.matches()
        } catch (e: Exception) {
            false
        }
        return flag
    }

    /**
     * 判断昵称，匹配中文，英文字母和数字及下划线:
     *
     * @param nickname
     * @return
     */
    fun isNicknameValid(nickname: String?): Boolean {
        /*String reg = "\\w+$";
        Pattern pat = Pattern.compile(reg);
        Matcher mat = pat.matcher(nickname.trim());
        return !TextUtils.isEmpty(nickname) && nickname.length() <= 10 && mat.matches();*/
        val reg = "[\\u4e00-\\u9fa5_a-zA-Z0-9_]{1,10}"
        val pat = Pattern.compile(reg)
        val mat = pat.matcher(nickname)
        return mat.matches()
    }

    /**
     * 验证验证码格式
     *
     * @return
     */
    fun judgeVerificationCode(code: String): Boolean {
        val codeRegex = "\\d{4}"
        val regex = Regex(codeRegex);
        return if (TextUtils.isEmpty(code)) {
            false
        } else code.matches(regex)
    }

    /**
     * 判断是否是url地址
     *
     * @param url
     * @return
     */
    fun isUrl(url: String?): Boolean {
//        String codeRegex = "^((https|http|ftp|rtsp|mms)?:\\/\\/)[^\\s]+";
//
//        if (TextUtils.isEmpty(url)){
//            return false;
//        }
//        return url.matches(codeRegex);
        return Patterns.WEB_URL.matcher(url).matches()
    }

    /**
     * 验证邮箱格式
     *
     * @param mail
     * @return
     */
    fun judgeMail(mail: String?): Boolean {
        val pattern =
            Pattern.compile("^[A-Za-z0-9][\\w\\._]*[a-zA-Z0-9]+@[A-Za-z0-9-_]+\\.([A-Za-z]{2,4})")
        val mc = pattern.matcher(mail)
        return mc.matches()
    }

    /**
     * 验证姓名，姓名必须为2-5个汉字
     *
     * @param realName
     * @return
     */
    fun judgeRealName(realName: String): Boolean {
        val reg = "\\w+$"
        val pat = Pattern.compile(reg)
        val mat = pat.matcher(realName.trim { it <= ' ' })
        return !TextUtils.isEmpty(realName) && isChinese(realName) && realName.length >= 2 && realName.length <= 5 && mat.matches()
    }

    /**
     * 判断一个字符串是不是都是中文
     *
     * @param content
     * @return
     */
    fun isChinese(content: String): Boolean {
        val charArray = content.toCharArray()
        for (i in charArray.indices) {
            if (!isChinese(charArray[i])) {
                return false
            }
        }
        return true
    }

    /**
     * 判断一个字符是不是中文
     *
     * @param c
     * @return
     */
    private fun isChinese(c: Char): Boolean {
        val ub = Character.UnicodeBlock.of(c)
        return if (ub === Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub === Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub === Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub === Character.UnicodeBlock.GENERAL_PUNCTUATION || ub === Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub === Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
        ) {
            true
        } else false
    }

    /**
     * 检查数据完整性
     *
     * @return
     */
    fun addFormDataWatcher(listener: CheckDataListener, textViews: Array<TextView>) {
        val watcher = FormDataWatcher(textViews, listener)
        for (tv in textViews) {
            if (tv is CheckBox) {
                tv.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (checkData(textViews)) {
                        listener.onComplete()
                    } else {
                        listener.onUnComplete()
                    }
                }
            }
            tv.addTextChangedListener(watcher)
        }
    }

    /**
     * 检查所有传入的控件，如果有任意一个TextView的内容为空则返回false
     *
     * @param textViews
     * @return
     */
    private fun checkData(textViews: Array<TextView>): Boolean {
        for (tv in textViews) {
            if (tv is CheckBox) {
                return if (tv.isChecked) {
                    true
                } else {
                    false
                }
            } else {
                if (TextUtils.isEmpty(tv.text)) {
                    return false
                }
            }
        }
        return true
    }

    /**
     * 判断是否为纯数字，如果是返回true
     *
     * @param str
     * @return
     */
    fun isNumeric(str: String?): Boolean {
//        Pattern pattern = Pattern.compile("[0-9]*");
        val pattern = Pattern.compile("-?[0-9]+.?[0-9]+")
        val isNum = pattern.matcher(str)
        return isNum.matches()
    }

    interface CheckDataListener {
        fun onComplete() //已完成
        fun onUnComplete() //未完成
    }

    private class FormDataWatcher(
        private val textViews: Array<TextView>,
        private val listener: CheckDataListener
    ) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable) {
            if (checkData(textViews)) {
                listener.onComplete()
            } else {
                listener.onUnComplete()
            }
        }
    }
}