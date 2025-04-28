package com.example.demo.controllers;

import com.example.demo.domain.user.DadosloginDto;
import com.example.demo.infra.auth.TokenJwtDto;
import com.example.demo.domain.user.User;
import com.example.demo.infra.auth.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;

@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadosloginDto dadosLogin) {
        var authToken = new UsernamePasswordAuthenticationToken(dadosLogin.login(), dadosLogin.password());
        var auth = manager.authenticate(authToken);

        var token = tokenService.tokenGenerator((User) auth.getPrincipal());

        return ResponseEntity.ok(new TokenJwtDto(token));
    }



}
