package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
class SecurityConfiguration {

   // @Bean
   // public PasswordEncoder passwordEncoder() {
    //    return new BCryptPasswordEncoder(10);
    //}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable).build();
//                .authorizeHttpRequests(request -> {
//                    request.requestMatchers("/register").permitAll();
//                    request.requestMatchers("/users")
//                            .hasAnyAuthority("USER", "ADMIN");
//                }).formLogin(Customizer.withDefaults()).build();

    }
}