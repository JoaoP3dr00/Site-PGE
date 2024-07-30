package com.example.SitePGE.Config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.SitePGE.entities.Procurador;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Procurador procurador){
        try{
            Algorithm alg = Algorithm.HMAC256(secret);
            String token = JWT.create().withIssuer("login-auth-api").withSubject(procurador.getProcuradoremail())
            .withExpiresAt(this.generateExpirationDate()).sign(alg);
            return token;
        }catch(JWTCreationException e){
            throw new RuntimeException("Error while creating JWT: " + e);
        }
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-3"));
    }

    public String validateToken(String token){
        try{
            Algorithm alg = Algorithm.HMAC256(secret);
            return JWT.require(alg).withIssuer("login-auth-api").build().verify(token).getSubject();
        }catch(JWTVerificationException e){
            return null;
        }
    }
}
