package com.github.star.a.util;

import lombok.Data;
import org.springframework.core.NamedThreadLocal;

public class NamedThreadLocalUtil {

    @lombok.Data
    private static class Data {
        private Integer userId;

        private Integer shopId;
    }

    static private final NamedThreadLocal<Data> threadLocal = new NamedThreadLocal<>("authThreadLocal");

    static public void set(Integer userId, Integer shopId) {
        Data data = new Data();
        data.setUserId(userId);
        data.setShopId(shopId);
        threadLocal.set(data);
    }

    static public Integer getUserId() {
        return threadLocal.get().getUserId();
    }

    static public Integer getShopId() {
        return threadLocal.get().getShopId();
    }
}
