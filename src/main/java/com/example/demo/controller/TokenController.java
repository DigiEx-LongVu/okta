package com.example.demo.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TokenController {
    @GetMapping
    public ResponseEntity<?> handle(HttpServletResponse response, Authentication authentication) {
        var token = (DefaultOidcUser) authentication.getPrincipal();
        return  ResponseEntity.ok(token.getIdToken().getTokenValue());
    }
}
