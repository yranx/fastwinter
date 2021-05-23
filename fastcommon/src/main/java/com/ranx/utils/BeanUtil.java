package com.ranx.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ranx.zhao
 * @date 2021/4/27 18:04
 * description:
 */
public class BeanUtil {

    /**
     *  将Object对象里面的属性和值转化成Map对象
     * @param obj
     * @return
     */
    public static Map<String, Object> parseObj2MapByJson(Object obj) {
        Map<String, Object> stringObjectMap = JSON.parseObject(JSON.toJSONString(obj), new TypeReference<Map<String, Object>>() {});
        return stringObjectMap;
    }

    public static Map<String, Object> parseObj2Map(Object args) {
        return Arrays.stream(BeanUtils.getPropertyDescriptors(args.getClass()))
                .filter(pd -> !"class".equals(pd.getName()))
                .collect(HashMap::new,
                        (map, pd) -> map.put(pd.getName(), ReflectionUtils.invokeMethod(pd.getReadMethod(), args)),
                        HashMap::putAll);
    }
}
