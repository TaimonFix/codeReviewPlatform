package com.dsrcorporation.ru.codereviewplatform.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;


/**
 * Сервис для работы с JWT-токенами.
 */
@Service
public class JwtService {

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.expiration-time}")
    private long expirationTime;

    /**
     * Генерация токена.
     *
     * @param userDetails данные о пользователе.
     * @return токен.
     */
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSignInKey()) // HMAC-SHA256
                .compact();
    }

    /**
     * Получение имени пользователя из токена.
     *
     * @param token токен.
     * @return имя пользователя.
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Извлечение claims (payload токена).
     *
     * @param token токен
     * @param claimsResolver функция для извлечения конкретного объекта.
     * @return извлеченное значение.
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Проверка валидности токена.
     *
     * @param token токен.
     * @param userDetails данные о пользователе.
     * @return true (если валиден).
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    /**
     * Проверка на истечение токена.
     *
     * @param token токен.
     * @return true (если истек).
     */
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Дата истекания токена.
     *
     * @param token токен.
     * @return дата истекания токена.
     */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Получить все все claims (payload токена).
     *
     * @param token токен.
     * @return {@link Claims} payload токена.
      */
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Генерация секретного ключа.
     *
     * @return {@link SecretKey} ключ
     */
    private SecretKey getSignInKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}
