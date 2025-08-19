package com.proj.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class AuthController {
    @GetMapping("/explain/hello")
    // 方式2：使用 hasRole（会自动添加 ROLE_ 前缀）
    @PreAuthorize("hasRole('ADMIN')")
    public String helloHttps() {
        return "Hello, this is a protected resource for ADMIN only!";
    }
    @GetMapping("/hello")
    public String hello(@AuthenticationPrincipal Jwt jwt) {
        String username = jwt.getSubject(); // 获取用户名
        List<String> authorities = jwt.getClaimAsStringList("authorities");

        if (authorities != null && authorities.contains("ROLE_USER")){
            return "Hello, " + username + " (USER)";
        }
        else if (authorities != null && authorities.contains("ROLE_ADMIN")) {
            return "Hello, " + username + " (ADMIN)";
        }
        else {
            return "Hello, " + username + " (UNKNOWN)";
        }
    }
    @GetMapping("/debug/jwt")
    public Map<String, Object> debugJwt(@AuthenticationPrincipal Jwt jwt) {
        Map<String, Object> result = new HashMap<>();
        result.put("subject", jwt.getSubject());
        result.put("allClaims", jwt.getClaims());
        result.put("roles", jwt.getClaimAsStringList("roles"));
        result.put("authorities", jwt.getClaimAsStringList("authorities"));
        return result;
    }
}
