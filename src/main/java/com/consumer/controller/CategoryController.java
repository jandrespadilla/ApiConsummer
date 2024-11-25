package com.consumer.controller;

import com.consumer.models.Category;
import com.consumer.models.User;
import com.consumer.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Category>> getAllCategory(){
        try {
            List<Category> categories = categoryService.getAllCategory();
            return ResponseEntity.ok(categories);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Category> getCategotyById(@PathVariable String id){
        try {
            Category category = categoryService.getCategoryByID(id);
            return ResponseEntity.ok(category);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        try {
            Category createdCategory1 = categoryService.addCategory(category);
            return ResponseEntity.ok(createdCategory1);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Category> updateCategory(@PathVariable String id, @RequestBody Category category){
        try {
            category.setId(id);
            Category updateCategory1 = categoryService.updateCategory(category);
            return ResponseEntity.ok(updateCategory1);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
        try {
            categoryService.deleteCategory(id) ;
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
