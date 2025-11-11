package com.happy.controller;

import com.happy.entity.Product;
import com.happy.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {
    @Autowired
    private ProductService productService;

    //add product
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        System.out.println("Product get add ");
        return productService.addProduct(product);
    }

    @GetMapping("/getProductById{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/getallProduct")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @DeleteMapping("delete{id}")
    public Boolean deleteProductById(@PathVariable int id) {
        return productService.deleteById(id);
    }

}
