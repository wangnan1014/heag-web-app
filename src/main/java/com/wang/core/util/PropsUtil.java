package com.wang.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2017/7/9.
 * 属性文件工具类
 */
public final class PropsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     */
    public static Properties loadProps(String fileName){
        Properties props =null;
        InputStream is= null;
        //返回对当前正在执行的线程对象的上下文ClassLoader(加载类的对象) 中取读取指定资源的输入流
        try {
        is= Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        if(is==null){
                throw new FileNotFoundException(fileName+"file is not found");
        }
        props = new Properties();
        props.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(is!= null){
                 try{
                    is.close();
                 }catch (IOException e){
                     LOGGER.error("close input strem failure",e);
                 }
            }
        }
        return props;
    }
    /**
     * 获取字符型属性（默认为空字符串）
     */
    public static String getString(Properties props,String key){
        return getString(props,key,"");
    }
    /**
     * 获取字符型属性（可指定默认值）
     */
    public static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if(props.contains(key)){
            value=props.getProperty(key);
        }

        return value;
    }
    /**
     * 获取数字型属性（默认为0）
     */
    public static int getInt(Properties props,String key){
        return getInt(props,key,0);
    }
    /**
     * 获取数字型属性（可指定默认值）
     */
    public static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if(props.contains(key)){
            value=CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }
    /**
     * 获取长数字型属性（默认为0）
     */
    public static long getLong(Properties props,String key){
        return getLong(props,key,0);
    }
    /**
     * 获取数字型属性（可指定默认值）
     */
    public static long getLong(Properties props, String key, long defaultValue) {
        long value = defaultValue;
        if(props.contains(key)){
            value=CastUtil.castLong(props.getProperty(key));
        }
        return value;
    }
    /**
     * 获取布尔型属性（默认为false）
     */
    public static boolean getBoolean(Properties props,String key){
        return getBoolean(props,key,false);
    }
    /**
     * 获取布尔型属性（可指定默认值）
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if(props.contains(key)){
            value=CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }
}
