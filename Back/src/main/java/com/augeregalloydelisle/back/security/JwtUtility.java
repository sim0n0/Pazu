package com.augeregalloydelisle.back.security;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtility {
    private final static String SECRET = "JHHOHHUHIOUHINOONONTDXTRDCPOOPKPYTFYTFTY";
    public String generatetoken(String userName){
        Date dateExpiration = Date.from(LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
    
    String token = Jwts.builder().setSubject(userName).setExpiration(dateExpiration).signWith(SignatureAlgorithm.HS512, SECRET).compact();
  return token ;
    }
    public boolean isTokenValide(String token){
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        }
    catch(Exception e){
        e.printStackTrace();
    }
    return false;
    }
    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
    }
}
