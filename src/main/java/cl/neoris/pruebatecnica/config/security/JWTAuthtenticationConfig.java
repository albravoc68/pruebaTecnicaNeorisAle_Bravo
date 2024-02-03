package cl.neoris.pruebatecnica.config.security;

import io.jsonwebtoken.Jwts;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static cl.neoris.pruebatecnica.config.security.SecurityConstans.TOKEN_EXPIRATION_TIME;
import static cl.neoris.pruebatecnica.config.security.SecurityConstans.getSigningKey;

@Configuration
public class JWTAuthtenticationConfig {

    public String getJWTToken(String username) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .id("neorisJWT")
                .subject(username)
                .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                .signWith(getSigningKey(), Jwts.SIG.HS512)
                .compact();

        return "Bearer " + token; 
    }
}