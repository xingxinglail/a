package com.github.star.a.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.util.*;

public class JWTUtil {

    public enum TypeEnum {
        Admin("admin"),

        ShopAdmin("shopAdmin"),

        Client("client");

        final String type;

        TypeEnum(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    private static final int TOKEN_TIME_OUT = 2 * 3600;

    private static final String SECRET = "aproject";

    private static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(SECRET);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    public static String generateToken(Integer userId, TypeEnum type) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("type", type.getType());
        claims.put("userId", userId);
        return Jwts.builder()
                .setIssuer("a")
                .setSubject("hhas")
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_TIME_OUT * 1000))
                .signWith(SignatureAlgorithm.HS256, generalKey())
                .compact();
    }

    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(generalKey())
                .parseClaimsJws(token)
                .getBody();
    }

    public static Integer getUserId(String token) {
        return Integer.valueOf(getTokenBody(token).get("userId").toString());
    }

    public static TypeEnum getType(String token) {
        return TypeEnum.valueOf(getTokenBody(token).get("type").toString());
    }

    public static void main(String[] args) throws InterruptedException {
        String token = generateToken(1, TypeEnum.Admin);
        // Thread.sleep(1200);
        String token2 = generateToken(1, TypeEnum.ShopAdmin);
        System.out.println(token);
        System.out.println(token2);
        System.out.println(getUserId(token));
        System.out.println("getTokenBody(token).getSubject()");
        System.out.println(getTokenBody(token).getSubject());
    }
}
