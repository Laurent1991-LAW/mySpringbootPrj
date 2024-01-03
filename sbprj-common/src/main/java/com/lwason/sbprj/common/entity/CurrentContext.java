package com.lwason.sbprj.common.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CurrentContext {

    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();
    private static final String GLOBAL_BUSI_TRACK_NO = "GLOBAL_BUSI_TRACK_NO";
    private static final String USER_INFO = "USER_INFO";

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (Objects.isNull(map)) {
            map = new HashMap<>(2);
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (Objects.isNull(map)) {
            map = new HashMap<>(2);
            threadLocal.set(map);
        }
        return ((Map)map).get(key);
    }

    public static String getGlobalBusiTrackNo() {
        return (String) get(GLOBAL_BUSI_TRACK_NO);
    }

    public static UserInfo getUserInfo() {
        return (UserInfo) get(USER_INFO);
    }
}
