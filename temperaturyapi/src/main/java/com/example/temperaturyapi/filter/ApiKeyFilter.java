package com.example.temperaturyapi.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

    @Value("${api.key}")
    private String apiKey;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("Przechwycono: " + request.getRequestURI());

        String key = request.getHeader("X-API-Key");

       if (request.getRequestURI().equals("/dodaj")) {

    System.out.println("Klucz z nagłówka: " + key);

    if (!apiKey.equals(key)) {
        System.out.println("Niepoprawny API Key");

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Brak dostępu");
        return;
    }

    System.out.println("Poprawny API Key");
}

        filterChain.doFilter(request, response);
    }
}