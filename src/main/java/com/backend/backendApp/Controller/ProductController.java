package com.backend.backendApp.Controller;

import com.backend.backendApp.Entity.Product;
import com.backend.backendApp.Service.ProductService;
import com.backend.backendApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
        productService.createProduct(product);
        return new ResponseEntity<>(product , HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable String productId){

        return new ResponseEntity<>(productService.getProduct(productId) , HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getProducts() , HttpStatus.OK);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return new ResponseEntity<>(product , HttpStatus.OK);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productId){
        return new ResponseEntity<>(productService.deleteProduct(productId) , HttpStatus.ACCEPTED);
    }
}
