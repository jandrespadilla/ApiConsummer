package com.consumer.controller;

import com.consumer.models.Product;
import com.consumer.models.User;
import com.consumer.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Product>> getAllProduct(){
        try {
            List<Product> products = productService.getAllProduct();
            return ResponseEntity.ok(products);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> getProductByID(@PathVariable String id){
        try {
            Product product = productService.getProductByID(id);
            return ResponseEntity.ok(product);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        try {
            Product createdProduct = productService.addProduct(product);
            return ResponseEntity.ok(createdProduct);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }


    @PutMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> updateUser(@PathVariable String id, @RequestBody Product product){
        try {
            product.setId(id);
            Product updateProduct = productService.updateProduct(product);
            return ResponseEntity.ok(updateProduct);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable String id){
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
