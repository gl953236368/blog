package com.px.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtils {
    private static final String CLAIM_ROLE = "px";

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "BASIC ";
    // 时间约束 5天
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 5;

    //jwt密码
    private static final String SECRET = "secret";

    public static String createToken(String username, String role){
        Map<String, Object> claims = new HashMap<>(8);
        // claims 主体
        claims.put(CLAIM_ROLE, role);
        return Jwts.builder()
                .setClaims(claims)
                .claim("username", username)
                .setExpiration(new Date(Instant.now().toEpochMilli() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }

    // 根据token 获得 username
    public static String getUsername(String token) {
        String username = (String) parseToken(token).get("username");
        return username;
    }

    // 根据token获得 roles
    public static String getRoles(String token) {
        String roles = (String) parseToken( token ).get(CLAIM_ROLE);
        return roles;
    }

    // 解析jwt
    private static Claims parseToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }


}
