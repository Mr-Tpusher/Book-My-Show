package com.tpusher.bms.security.jwt;

import com.tpusher.bms.constant.UserRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Component
@Data
public class JwtUtil {

    private final Key key;
    private final long expiration;

    public JwtUtil(
            @Value("${bms.jwt.secret.key}") String secretKey,
            @Value("${bms.jwt.expiration}") long expiration
    ) {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
        this.expiration = expiration;
    }

    public String generateToken(long userId, String userName, UserRole userRole) {
        long now = System.currentTimeMillis();
        Map<String, Object> claims =
                Map.of(
                        "username", userName,
                        "userId", userId,
                        "role", userRole
                );

        String jwt = Jwts.builder()
                .setSubject(userName)
                .setClaims(claims).
                setIssuedAt(new Date(now))
                .setExpiration(new Date(now + expiration))
                .signWith(key)
                .compact();

        return jwt;
    }


    public boolean validateToken(String token) {
        try {
            Claims claims = extractClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public Claims extractClaims(String token) {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
    }

    public UUID extractUserId(String token) {
        return (UUID) extractClaims(token).get("userId");
    }

    public String extractUsername(String token) {
        return extractClaims(token).get("username").toString();
    }

    public UserRole extractUserRole(String token) {
        return (UserRole) extractClaims(token).get("role");
    }
}
