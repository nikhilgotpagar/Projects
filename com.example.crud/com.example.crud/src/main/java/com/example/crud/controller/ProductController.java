package com.example.crud.controller;

import com.example.crud.entity.Product;
import com.example.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public  List<Product> findAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/product/{ID}")
    public  Product findProductById(@PathVariable int ID){
        return  service.getProductById(ID);
    }

    @GetMapping("/products/{name}")
    public  Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{ID}")
    public  String deleteProduct(@PathVariable int ID){
        return  service.deleteProduct(ID);
    }
}
