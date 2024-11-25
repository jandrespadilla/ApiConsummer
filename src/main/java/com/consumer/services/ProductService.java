package com.consumer.services;

import com.consumer.apis.ProductRestApi;
import com.consumer.interfaces.ProductRestInterface;
import com.consumer.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements ProductRestInterface {
    @Autowired
    private ProductRestApi productRestApi;
    @Override
    public List<Product> getAllProduct() {
        return productRestApi.getAllProduct();
    }

    @Override
    public Product getProductByID(String id) {
        return productRestApi.getProductByID(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productRestApi.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRestApi.updateProduct(product);
    }

    @Override
    public void deleteProduct(String id) {
            productRestApi.deleteProduct(id);
    }
}
