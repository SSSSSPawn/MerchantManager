package com.iotek.merchantmanager.Utils;

import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 */

public class ListUtil {

    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

}
