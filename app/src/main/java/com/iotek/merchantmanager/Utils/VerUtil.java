package com.iotek.merchantmanager.Utils;

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * Created by admin on 2017/9/29.
 */

public class VerUtil {

    /**
     * 判断手机号码是否有效
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
}
