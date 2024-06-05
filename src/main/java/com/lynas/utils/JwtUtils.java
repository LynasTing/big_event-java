package com.lynas.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lynas.constants.SystemConst;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
  /**
   * 接受业务数据，生成token并返回
   */
  public static String createToken(Map<String, Object> claims) {
    return JWT.create()
      .withClaim(SystemConst.JWT_PAYLOAD_KEY, claims)
      .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
      .sign(Algorithm.HMAC256(SystemConst.JWT_SIGN_KEY));
  }

  /**
   * 验证token，并返回业务数据
   */
  public static Map<String, Object> parseToken(String token) {
    return JWT.require(Algorithm.HMAC256(SystemConst.JWT_SIGN_KEY))
      .build()
      .verify(token)
      .getClaims()
      .get(SystemConst.JWT_PAYLOAD_KEY)
      .asMap();
  }
}
