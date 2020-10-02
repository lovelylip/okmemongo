package com.okme.fam.security.jwt;

import com.google.common.base.Strings;
import com.okme.fam.config.ApplicationProperties;
import com.okme.fam.security.SecurityUtils;
import com.okme.fam.service.dto.UserDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Filters incoming requests and installs a Spring Security principal if a header corresponding to a valid user is
 * found.
 */
public class JWTFilter extends GenericFilterBean {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    public static final String AUTHORIZATION_TOKEN = "access_token";

    private final TokenProvider tokenProvider;

    private final ApplicationProperties applicationProperties;

    public JWTFilter(TokenProvider tokenProvider, ApplicationProperties applicationProperties) {
        this.tokenProvider = tokenProvider;
        this.applicationProperties = applicationProperties;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String ticket = httpServletRequest.getParameter("ticket");
        if(!Strings.isNullOrEmpty(ticket)){
            String ipHost = applicationProperties.getHttps() + "://" + httpServletRequest.getServerName();
            if (httpServletRequest.getServerPort() != 80 && httpServletRequest.getServerPort() != 443) {
                ipHost += ":" + httpServletRequest.getServerPort();
            }
            String jwt = tokenProvider.authenByTicketFromCas(ticket, ipHost);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
            servletRequest.setAttribute(AUTHORIZATION_TOKEN, jwt);
            httpServletRequest.getSession().setAttribute(AUTHORIZATION_TOKEN, jwt);
            servletRequest.setAttribute(AUTHORIZATION_HEADER, "Bearer " + jwt);
            Cookie cookie = new Cookie(AUTHORIZATION_HEADER, jwt);
            httpServletResponse.addCookie(cookie);
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
        }else {
            String jwt = resolveToken(httpServletRequest);
            if (StringUtils.hasText(jwt) && this.tokenProvider.validateToken(jwt)) {
                Authentication authentication = this.tokenProvider.getAuthentication(jwt);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        String jwt = null;
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        jwt = request.getParameter(AUTHORIZATION_TOKEN);
        if (StringUtils.hasText(jwt)) {
            return jwt;
        }
        jwt = (String) request.getAttribute(AUTHORIZATION_TOKEN);
        if (StringUtils.hasText(jwt)) {
            return jwt;
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for(int i = 0; i < cookies.length; i++){
                Cookie cookieItem = cookies[i];
                if(cookieItem.getName().equals(AUTHORIZATION_HEADER)){
                    jwt = cookieItem.getValue();
                    break;
                }
            }
        }
        return jwt;
    }
}
