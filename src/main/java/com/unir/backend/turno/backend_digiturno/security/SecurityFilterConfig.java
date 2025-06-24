package com.unir.backend.turno.backend_digiturno.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll() // permite /auth y /users sin autenticación
                .requestMatchers("/users/**").permitAll() // permite /auth y /users sin autenticación
                .requestMatchers("/entidad/**").permitAll()
                .anyRequest().authenticated() // cualquier otra ruta sí requiere auth
            );
        return http.build();
    }
}
