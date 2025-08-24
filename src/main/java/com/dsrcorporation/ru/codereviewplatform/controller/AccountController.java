package com.dsrcorporation.ru.codereviewplatform.controller;

import com.dsrcorporation.ru.codereviewplatform.model.dto.AccountDto;
import com.dsrcorporation.ru.codereviewplatform.security.jwt.JwtService;
import com.dsrcorporation.ru.codereviewplatform.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для работы с аккаунтами.
 */
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @PostMapping("/signup")
    public ResponseEntity<Long> save(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.save(accountDto), HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AccountDto accountDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(accountDto.getName(), accountDto.getPassword())
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(accountDto.getName());
        return new ResponseEntity<>(jwtService.generateToken(userDetails), HttpStatus.OK);
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }
}
