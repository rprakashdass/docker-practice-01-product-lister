package com.prakash.product_lister;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductListController {

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @GetMapping("/addProduct")
    public void addProduct() {
        Product product = new Product();
        product.setName("Added product");
        product.setPrice(10900);

        productRepo.save(product);
    }
}