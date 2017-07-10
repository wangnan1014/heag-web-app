package com.wang.core.util;

import org.apache.commons.collections.MapUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/9.
 * 集合工具类
 */
public final class CollectionUtil {
    /**
     * 判断Collection 是否为空
     */
    public static boolean isEmpty(Collection<?> collection){
        return CollectionUtils.isEmpty(collection);
    }
    /**
     * 判断Collection 是否非空
     */
    public static boolean isNotEmpty(Collection<?> collection){
        return !CollectionUtils.isEmpty(collection);
    }
    /**
     * 判断Map 是否为空
     */
    public static boolean isEmpty(Map<?,?> map){
        return MapUtils.isEmpty(map);
    }
    /**
     * 判断Map 是否非空
     */
    public static boolean isNotEmpty(Map<?,?> map){
        return !MapUtils.isEmpty(map);
    }
}
