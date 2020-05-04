package com.linked.dazhongdianpingapi.system.util.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.UUID;

/**
 * @author Linked
 * @date 2020/5/4 17:00
 */
public class JWTUtil {

    /**
     * JWT 密钥
     */
    private static final String secret = "LINKED2019NICENICE";

    /**
     * @author Linked
     * @date 2020/5/4 17:00
     */
    public static String createToken(){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        //TODO Cookie 此处需要确认是否允许多点登陆
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return JWT.create().withClaim("uuid", uuid).sign(algorithm);
    }

    /**
     * @Author: Cookie
     * @Date: 2019/1/15 17:38
     * @Description: 验证token是否合法
     */
    public static Boolean checkToken(String token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
        try {
            jwtVerifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}
