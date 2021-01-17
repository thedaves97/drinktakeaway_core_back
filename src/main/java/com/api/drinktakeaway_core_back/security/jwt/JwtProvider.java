package com.api.drinktakeaway_core_back.security.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    String secret;

    @Value("${jwt.expiration}")
    int expiration;

    // ! Token generatin
    /**
     * public String generateToken(Authentication authentication) { UtentePrincipal
     * utentePrincipal = (UtentePrincipal) authentication.getPrincipal(); return
     * Jwts.builder().setSubject(utentePrincipal.getUsername()) .setIssuedAt(new
     * Date(System.currentTimeMillis())) .setExpiration(new
     * Date(System.currentTimeMillis() + expiration))
     * .signWith(SignatureAlgorithm.HS512, secret).compact(); }
     **/

    public String getEmailFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException | UnsupportedJwtException | ExpiredJwtException | IllegalArgumentException
                | SignatureException e) {
            logger.error("toker error");
            e.printStackTrace();
        }
        return false;
    }

}
