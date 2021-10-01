package com.visen.homemoudle.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用正则表达式验证输入格式
 *
 * @author yanyy
 */
public class RegexValidateUtil {
    public static void main(String[] args) {
        System.out.println(checkEmail("14_8@qw.df"));
        System.out.println(checkMobileNumber("13333333333"));
        System.out.println(checkCharacter("sdf&dhdsSDF12"));
    }

    /**
     * 验证合法字符
     *
     * @param character
     * @return
     */
    public static boolean checkCharacter(String character) {
        boolean flag = false;
        try {
            String check = "[a-zA-Z0-9_]{4,20}";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(character);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证合法字符
     *
     * @param character
     * @return
     */
    public static boolean checkCharacterx(String character) {
        boolean flag = false;
        try {
            String check = "[a-zA-Z0-9_]{2,}";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(character);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证合法密碼
     *
     * @param character
     * @return
     */
    public static boolean checkPassWork(String character) {
        boolean flag = false;
        try {
            String check = "[a-zA-Z0-9_]{6,20}";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(character);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证合法密碼
     *
     * @param character
     * @return
     */
    public static boolean checkWeiXin(String character) {
        boolean flag = false;
        try {
            String check = "[a-zA-Z0-9]{5,}";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(character);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证手机号码
     *
     * @param mobileNumber
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        boolean flag = false;
        try {
            Pattern regex = Pattern
                    .compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证合法字符
     *
     * @param search
     * @return
     */
    public static boolean checkSearch(String search) {
        boolean flag = false;
        try {
            String check = "[\\u4e00-\\u9fa5a-zA-Z0-9]{2,10}";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(search);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static boolean checkNumberQQ(String qq) {
        boolean flag = false;
        try {
            Pattern regex = Pattern.compile("/^[1-9][0-9]{5,10}$/");
            Matcher matcher = regex.matcher(qq);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}