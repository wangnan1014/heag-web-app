package com.wang.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/9.
 * 转型操作工具类
 */
public final class CastUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CastUtil.class);
    /**
     * 转String型
     */
    public static String castString(Object  obj){
        return CastUtil.castString(obj,"");
    }
    /**
     * 转String型(提供默认值)
     */
    public static String castString(Object  obj,String defaultValue){
        return obj!=null?String.valueOf(obj):defaultValue;
    }
    /**
     * 转int型
     */
    public static int castInt(Object  obj){
        return CastUtil.castInt(obj,0);
    }
    /**
     * 转int型(提供默认值)
     */
    public static int castInt(Object  obj,int defaultValue){
        int intValue =defaultValue;
        if(obj!=null){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try{
                    intValue = Integer.parseInt(strValue);
                }catch (NumberFormatException e){
                    intValue=defaultValue;
                }
            }
        }
        return intValue;
    }
    /**
     * 转double型
     */
    public static double castDouble(Object  obj){
        return CastUtil.castDouble(obj,0);
    }
    /**
     * 转double型(提供默认值)
     */
    public static double castDouble(Object  obj,double defaultValue){
        double doubleValue = defaultValue;
        if(obj!=null){
            String strValue= castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try {
                    doubleValue = Double.parseDouble(strValue);
                }catch (NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }
    /**
     * 转long型
     */
    public static long castLong(Object  obj){
        return CastUtil.castLong(obj,0);
    }
    /**
     * 转long型(提供默认值)
     */
    public static long castLong(Object  obj,long defaultValue){
        long longValue = defaultValue;
        if(obj!=null){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try{
                    longValue = Long.parseLong(strValue);
                }catch (NumberFormatException e){
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }
    /**
     * 转boolean型
     */
    public static boolean castBoolean(Object  obj){
        return CastUtil.castBoolean(obj,false);
    }
    /**
     * 转long型(提供默认值)
     */
    public static boolean castBoolean(Object  obj,boolean defaultValue){
        boolean longValue = defaultValue;
        if(obj!=null){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try{
                    longValue = Boolean.parseBoolean(strValue);
                }catch (NumberFormatException e){
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }
}
