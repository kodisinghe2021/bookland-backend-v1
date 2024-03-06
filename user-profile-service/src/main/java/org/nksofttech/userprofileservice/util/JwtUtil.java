package org.nksofttech.userprofileservice.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.nksofttech.userprofileservice.util.properties.JwtProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class JwtUtil {
  private JwtProperties properties;

  // generating JWT Token
  public String generateToken(UserDetails userDetails){
    // make empty map for store claims
    Map<String,Object> claims = new HashMap<>();
    return createJwtToken(claims, userDetails);
  }

  private String createJwtToken(Map<String, Object> claims, UserDetails userDetails) {
    // Get current UTC time
    Instant now = Instant.now();

    // Convert Instant to Date
    Date issuedAt = Date.from(now);
    System.out.println("The Time token is generated::: "+issuedAt.toString());

    //Set Expiration
    Instant expiration = now.plusSeconds(properties.getTokenValidity()*3600);
    Date expiresAt = Date.from(expiration);

    return Jwts.builder()
            .setClaims(claims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(issuedAt)
            .setExpiration(expiresAt)
            .signWith(SignatureAlgorithm.HS512, properties.getSecretKey())
            .compact();
  }
}
