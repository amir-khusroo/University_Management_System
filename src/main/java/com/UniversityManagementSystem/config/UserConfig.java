package com.UniversityManagementSystem.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@RequiredArgsConstructor
public class UserConfig {

    private final PasswordEncoder passwordEncoder;

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1= User.withUsername("admin1").password(passwordEncoder.encode("pass1")).roles("ADMIN").build();
        UserDetails user2= User.withUsername("admin2").password(passwordEncoder.encode("pass2")).roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user1,user2);
    }
}
