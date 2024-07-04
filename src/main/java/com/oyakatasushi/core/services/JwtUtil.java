package com.oyakatasushi.core.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static final long EXPIRATION_TIME = 86400000; // ==> 24 hours

    public static String generateToken(String email, int userId, String familyName, String firstName) {
        try {
            Map<String, Object> claims = new HashMap<>();
            claims.put("email", email);
            claims.put("userId", userId);
            claims.put("familyName", familyName);
            claims.put("firstName", firstName);

            System.out.println("Claims: " + claims);

            String token = Jwts.builder()
                    .setClaims(claims)
                    .setSubject(email)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();

            System.out.println("JWT Token généré: " + token);
            return token;
        } catch (Exception e) {
            System.err.println("Erreur lors de la génération du token JWT: " + e.getMessage());
            e.printStackTrace();
            return null; // Ou lancez une exception appropriée
        }
    }
}
