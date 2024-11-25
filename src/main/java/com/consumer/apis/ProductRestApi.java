package com.consumer.apis;

import com.consumer.interfaces.ProductRestInterface;

import com.consumer.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class ProductRestApi implements ProductRestInterface {
    private final String BASE_URL = "http://localhost:8080/api/productos";
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<Product> getAllProduct() {
        try {
            @SuppressWarnings("unchecked")
            List<Product> products= restTemplate.exchange(BASE_URL, HttpMethod.GET,null,List.class).getBody();
            return products;
        }catch (Exception e){
            throw new RuntimeException("Error al obterner los productos. "+e.getMessage(),e);
        }
    }

    @Override
    public Product getProductByID(String id) {
        try {
            String url= BASE_URL+"/"+id;
            return restTemplate.getForObject(url, Product.class);
        }catch (Exception e){
            throw new RuntimeException("Error al obterner el producto. "+e.getMessage(),e);
        }
    }

    @Override
    public Product addProduct(Product product) {
        try {
            return restTemplate.postForObject(BASE_URL,product, Product.class);
        }catch (Exception e){
            throw new RuntimeException("Error al crear el producto. "+e.getMessage(),e);
        }
    }

    @Override
    public Product updateProduct(Product product) {
        try {
            String url = BASE_URL+"/"+product.getId();
            restTemplate.put(url,product);
            return product;
        }catch (Exception e){
            throw new RuntimeException("Error al actualizar el producto. "+e.getMessage(),e);
        }
    }

    @Override
    public void deleteProduct(String id) {
        try {
            String url = BASE_URL+"/"+id;
            restTemplate.delete(url);
        }catch (Exception e){
            throw new RuntimeException("Error al borrar el producto. "+e.getMessage(),e);
        }
    }
}
