package ru.shop.oauthserver.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.shop.base.exceptions.BadRequestException;
import ru.shop.dbtools.models.user.AppUser;
import ru.shop.dbtools.models.user.AuthoritiesEnum;
import ru.shop.oauthserver.principal.UserPrincipal;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    @Value("app.jwtExpirationInMs")
    private long EXPIRATION_TIME;

    @Value("app.jwtSecret")
    private String SECRET_WORD;

    @Value("header.string")
    private String HEADER_STRING;

    @Value("app.jwtTokenPrefix")
    private String TOKEN_PREFIX;

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {


        try {
            AppUser creds = new ObjectMapper()
                    .readValue(request.getInputStream(), AppUser.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword(),
                            creds.getRole().getAuthorities().stream().map(this::getGrantedAuthority).collect(Collectors.toSet()
                            )
                    )
            );

        } catch (IOException e) {
            throw new BadRequestException();
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        Date now = new Date();
        Date validity = new Date(now.getTime() + EXPIRATION_TIME);
        Claims claims = Jwts.claims().setSubject(((User) authResult.getPrincipal()).getUsername());
        claims.put("authorities", ((UserPrincipal) authResult.getPrincipal()).getAuthorities());


        String token = Jwts.builder()
                .addClaims(claims)
                .setExpiration(validity)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, SECRET_WORD)
                .compact();
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);

    }

    private SimpleGrantedAuthority getGrantedAuthority(AuthoritiesEnum authority) {
        return new SimpleGrantedAuthority(authority.name());
    }


}
