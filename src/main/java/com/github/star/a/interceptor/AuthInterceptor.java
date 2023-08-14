package com.github.star.a.interceptor;

import com.github.star.a.exception.HttpException;
import com.github.star.a.util.JWTUtil;
import com.github.star.a.util.NamedThreadLocalUtil;
import com.mysql.cj.util.StringUtils;
import io.jsonwebtoken.Claims;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

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
            Claims claims = JWTUtil.getTokenBody(token);
            Integer userId = Integer.valueOf(claims.get("userId").toString());
//            String authType = claims.get("type").toString();
            Integer shopId = Integer.valueOf(claims.get("shopId").toString());
            NamedThreadLocalUtil.set(userId, shopId);
            return true;
        } catch (Exception e) {
            throw new HttpException(HttpStatus.UNAUTHORIZED, "need Authorization", e);
        }
    }
}
