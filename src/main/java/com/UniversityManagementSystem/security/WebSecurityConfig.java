package com.UniversityManagementSystem.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final CustomUserDetailService customUserDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf-> csrf.disable())
                .sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/faculty/**","/student/**").permitAll()
                        .anyRequest().authenticated()
                );

        return httpSecurity.build();

    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity, InMemoryUserDetailsManager inMemoryUserDetailsManager, PasswordEncoder passwordEncoder) throws Exception {
        AuthenticationManagerBuilder builder= httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);

        DaoAuthenticationProvider adminProvider=new DaoAuthenticationProvider();
        adminProvider.setUserDetailsService(inMemoryUserDetailsManager);
        adminProvider.setPasswordEncoder(passwordEncoder);

        DaoAuthenticationProvider dbProvider=new DaoAuthenticationProvider();
        dbProvider.setUserDetailsService(customUserDetailService);
        dbProvider.setPasswordEncoder(passwordEncoder);

        builder.authenticationProvider(adminProvider).authenticationProvider(dbProvider);

        return builder.build();


    }



}
