package ru.shop.oauthserver.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    @Value("header.string")
    private String HEADER_STRING;

    @Value("app.jwtTokenPrefix")
    private String TOKEN_PREFIX;

    @Value("app.jwtSecret")
    private String SECRET_WORD;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request,response);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        Claims claims = Jwts.parser().setSigningKey(SECRET_WORD).parseClaimsJws(token).getBody();


        if (token != null) {
            String username = claims.getSubject();
            Set<GrantedAuthority> authorities= (Set<GrantedAuthority>) claims.get("authorities");


            if (username != null) {
                return new UsernamePasswordAuthenticationToken(username, "" , authorities);
            }
            return null;
        }
        return null;
    }
}
