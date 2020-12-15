package com.augeregalloydelisle.back.security;

import java.io.IOException;
import java.time.ZonedDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.augeregalloydelisle.back.exception.ErrorResponse;
import static org.springframework.util.StringUtils.hasText;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (hasText(token) && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = getToken(request);
        if (token != null && jwtUtility.isTokenValide(token)) {
            try {
                String userName = jwtUtility.getUserNameFromToken(token);
                MyUserDetails userDetails = myUserDetailsService.loadUserByUsername(userName);

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null,
                        userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
                request.setAttribute("userName", userDetails.getUsername());

            } catch (Exception e) {
                ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.FORBIDDEN,
                        HttpStatus.FORBIDDEN.value(), ZonedDateTime.now());
                response.setStatus(HttpStatus.FORBIDDEN.value());
                response.getWriter().write(String.valueOf(errorResponse));
            }

        }
        filterChain.doFilter(request, response);

    }

}
