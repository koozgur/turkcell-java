package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.services.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    //manage endpoint


    //dependency injection, you should call Service without depending on implementation class
    //not calling new to make changes easier.

    //@Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping //mappers provide translation between objects and JSON
    public void add(@RequestBody Product product){

        //business flow
        productService.add(product);


    }

    @GetMapping
    public List<Product> get(){

        return productService.getAll();
    }

}
