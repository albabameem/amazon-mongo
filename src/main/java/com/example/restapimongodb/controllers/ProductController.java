package com.example.restapimongodb.controllers;


import com.example.restapimongodb.CustomizedResponse;
import com.example.restapimongodb.models.Product;
import com.example.restapimongodb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity getProducts()
    {

        var customizedResponse = new CustomizedResponse("A list of products",service.getProducts());

        return new ResponseEntity(customizedResponse,HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getAProduct(@PathVariable("id") String id)
    {

        var customizedResponse = new CustomizedResponse("Product with id :"+id, Collections.singletonList(service.getAProduct(id)));

        return new ResponseEntity(customizedResponse,HttpStatus.OK);
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteAProduct(@PathVariable("id") String id)
    {
        service.deleteAProduct(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/products",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addProduct(@RequestBody Product product)
    {

        service.insertIntoProducts(product);

        return  new ResponseEntity(product,HttpStatus.OK);

    }


    //CORS



}