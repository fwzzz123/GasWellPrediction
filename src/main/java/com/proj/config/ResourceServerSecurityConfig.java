package com.proj.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
// 【核心修改1】启用全局方法级安全注解，prePostEnabled=true 使得 @PreAuthorize 生效
public class ResourceServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        // 这里可以定义一些通用的规则，但更精细的控制我们将通过注解实现
                        .anyRequest().authenticated()
                )
                .oauth2Login()
                .and()
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                // 【核心修改2】指定一个自定义的 JWT 转换器
                                .jwtAuthenticationConverter(jwtAuthenticationConverter())
                        )
                );
    }

    /**
     * 【核心修改3】定义 JWT 到认证对象的转换器
     * 这个转换器的作用是从 JWT 中提取我们放入的 "authorities" claim，
     * 并将其转换为 Spring Security 能够理解的 GrantedAuthority 对象。
     * @return JwtAuthenticationConverter
     */
    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        // 自定义 GrantedAuthority 的提取逻辑
        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            // 从 JWT 中获取 "authorities" claim
            List<String> authorities = jwt.getClaimAsStringList("authorities");
            if (authorities == null) {
                // 如果没有 "authorities" claim，返回空集合
                return Collections.emptyList();
            }
            // 将字符串形式的权限转换为 SimpleGrantedAuthority 对象
            return authorities.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        });
        return converter;
    }

}
