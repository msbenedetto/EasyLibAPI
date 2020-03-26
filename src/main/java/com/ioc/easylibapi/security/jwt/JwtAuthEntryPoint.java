package com.ioc.easylibapi.security.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //TODO should add here logger in case if we want to register failed auth ..
        System.out.println("Jwt authentication failed:" + e);
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Jwt authentication failed");
    }
}
