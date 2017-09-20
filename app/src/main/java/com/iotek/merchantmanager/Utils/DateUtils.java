package com.iotek.merchantmanager.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2017/9/20.
 */

public class DateUtils {

    public static String getSysDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    public static String dateFormat(long inTimeInMillis ){
        Date date = new Date(inTimeInMillis);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String a1=dateFormat.format(date);
        return a1;
    }

}
