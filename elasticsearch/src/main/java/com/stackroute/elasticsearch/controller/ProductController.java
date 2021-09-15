package com.stackroute.elasticsearch.controller;

import com.stackroute.elasticsearch.exception.SearchProductNotFound;
import com.stackroute.elasticsearch.model.Product;
import com.stackroute.elasticsearch.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //getting a product with id
    @GetMapping("/{id}")
    public Map<String, Object> getProductById(@PathVariable UUID id){
        return productRepository.getProductById(id);
    }


    //inserting product
    @PostMapping
    public Product insertProduct(@RequestBody Product product) throws Exception {
        return productRepository.insertProduct(product);
    }
    //update a product
    @PutMapping("/{id}")
    public Map<String, Object> updateProductById(@RequestBody Product product, @PathVariable UUID id) {
        return productRepository.updateProductById(id, product);
    }

    //deletion of a product
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable UUID id) {
        productRepository.deleteProductById(id);
    }

    //queries
    @GetMapping("/search/{queries}")
    public List<Product> ProductSearch(@PathVariable String queries) throws SearchProductNotFound {
        System.out.println("\n\n\nInside Product Service.Ths is what we have got from product query :  " + queries);
        String text = "";
        System.out.println("\n\nReturnning back to productquery service");
        return productRepository.findProduct(queries);
    }

}
