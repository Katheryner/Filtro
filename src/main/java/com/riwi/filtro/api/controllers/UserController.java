package com.riwi.filtro.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.filtro.api.dto.request.UserRequest;
import com.riwi.filtro.api.dto.response.UserResp;
import com.riwi.filtro.infraestructure.abstract_services.IUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {
    
    private final IUserService user;

    @PostMapping
    public ResponseEntity<UserResp> create(
       @Validated @RequestBody UserRequest request
    ){
        return ResponseEntity.ok(this.user.create(request));
    }
}
