package com.example.restapimongodb.controllers;


import com.example.restapimongodb.CustomizedResponse;
import com.example.restapimongodb.models.Category;
import com.example.restapimongodb.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
public class CategoryController
{
    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public ResponseEntity getCategories()
    {

        var customizedResponse = new CustomizedResponse("A list of categories",service.getCategories());

        return new ResponseEntity(customizedResponse,HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity getACategory(@PathVariable("id") String id)
    {

        var customizedResponse = new CustomizedResponse("Category with id :"+id, Collections.singletonList(service.getACategory(id)));

        return new ResponseEntity(customizedResponse,HttpStatus.OK);
    }


    @DeleteMapping("/categories/{id}")
    public ResponseEntity deleteACategory(@PathVariable("id") String id)
    {
        service.deleteACategory(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/categories",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addCategory(@RequestBody Category category)
    {

        service.insertIntoCategories(category);

        return  new ResponseEntity(category,HttpStatus.OK);

    }


    //CORS



}