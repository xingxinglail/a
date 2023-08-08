package com.github.star.a.util;

import org.springframework.core.NamedThreadLocal;

public class NamedThreadLocalUtil {

    static private final NamedThreadLocal<Integer> threadLocal = new NamedThreadLocal<>("authThreadLocal");

    static public void set(Integer value) {
        threadLocal.set(value);
    }

    static public Integer get() {
        return threadLocal.get();
    }
}
