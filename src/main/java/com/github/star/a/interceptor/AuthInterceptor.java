package com.github.star.a.interceptor;

import com.github.star.a.exception.HttpException;
import com.github.star.a.util.JWTUtil;
import com.github.star.a.util.NamedThreadLocalUtil;
import com.mysql.cj.util.StringUtils;
import org.springframework.core.NamedThreadLocal;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

    final NamedThreadLocal<Integer> threadLocal = new NamedThreadLocal<>("authThreadLocal");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isNullOrEmpty(authorization)) {
            throw new HttpException(HttpStatus.UNAUTHORIZED, "need Authorization");
        }
        String[] split = authorization.split(" ");
        if (!("Bearer".equals(split[0])) || split.length < 2 || StringUtils.isNullOrEmpty(split[1])) {
            throw new HttpException(HttpStatus.UNAUTHORIZED, "need Authorization");
        }
        String token = split[1];
        try {
            Integer userId = JWTUtil.getUserId(token);
            NamedThreadLocalUtil.set(userId);
            return true;
        } catch (Exception e) {
            throw new HttpException(HttpStatus.UNAUTHORIZED, "need Authorization", e);
        }
    }
}
