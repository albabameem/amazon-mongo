package com.example.restapimongodb.controllers;

import com.example.restapimongodb.CustomizedResponse;
import com.example.restapimongodb.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@CrossOrigin
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/auth",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity login(@RequestBody UserModel user)
    {
        try {
            UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
            authenticationManager.authenticate(userToken);
            var customizedResponse = new CustomizedResponse("Login successful", null);

            return new ResponseEntity(customizedResponse,HttpStatus.OK);
        }catch (BadCredentialsException ex){
            var customizedResponse = new CustomizedResponse("Login invalid", null);

            return new ResponseEntity(customizedResponse,HttpStatus.UNAUTHORIZED);
        }


    }
}
