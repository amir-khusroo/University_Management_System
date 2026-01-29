package com.UniversityManagementSystem.service;

import com.UniversityManagementSystem.requestDto.LoginRequestDto;
import com.UniversityManagementSystem.responseDto.LoginResponseDto;
import com.UniversityManagementSystem.security.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword()));
        UserDetails userDetails= (UserDetails) authentication.getPrincipal();

        String token=authUtil.generateToken(userDetails);

        return new LoginResponseDto(token,userDetails.getUsername());
    }
}
