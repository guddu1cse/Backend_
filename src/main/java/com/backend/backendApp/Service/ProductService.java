package com.backend.backendApp.Service;

import com.backend.backendApp.Entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProduct(String productId);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    String deleteProduct(String productId);
}
