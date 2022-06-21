package com.zbl.util;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/6/21 19:40
 */
public class MapUtil {

    static class User {
        private String name;

        private Integer age;

        private Long userId;
    }

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println((char) ('A' + 32));
        User user = new User();

        HashMap<Object, Object> map = new HashMap<>();
        map.put("age", 19);
        map.put("name", "xiaoming");
        map.put("user_id", 808L);

        toBean(map, user);
    }

    public static <T> void toBean(Map<?, ?> map, T bean) throws IllegalAccessException {
        Class<?> clazz = bean.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            Object val = getFieldValue(map, field.getName());
            if (null == val) {
                continue;
            }
            field.setAccessible(true);
            field.set(bean, val);
        }
    }

    private static Object getFieldValue(Map<?, ?> map, String fieldName) {
        Object val = map.get(fieldName);
        if (null == val) {
            val = map.get(StrUtil.toUnderlineStr(fieldName));
        }
        return val;
    }


    public static <T> T toBean(Map<?, ?> map, Class<T> beanClass) {
        return reflectNewInstance(beanClass);
    }

    private static <T> T reflectNewInstance(Class<T> beanClass) {
        if (null == beanClass) {
            throw new RuntimeException("bean type must not be null!");
        }

        if (beanClass.isPrimitive()) {
            return (T) getPrimitiveDefaultValue(beanClass);
        }

        // 某些特殊接口的实例化按照默认实现进行
        if (beanClass.isAssignableFrom(AbstractMap.class)) {
            beanClass = (Class<T>) HashMap.class;
        } else if (beanClass.isAssignableFrom(List.class)) {
            beanClass = (Class<T>) ArrayList.class;
        } else if (beanClass.isAssignableFrom(Set.class)) {
            beanClass = (Class<T>) HashSet.class;
        }


        return null;
    }

    /**
     * 获取指定原始类型分的默认值<br>
     * 默认值规则为：
     *
     * <pre>
     * 1、如果为原始类型，返回0
     * 2、非原始类型返回{@code null}
     * </pre>
     *
     * @param beanClass class类
     * @return 默认值
     */
    private static Object getPrimitiveDefaultValue(Class<?> beanClass) {
        if (long.class == beanClass) {
            return 0L;
        } else if (int.class == beanClass) {
            return 0;
        } else if (short.class == beanClass) {
            return (short) 0;
        } else if (char.class == beanClass) {
            return (char) 0;
        } else if (byte.class == beanClass) {
            return (byte) 0;
        } else if (double.class == beanClass) {
            return 0D;
        } else if (float.class == beanClass) {
            return 0f;
        } else if (boolean.class == beanClass) {
            return false;
        }
        return null;
    }
}
