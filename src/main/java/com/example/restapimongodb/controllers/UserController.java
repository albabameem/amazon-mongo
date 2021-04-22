package com.example.restapimongodb.controllers;


import com.example.restapimongodb.CustomizedResponse;
import com.example.restapimongodb.models.UserModel;
import com.example.restapimongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
public class UserController
{
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity getUsers()
    {

        var customizedResponse = new CustomizedResponse("A list of users",service.getUsers());

        return new ResponseEntity(customizedResponse,HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getAUser(@PathVariable("id") String id)
    {

        var customizedResponse = new CustomizedResponse("User with id :"+id, Collections.singletonList(service.getAUser(id)));

        return new ResponseEntity(customizedResponse,HttpStatus.OK);
    }



    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteAUser(@PathVariable("id") String id)
    {
        service.deleteAUser(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/users",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addUser(@RequestBody UserModel user)
    {

        service.insertIntoUsers(user);

        return  new ResponseEntity(user,HttpStatus.OK);

    }


    //CORS



}