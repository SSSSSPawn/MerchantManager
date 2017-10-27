package com.iotek.merchantmanager.Utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2017/9/20.
 */

public class DateUtils {

    public static String getSysDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    public static String dateFormat(long inTimeInMillis) {
        Date date = new Date(inTimeInMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String a1 = dateFormat.format(date);
        return a1;
    }

    public static String dateFormat(long inTimeInMillis,String format){
        Date date = new Date(inTimeInMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String a1 = dateFormat.format(date);
        return a1;
    }

    public static String dateFormatDay(long inTimeInMillis) {
        Date date = new Date(inTimeInMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String a1 = dateFormat.format(date);
        return a1;
    }

    public static String dateFormatMonth(long inTimeInMillis) {
        Date date = new Date(inTimeInMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        String a1 = dateFormat.format(date);
        return a1;
    }

    public static String formatMoney(double monty) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(); //建立货币格式化引用
        String string = Double.toString(monty);
        BigDecimal bigDecimal = new BigDecimal(string);
        return nf.format(bigDecimal);
    }
}
