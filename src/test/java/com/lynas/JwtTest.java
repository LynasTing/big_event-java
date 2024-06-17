package com.lynas;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
  // @Test
  // public void testGen() {
  //   // 定义一个Map
  //   Map<String, Object> claims = new HashMap<>();
  //   claims.put("id", 1);
  //   claims.put("name", "张三");
  //   // 生成JWT代码
  //   String token = JWT.create()
  //     .withClaim("user", claims) // 添加载荷 p1 键名, p2 值
  //     .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 添加过期时间
  //     .sign(Algorithm.HMAC256("lynas")); // 签名, 传入加密方法，并传入密钥
  //   // token组成： 1.header(头) 令牌类型和签名算法等 2.payload(载荷) 携带自定义的信息 3.signature(签名) 由头部和载荷加密计算得出
  //   System.out.println(token);
  // }

  // @Test
  // public void testParse() {
  //   String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
  //     ".eyJ1c2VyIjp7Im5hbWUiOiLlvKDkuIkiLCJpZCI6MX0sImV4cCI6MTcxNzU3NzkwNn0" +
  //     ".PPmXbBGxByFYAMfifP7myJPtIb9yoYyDrUaKTEVj_pM";
  //   // 申请一个jwt验证器，传入一个算法，生成token用的什么算法，这里就传什么，并保持密钥一致
  //   JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("lynas")).build();
  //
  //   // 验证token，生成一个解析后的jwt对象
  //   DecodedJWT decodedJWT = jwtVerifier.verify(token);
  //   Map<String, Claim> claims = decodedJWT.getClaims();
  //   Claim user = claims.get("user");
  //   System.out.println(user);
  //
  //   // 头部、载荷、密钥 校验不过，失败
  //   // token过期，失败
  // }
}
