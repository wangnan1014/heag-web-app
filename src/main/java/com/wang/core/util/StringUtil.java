package com.wang.core.util;
import org.apache.commons.lang.StringUtils;
/**
 * Created by Administrator on 2017/7/9.
 * 字符串工具类
 */
public final class StringUtil {
    /**
     * 判断字符是否为空
     */
    public static boolean isEmpty(String strValue){
        if(strValue != null){
            strValue = strValue.trim();
        }
        return StringUtils.isEmpty(strValue);
    }
    /**
     * 判断字符是否非空
     */
    public static boolean isNotEmpty(String strValue){
        if(strValue != null){
            strValue = strValue.trim();
        }
        return !StringUtils.isEmpty(strValue);
    }
}
