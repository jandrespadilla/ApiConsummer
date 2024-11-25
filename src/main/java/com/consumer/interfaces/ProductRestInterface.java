package com.consumer.interfaces;

import com.consumer.models.Product;

import java.util.List;

public interface ProductRestInterface {
    public List<Product> getAllProduct();
    public Product getProductByID(String id);
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(String id);
}
