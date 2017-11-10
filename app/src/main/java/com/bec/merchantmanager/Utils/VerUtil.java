package com.bec.merchantmanager.Utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2017/9/29.
 */

public class VerUtil {

    /**
     * 判断手机号码是否有效
     *
     * @param telNumber
     * @return
     */
    public static boolean isValidTelNumber(String telNumber) {
        if (!TextUtils.isEmpty(telNumber)) {
            String regex = "(\\+\\d+)?1[34578]\\d{9}$";
            return Pattern.matches(regex, telNumber);
        }
        return false;
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
}
