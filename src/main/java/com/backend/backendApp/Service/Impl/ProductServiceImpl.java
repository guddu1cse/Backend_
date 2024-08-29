package com.backend.backendApp.Service.Impl;

import com.backend.backendApp.Entity.Product;
import com.backend.backendApp.Repo.ProductRepo;
import com.backend.backendApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProduct(String productId) {

        return productRepo.findById(productId).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setId(UUID.randomUUID().toString());
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        productRepo.save(product);
        return product;
    }

    @Override
    public String deleteProduct(String productId) {
        Product product = productRepo.findById(productId).orElse(null);
        if(product == null) return "product is not found with given id";
        productRepo.delete(product);
        return productId + " is Deleted";
    }
}
