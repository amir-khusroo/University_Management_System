package com.UniversityManagementSystem.config;

import com.UniversityManagementSystem.entity.User;
import com.UniversityManagementSystem.enums.Role;
import com.UniversityManagementSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.username}")
    private String username;

    @Value("${admin.password}")
    private String password;

    @Override
    public void run(String... args) throws Exception {
        boolean exists=userRepository.findByUsername(username).isPresent();
        if(exists) return;
        User admin=User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(Role.ADMIN)
                .build();
        userRepository.save(admin);
    }
}
